package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.User;

import java.sql.*;
import oracle.jdbc.OraclePreparedStatement;

public class UserDao {

    public void save(User user) {
        String sql = "INSERT INTO users (user_id, name, email, password, phone_number, address) " +
                "VALUES (SEQ_USER_ID.NEXTVAL, ?, ?, ?, ?, ?) RETURNING user_id INTO ?";

        try (Connection conn = ConnectionFactory.getConnection();
             OraclePreparedStatement stmt = (OraclePreparedStatement) conn.prepareStatement(sql)) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getAddress());

            stmt.registerReturnParameter(6, Types.INTEGER);

            stmt.executeUpdate();

            ResultSet rs = stmt.getReturnResultSet();
            if (rs != null && rs.next()) {
                user.setUserId(rs.getInt(1));
            }
            System.out.println("User successfully saved! ID: " + user.getUserId());

        } catch (SQLException e) {
            System.err.println("Error saving user: " + e.getMessage());
        }
    }

    public User findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM users WHERE email = ? AND password = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new User(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("phone_number"),
                        rs.getString("address")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error searching user: " + e.getMessage());
        }

        return null;
    }
}

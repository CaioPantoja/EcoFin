package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    public void save(Account account) {
        String sql = "INSERT INTO accounts (account_id, user_id, name, balance, account_type, currency) " +
                "VALUES (SEQ_ACCOUNT_ID.NEXTVAL, ?, ?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[] { "account_id" })) {

            stmt.setInt(1, account.getUserId());
            stmt.setString(2, account.getName());
            stmt.setDouble(3, account.getBalance());
            stmt.setString(4, account.getAccountType());
            stmt.setString(5, account.getCurrency());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    account.setId(rs.getInt(1));
                }
            }

            System.out.println("Account succesfully saved!");

        } catch (SQLException e) {
            System.err.println("Error saving Account: " + e.getMessage());
        }
    }

    public Account findByIdAndUserId(int accountId, int userId) {
        String sql = "SELECT * FROM accounts WHERE account_id = ? AND user_id = ?";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, accountId);
            stmt.setInt(2, userId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Account(
                        rs.getInt("account_id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getDouble("balance"),
                        rs.getString("account_type"),
                        rs.getString("currency")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error searching for Account: " + e.getMessage());
        }
        return null;
    }

    public List<Account> findByUserId(int userId) {
        List<Account> accounts = new ArrayList<>();
        String sql = "SELECT * FROM accounts WHERE user_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                accounts.add(new Account(
                        rs.getInt("account_id"),
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getDouble("balance"),
                        rs.getString("account_type"),
                        rs.getString("currency")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Error searching for Accounts: " + e.getMessage());
        }

        return accounts;
    }

    public void updateBalance(Account account) {
        String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDouble(1, account.getBalance());
            stmt.setInt(2, account.getId());

            stmt.executeUpdate();
            System.out.println("New balance updated!");

        } catch (SQLException e) {
            System.err.println("Error updating balance: " + e.getMessage());
        }
    }
}

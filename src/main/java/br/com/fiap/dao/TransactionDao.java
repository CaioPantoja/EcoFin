package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionDao {

    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (transaction_id, account_id, type, amount, transaction_date) VALUES (SEQ_TRANSACTION_ID.NEXTVAL, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'))";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, transaction.getAccountId());
            stmt.setString(2, transaction.getType());
            stmt.setDouble(3, transaction.getAmount());
            stmt.setString(4, transaction.getDate());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Transaction> findByUserId(int userId) {
        List<Transaction> transactions = new ArrayList<>();
        String sql = """
                SELECT t.transaction_id, t.account_id,a.name as account_name, t.type, t.amount, TO_CHAR(t.transaction_date, 'YYYY-MM-DD') AS transaction_date
                FROM transactions t
                JOIN accounts a ON t.account_id = a.account_id
                WHERE a.user_id = ?
                """;

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Transaction t = new Transaction(
                        rs.getInt("transaction_id"),
                        rs.getInt("account_id"),
                        rs.getString("account_name"),
                        rs.getString("type"),
                        rs.getDouble("amount"),
                        rs.getString("transaction_date")
                );
                transactions.add(t);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}

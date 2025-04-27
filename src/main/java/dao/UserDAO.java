package dao;

import database.DatabaseConnection;
import java.sql.Connection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
    public static void createUser(User user) throws Exception {
        String sql = "INSERT INTO tb_users (name, password) VALUES (?, ?)";
        
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, hash);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO CRIAR USUÁRIO PELO ID: " + e.getMessage());
        }
    }

    public static User getByName(String name) throws Exception {
        String sql = "SELECT * FROM tb_users WHERE name = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, name);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO OBTER USUÁRIO PELO ID: " + e.getMessage());
        }
        return null;
    }
    
    	public boolean validateLogin(User user) {
		String sql = "SELECT password FROM tb_users WHERE name = ?";
		try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql)) {
         
			stmt.setString(1, user.getName());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return BCrypt.checkpw(user.getPassword(), rs.getString("senha"));
			}
		} catch (SQLException e) {
			e.printStackTrace(); // Exibe o erro no console
		}
		return false; // Retorna false caso não encontre o usuário ou ocorra um erro
	}
}

package dao;

import database.DatabaseConnection;
import java.sql.Connection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mindrot.jbcrypt.BCrypt;

public class UserDAO {
    private Connection conn = DatabaseConnection.getConnection();
    
    
    public void createUser(User user) throws Exception {
        String sql = "INSERT INTO tb_users (name, password) VALUES (?, ?)";
        
        String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, hash);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO CRIAR USUÁRIO PELO ID: " + e.getMessage());
        }
    }

    public User getByName(String name) throws Exception {
        String sql = "SELECT * FROM tb_users WHERE name = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
	try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        
            stmt.setString(1, user.getName());
	    ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
		return BCrypt.checkpw(user.getPassword(), rs.getString("password"));
            }
	} catch (SQLException e) {
            e.printStackTrace(); // Exibe o erro no console
	}
	return false; // Retorna false caso não encontre o usuário ou ocorra um erro
    }
    
    public void deleteUser(int id) throws Exception {
        String sql = "DELETE FROM tb_users WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Nenhum usuário encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO DELETAR USUÁRIO: " + e.getMessage());
        }
    }

    public void updateUserName(int id, String newName) throws Exception {
        String sql = "UPDATE tb_users SET name = ? WHERE id = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Nenhum usuário encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO ATUALIZAR NOME DO USUÁRIO: " + e.getMessage());
        }
    }

    public void updateUserPassword(int id, String newPassword) throws Exception {
        String sql = "UPDATE tb_users SET password = ? WHERE id = ?";

        String hash = BCrypt.hashpw(newPassword, BCrypt.gensalt());

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hash);
            stmt.setInt(2, id);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Nenhum usuário encontrado com o ID: " + id);
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO ATUALIZAR SENHA DO USUÁRIO: " + e.getMessage());
        }
    }
}

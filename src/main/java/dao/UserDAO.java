package dao;

import database.DatabaseConnection;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static void criarUsuario(User user) throws Exception {
        String sql = "INSERT INTO usuer (name, password) VALUES (?, ?)";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO CRIAR USUÁRIO PELO ID: " + e.getMessage());
        }
    }

    public static User obterUsuarioPeloNome(String name) throws Exception {
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
}

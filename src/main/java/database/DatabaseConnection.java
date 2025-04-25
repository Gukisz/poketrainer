package database;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String DB_URL = dotenv.get("URL");
    private static final String DB_USER = dotenv.get("USER");
    private static final String DB_PASSWORD = dotenv.get("PASSWORD");

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                createTableUsers();
                createTablePokemon();
                System.out.println("✅ Conexão com o banco de dados estabelecida!");
            } catch (SQLException e) {
                System.out.println("❌ Erro ao conectar com o banco de dados:");
                e.printStackTrace();
            }
        }
        return connection;
    }

    private static void createTableUsers() {
        String sql = "CREATE TABLE IF NOT EXISTS tb_users(" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL UNIQUE,"+
                "password VARCHAR(255) NOT NULL)";

        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso");
        } catch(Exception e) {
            System.out.println("Erro ao criar tabela" + e.getMessage());
        }
    }

    private static void createTablePokemon() {
        String sql = "CREATE TABLE IF NOT EXISTS tb_pokemon (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL," +
                "type VARCHAR(255) NOT NULL," +
                "level INT NOT NULL" +
                "user_id INT NOT NULL," +
                " FOREIGN KEY (user_id) REFERENCES tb_users(id) ON DELETE CASCADE);";

        try (Statement stmt = getConnection().createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso");
        } catch(Exception e) {
            System.out.println("Erro ao criar tabela" + e.getMessage());
        }
    }
}
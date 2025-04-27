package dao;

import database.DatabaseConnection;
import model.Pokemon;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonDAO {

    public static void createPokemon(Pokemon pokemon, Integer userId) throws Exception {
        String sql = "INSERT INTO pokemon (name, type, level, user_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, pokemon.getName());
            stmt.setString(2, pokemon.getType());
            stmt.setInt(3, pokemon.getLevel());
            stmt.setInt(4, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO CRIAR POKÉMON: " + e.getMessage());
        }
    }

    public static ArrayList<Pokemon> getPokemonsByUser(int userId) throws Exception {
        ArrayList<Pokemon> tb_pokemon = new ArrayList<>();
        String sql = "SELECT * FROM tb_pokemon WHERE user_id = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Pokemon pokemon = new Pokemon(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getInt("level")
                    );
                    tb_pokemon.add(pokemon);
                }
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO LISTAR POKÉMONS: " + e.getMessage());
        }

        return tb_pokemon;
    }

    public static void updatePokemon(Pokemon pokemon) throws Exception {
        String sql = "UPDATE tb_pokemon SET name = ?, type = ?, level = ? WHERE id = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setString(1, pokemon.getName());
            stmt.setString(2, pokemon.getType());
            stmt.setInt(3, pokemon.getLevel());
            stmt.setInt(4, pokemon.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO ATUALIZAR POKÉMON: " + e.getMessage());
        }
    }

    public static void deletePokemon(int id) throws Exception {
        String sql = "DELETE FROM tb_pokemon WHERE id = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("ERRO AO EXCLUIR POKÉMON: " + e.getMessage());
        }
    }

    public static Pokemon getPokemonById(int id) throws Exception {
        String sql = "SELECT * FROM tb_pokemon WHERE id = ?";

        try (PreparedStatement stmt = DatabaseConnection.getConnection().prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Pokemon(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("type"),
                            rs.getInt("level")
                    );
                }
            }
        } catch (SQLException e) {
            throw new Exception("ERRO AO OBTER POKÉMON PELO ID: " + e.getMessage());
        }

        return null;
    }
}

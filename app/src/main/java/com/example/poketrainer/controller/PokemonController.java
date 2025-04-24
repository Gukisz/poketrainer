package com.example.poketrainer.controller;

import com.example.poketrainer.database.DatabaseConnection;
import com.example.poketrainer.model.Pokemon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PokemonController {

    public boolean adicionarPokemon(Pokemon pokemon) {
        String sql = "INSERT INTO pokemons (nome, tipo, treinador_id) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pokemon.getNome());
            stmt.setString(2, pokemon.getTipo());
            stmt.setInt(3, pokemon.getTreinadorId());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar Pokémon:");
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Pokemon> listarPokemonsPorTreinador(int treinadorId) {
        ArrayList<Pokemon> lista = new ArrayList<>();
        String sql = "SELECT * FROM pokemons WHERE treinador_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, treinadorId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pokemon p = new Pokemon();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setTipo(rs.getString("tipo"));
                p.setTreinadorId(rs.getInt("treinador_id"));

                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar Pokémons:");
            e.printStackTrace();
        }
        return lista;
    }
}

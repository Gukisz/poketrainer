/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.PokemonDAO;
import java.util.ArrayList;
import model.Pokemon;

/**
 *
 * @author Adrian
 */

public class PokemonController {

    public static void createPokemon(String name, String type, int level, int userId) throws Exception {
        if (name.isEmpty() || type.isEmpty()) {
            throw new Exception("O nome e o tipo do Pokémon não podem estar vazios");
        }
        if (level < 1) {
            throw new Exception("O nível do Pokémon deve ser maior que zero");
        }
        Pokemon pokemon = new Pokemon(name, type, level);
        PokemonDAO.createPokemon(pokemon, userId);
    }

    public static void updatePokemon(int id, String name, String type, int level) throws Exception {
        if (name.isEmpty() || type.isEmpty()) {
            throw new Exception("O nome e o tipo do Pokémon não podem estar vazios");
        }
        if (level < 1) {
            throw new Exception("O nível do Pokémon deve ser maior que zero");
        }
        Pokemon pokemon = new Pokemon(id, name, type, level);
        PokemonDAO.updatePokemon(pokemon);
    }

    public static ArrayList<Pokemon> getByUser(int userId) throws Exception {
        return PokemonDAO.getPokemonsByUser(userId);
    }

    public static void removePokemon(int id) throws Exception {
        PokemonDAO.deletePokemon(id);
    }

    public static Pokemon getPokemonByID(int id) throws Exception {
        return PokemonDAO.getPokemonById(id);
    }
}


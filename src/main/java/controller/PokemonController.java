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
    private PokemonDAO pokemonDAO;

    public PokemonController() {
       this.pokemonDAO = new PokemonDAO();
    }
    
    
    
    public void createPokemon(String name, String type, int level, int userId) throws Exception {
        if (name.isEmpty() || type.isEmpty()) {
            throw new Exception("O nome e o tipo do Pokémon não podem estar vazios");
        }
        if (level < 1) {
            throw new Exception("O nível do Pokémon deve ser maior que zero");
        }
        Pokemon pokemon = new Pokemon(name, type, level);
        pokemonDAO.createPokemon(pokemon, userId);
    }

    public void updatePokemon(int id, String name, String type, int level) throws Exception {
        if (name.isEmpty() || type.isEmpty()) {
            throw new Exception("O nome e o tipo do Pokémon não podem estar vazios");
        }
        if (level < 1) {
            throw new Exception("O nível do Pokémon deve ser maior que zero");
        }
        Pokemon pokemon = new Pokemon(id, name, type, level);
        pokemonDAO.updatePokemon(pokemon);
    }

    public ArrayList<Pokemon> getByUser(int userId) throws Exception {
        return pokemonDAO.getPokemonsByUser(userId);
    }

    public void removePokemon(int id) throws Exception {
        pokemonDAO.deletePokemon(id);
    }

    public Pokemon getPokemonByID(int id) throws Exception {
        return pokemonDAO.getPokemonById(id);
    }
}


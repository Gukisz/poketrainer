/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Adrian
 */
public class PokemonService {
    
    public static void validateLevel(int level) throws Exception {
        if (level < 1 || level > 100) {
            throw new IllegalArgumentException("O nível deve estar entre 1 e 100");
        }
    }
    
    public static void validateName(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("O nome do Pokémon não pode estar vazio");
        }
    }
}

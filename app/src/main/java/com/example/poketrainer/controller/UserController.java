/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.poketrainer.controller;

import com.example.poketrainer.database.DatabaseConnection;
import com.example.poketrainer.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserController {

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND senha = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao tentar fazer login:");
            e.printStackTrace();
            return false;
        }
    }

    public boolean cadastrarUsuario(User user) {
        String sql = "INSERT INTO usuarios (username, senha) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getSenha());

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar usuário:");
            e.printStackTrace();
            return false;
        }
    }
}



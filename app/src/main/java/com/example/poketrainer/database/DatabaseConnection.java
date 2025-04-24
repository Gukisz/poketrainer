/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.poketrainer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/poketrainer"; // troque pelo nome do seu banco
    private static final String USER = "root"; // troque pelo seu usuário
    private static final String PASSWORD = "sua_senha_aqui"; // troque pela sua senha do MySQL

    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Conexão com o banco de dados estabelecida!");
            } catch (SQLException e) {
                System.out.println("❌ Erro ao conectar com o banco de dados:");
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("🔒 Conexão com o banco encerrada.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Erro ao fechar conexão:");
            e.printStackTrace();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDAO;
import model.User;

/**
 *
 * @author Adrian
 */
public class UserController {


    public static void createUser(String name, String password) throws Exception {
        if (name.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Nome, email e senha não podem estar vazios");
        }
        User user = new User(name, password);
        UserDAO.createUser(user);
    }

    public static User getByName(String nome) throws Exception {
        return UserDAO.getByName(nome);
    }
    
    public static User login(String username, String password) throws Exception {
            User user = UserDAO.getByName(username);
            if (user== null) {
                throw new Exception("Esse usuário não existe");
            }
            if (!user.getPassword().equals(password)) {
                throw new Exception("Senha incorreta");
            }
            
            return user;
    }
}

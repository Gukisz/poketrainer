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
    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    public void createUser(String name, String password) throws Exception {
        if (name.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Nome, email e senha não podem estar vazios");
        }
        User user = new User(name, password);
        userDAO.createUser(user);
    }

    public  User getByName(String nome) throws Exception {
        return userDAO.getByName(nome);
    }
    
    public User login(String username, String password) throws Exception {
        User user = userDAO.getByName(username); 
        if (user== null) {
                throw new Exception("Esse usuário não existe");
            }
        if (!userDAO.validateLogin(new User(username, password))) {
               throw new Exception("Senha incorreta");
        }       
        return user;
    }
    
    public void deleteUser(int id) throws Exception {
        if (id <= 0) {
            throw new IllegalArgumentException("ID inválido para exclusão");
        }
        userDAO.deleteUser(id);
    }

    public void updateUserName(int id, String newName) throws Exception {
        if (newName.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode estar vazio");
        }
        userDAO.updateUserName(id, newName);
    }

    public void updateUserPassword(int id, String newPassword) throws Exception {
        if (newPassword.isEmpty()) {
            throw new IllegalArgumentException("Senha não pode estar vazia");
        }
        userDAO.updateUserPassword(id, newPassword);
    }
}

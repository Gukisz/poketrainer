package view;


import controller.PokemonController;
import controller.UserController;
import javax.swing.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.Pokemon;
import model.User;

public final class MainView extends javax.swing.JFrame {
    private final PokemonController pokemonController = new PokemonController();
    private final UserController userController = new UserController();
    private final User user;
    public MainView(User usuario) {
        this.setTitle("PokeTrainer");
        this.user = usuario;
        initComponents();
        setLocationRelativeTo(null); // Centraliza a janela
        attTablePokemon();
        userField.setText(user.getName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pokemonTab = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePokemon = new javax.swing.JTable();
        botaoAdicionar = new javax.swing.JButton();
        botaoEditar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        userConfigTab = new javax.swing.JPanel();
        updatePasswordButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        confirmationField = new javax.swing.JPasswordField();
        userField = new javax.swing.JTextField();
        updateUserNameButton = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(647, 373));

        tablePokemon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Pokémon", "Tipo", "Nível", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablePokemon);

        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoEditar.setText("Editar");
        botaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarActionPerformed(evt);
            }
        });

        botaoExcluir.setText("Excluir");
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pokemonTabLayout = new javax.swing.GroupLayout(pokemonTab);
        pokemonTab.setLayout(pokemonTabLayout);
        pokemonTabLayout.setHorizontalGroup(
            pokemonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pokemonTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pokemonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(pokemonTabLayout.createSequentialGroup()
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pokemonTabLayout.setVerticalGroup(
            pokemonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pokemonTabLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pokemonTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoAdicionar)
                    .addComponent(botaoEditar)
                    .addComponent(botaoExcluir))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Meus Pokémon", pokemonTab);

        updatePasswordButton.setText("Atualizar Senha");
        updatePasswordButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatePasswordButtonActionPerformed(evt);
            }
        });

        deleteUserButton.setText("Excluir Conta");
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Nova Senha");

        jLabel2.setText("Confirmar Senha");

        jLabel3.setText("Usuário");

        userField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userFieldActionPerformed(evt);
            }
        });

        updateUserNameButton.setText("Atualizar nome de Usuário");
        updateUserNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserNameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userConfigTabLayout = new javax.swing.GroupLayout(userConfigTab);
        userConfigTab.setLayout(userConfigTabLayout);
        userConfigTabLayout.setHorizontalGroup(
            userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userConfigTabLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateUserNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(deleteUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updatePasswordButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userConfigTabLayout.createSequentialGroup()
                            .addGroup(userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addGap(142, 142, 142))
                        .addComponent(confirmationField)
                        .addComponent(passwordField, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(50, 50, 50))
        );
        userConfigTabLayout.setVerticalGroup(
            userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userConfigTabLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(userConfigTabLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(userConfigTabLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(userConfigTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updatePasswordButton)
                    .addComponent(updateUserNameButton))
                .addGap(73, 73, 73)
                .addComponent(deleteUserButton)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configurações de Usuário", userConfigTab);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(botaoVoltar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    public void attTablePokemon() {
        try {
            ArrayList<Pokemon> pokemonList = pokemonController.getByUser(user.getId());
            DefaultTableModel model = (DefaultTableModel) tablePokemon.getModel();
            model.setRowCount(0);

            for (Pokemon pokemon : pokemonList) {
		Object[] rowData = {pokemon.getName(), pokemon.getType(), pokemon.getLevel(), pokemon.getId()};
		model.addRow(rowData);
            }
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }
    
    
    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
       new PokemonForm(user).setVisible(true);
       this.dispose();
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarActionPerformed
        int selectedRow = tablePokemon.getSelectedRow();
        
        if (selectedRow != -1) {
           
          int idPokemon = (int) tablePokemon.getValueAt(selectedRow, 3);
          String name = (String) tablePokemon.getValueAt(selectedRow, 0);
          String type = (String) tablePokemon.getValueAt(selectedRow, 1);
          int level = (int) tablePokemon.getValueAt(selectedRow, 2);
          Pokemon pokemon = new Pokemon(idPokemon, name, type, level);
            
          new PokemonForm(user, pokemon).setVisible(true);
          this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa para editar!");
        }
    }//GEN-LAST:event_botaoEditarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
      int selectedRow = tablePokemon.getSelectedRow();
			
      if (selectedRow != -1) {
        int idPokemon = (int) tablePokemon.getValueAt(selectedRow, 3); //Pego o valor da celula que corresponde a linha tal x coluna tal

        try {
            pokemonController.removePokemon(idPokemon);
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
      } else {
		showErrorMessage("Selecione uma tarefa!");
      }
        
      attTablePokemon();
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        new LoginView().setVisible(true);
	this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void updatePasswordButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatePasswordButtonActionPerformed
        try {
            String uptPassword = new String(passwordField.getPassword());
            String confirmation = new String(confirmationField.getPassword());
            
            if (!uptPassword.equals(confirmation)) {
                throw new Exception("As senhas não coincidem");
            }
            userController.updateUserPassword(user.getId(), uptPassword);
            JOptionPane.showMessageDialog(this, "Senha atualizada com sucesso!");
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_updatePasswordButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        try {
            userController.deleteUser(user.getId());
            JOptionPane.showMessageDialog(this, "Usuário excluido com sucesso");
            new LoginView().setVisible(true);
            this.dispose();
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
        
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    private void userFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldActionPerformed

    private void updateUserNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserNameButtonActionPerformed
        try {
            String uptName = userField.getText();
            userController.updateUserName(user.getId(), uptName);
            JOptionPane.showMessageDialog(this, "Nome de usuário atualizado com sucesso!");
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_updateUserNameButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoEditar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPasswordField confirmationField;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JPanel pokemonTab;
    private javax.swing.JTable tablePokemon;
    private javax.swing.JButton updatePasswordButton;
    private javax.swing.JButton updateUserNameButton;
    private javax.swing.JPanel userConfigTab;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}

package view;

import controller.PokemonController;
import javax.swing.*;
import java.awt.*;
import model.Pokemon;
import model.User;

public class PokemonForm extends javax.swing.JFrame {
    
    private User user;
    private Pokemon pokemon;
    private PokemonController pokemonController = new PokemonController();

    public PokemonForm(User usuario) {
        this.setTitle("Adicionando pokémon");
        this.user = usuario;
        initComponents();
        setLocationRelativeTo(null);
        setBackground(new Color(240, 240, 240)); 
    }
    
    public PokemonForm(User usuario, Pokemon pokemon) {
        this.setTitle("Atualizando pokémon");
        this.user = usuario;
        initComponents();
        setLocationRelativeTo(null); 
        setBackground(new Color(240, 240, 240)); 
        
        this.pokemon = pokemon;
        pokemonLevel.setText(Integer.toString(pokemon.getLevel()));
        pokemonName.setText(pokemon.getName());
        typeBox.setSelectedItem(pokemon.getType());
    }
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pokemonName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        botaoSalvar = new javax.swing.JButton();
        typeBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        pokemonLevel = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Tipo:");

        botaoSalvar.setText("Salvar");
        botaoSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarActionPerformed(evt);
            }
        });

        typeBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Fogo", "Água", "Grama", "Elétrico", "Gelo", "Lutador", "Venenoso", "Terrestre", "Voador", "Psíquico", "Inseto", "Pedra", "Fantasma", "Dragão", "Sombrio", "Aço", "Fada" }));

        jLabel3.setText("Level:");

        pokemonLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pokemonLevelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pokemonName, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pokemonLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(botaoSalvar)
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pokemonName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalvar)
                    .addComponent(pokemonLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    private void botaoSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarActionPerformed
      try {
            String name = pokemonName.getText();
            String type = (String) typeBox.getSelectedItem();
            int level = Integer.parseInt(pokemonLevel.getText());
            if (name.isEmpty() || type.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!");
                return;
            } 
            if (pokemon == null) {
               pokemonController.createPokemon(name, type, level, user.getId());
            } else {
                pokemonController.updatePokemon(pokemon.getId(),name,type,level );
            }    
  
            new MainView(user).setVisible(true);
            this.dispose();
        } catch (Exception e) {
            showErrorMessage(e.getMessage());
        }
        
    }//GEN-LAST:event_botaoSalvarActionPerformed

    private void pokemonLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pokemonLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pokemonLevelActionPerformed
        
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField pokemonLevel;
    private javax.swing.JTextField pokemonName;
    private javax.swing.JComboBox<String> typeBox;
    // End of variables declaration//GEN-END:variables
}

package tcpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class Graphique extends javax.swing.JFrame {

    /**
     * Creates new form Graphique
     */
    PrintWriter outSocket;
    BufferedReader inSocket;

    public Graphique() throws Exception {
        try {
            Socket socket = new Socket("localhost", 4444);
            //Socket socket = new Socket("127.0.0.1", 4444);
            //to get the ip address
            System.out.println((java.net.InetAddress.getLocalHost()).toString());

            //true: it will flush the output buffer
            outSocket = new PrintWriter(socket.getOutputStream(), true);
            inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // Thread.sleep(1000);

            System.out.println("Asking server for a new game");
            System.out.println("Waiting answer from server");


        } catch (Exception e) {
            System.out.println("Could not listen on port 4444");
            System.exit(-1);
        }

        initComponents();
        String j = inSocket.readLine();
        String values[] = j.split(";");
        for (int i = 0; i < values.length; i++) {
            theaterChoiceItems.addItem(values[i]);
        }
        for (int i = 1; i < 6; i++) {
            placesNumberItems.addItem(i);
        }

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        theaterChoice = new javax.swing.JLabel();
        placesNumber = new javax.swing.JLabel();
        infoConfirmationLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        firstnameField = new javax.swing.JTextField();
        theaterChoiceItems = new javax.swing.JComboBox();
        placesNumberItems = new javax.swing.JComboBox();
        reservationButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        confirmationPanel = new javax.swing.JTextPane();
        windowTitle = new javax.swing.JLabel();
        separatorTop = new javax.swing.JSeparator();
        separatorBottom = new javax.swing.JSeparator();
        copyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Nom");

        firstname.setForeground(new java.awt.Color(0, 51, 102));
        firstname.setText("Prénom");

        theaterChoice.setForeground(new java.awt.Color(0, 51, 102));
        theaterChoice.setText("Choix de la pièce");

        placesNumber.setForeground(new java.awt.Color(0, 51, 102));
        placesNumber.setText("Nombre de places");

        infoConfirmationLabel.setForeground(new java.awt.Color(0, 51, 102));
        infoConfirmationLabel.setText("  ");

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        theaterChoiceItems.setBackground(new java.awt.Color(64, 64, 131));
        theaterChoiceItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theaterChoiceItemsActionPerformed(evt);
            }
        });

        placesNumberItems.setBackground(new java.awt.Color(64, 64, 131));

        reservationButton.setBackground(new java.awt.Color(153, 153, 153));
        reservationButton.setText("Effectuer une réservation");
        reservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(confirmationPanel);

        windowTitle.setFont(new java.awt.Font("Minion Pro", 1, 18)); // NOI18N
        windowTitle.setForeground(new java.awt.Color(0, 51, 102));
        windowTitle.setText("Bienvenue sur la plateforme de réservation des places");

        copyright.setForeground(new java.awt.Color(0, 51, 102));
        copyright.setText("Copyright © 2014");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separatorTop, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(separatorBottom, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(theaterChoice)
                                    .addComponent(placesNumber))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(theaterChoiceItems, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(placesNumberItems, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(firstname)
                                    .addGap(51, 51, 51)
                                    .addComponent(firstnameField))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(68, 68, 68)
                                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(reservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(windowTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(copyright))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(infoConfirmationLabel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(windowTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separatorTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstnameField, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(firstname))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(theaterChoice)
                    .addComponent(theaterChoiceItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(placesNumberItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(placesNumber))
                .addGap(27, 27, 27)
                .addComponent(reservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(separatorBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(infoConfirmationLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(copyright)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationButtonActionPerformed
        MusicDeFond.confirmationButton();
        System.out.println("Preparation des données");
        System.out.println("Réservation : ");
        System.out.println("Nom : " + nameField.getText());
        System.out.println("Prénom : " + firstnameField.getText());
        System.out.println("Nom de la pièce : "
                + theaterChoiceItems.getSelectedItem());
        System.out.println("Nombre de places demandées: "
                + placesNumberItems.getSelectedItem());
        System.out.println("Envoi du tableau de reservation");
        infoConfirmationLabel.setText("Votre demande a bien été prise en compte, "
                + "voici la réponse de nos serveurs :");

        try {
            outSocket.println(String.valueOf(placesNumberItems.getSelectedItem()
                    + ";" + theaterChoiceItems.getSelectedItem()));

            String k = inSocket.readLine();
            confirmationPanel.setText(k);
            
            //Jessica BESAGNI : J'ai testé, ca marche !!
            
        } catch (IOException ex) {
            Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_reservationButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void theaterChoiceItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theaterChoiceItemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_theaterChoiceItemsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Graphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Graphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Graphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Graphique.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Graphique().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(Graphique.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane confirmationPanel;
    private javax.swing.JLabel copyright;
    private javax.swing.JLabel firstname;
    private javax.swing.JTextField firstnameField;
    private javax.swing.JLabel infoConfirmationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel placesNumber;
    private javax.swing.JComboBox placesNumberItems;
    private javax.swing.JButton reservationButton;
    private javax.swing.JSeparator separatorBottom;
    private javax.swing.JSeparator separatorTop;
    private javax.swing.JLabel theaterChoice;
    private javax.swing.JComboBox theaterChoiceItems;
    private javax.swing.JLabel windowTitle;
    // End of variables declaration//GEN-END:variables
}

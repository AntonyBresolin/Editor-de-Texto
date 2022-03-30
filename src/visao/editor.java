/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Antony Henrique Bresolin
 */
public class editor extends javax.swing.JFrame {

    JFileChooser seletorDeArquivos = new JFileChooser();

    public editor() {
        initComponents();
        setSize(700, 500);
        setTitle("Editor de Texto");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButtonSalvar = new javax.swing.JButton();
        jButtonAbrir = new javax.swing.JButton();
        jButtonSubstituir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaEscritor = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(600, 500));

        jToolBar1.setRollover(true);

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setFocusable(false);
        jButtonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSalvar);

        jButtonAbrir.setText("Abrir");
        jButtonAbrir.setFocusable(false);
        jButtonAbrir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAbrir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAbrirActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonAbrir);

        jButtonSubstituir.setText("Substituir");
        jButtonSubstituir.setFocusable(false);
        jButtonSubstituir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSubstituir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSubstituir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubstituirActionPerformed(evt);
            }
        });
        jToolBar1.add(jButtonSubstituir);

        getContentPane().add(jToolBar1, java.awt.BorderLayout.PAGE_START);

        jTextAreaEscritor.setColumns(20);
        jTextAreaEscritor.setRows(5);
        jScrollPane1.setViewportView(jTextAreaEscritor);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        // TODO add your handling code here:

        seletorDeArquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retorno = seletorDeArquivos.showSaveDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            try {

                java.io.File Arquivo = seletorDeArquivos.getSelectedFile();
                if (!Arquivo.exists()) {
                    Arquivo.createNewFile();

                }

                //vai criar um gravador para escrever no arquivo selecionado 
                PrintWriter gravarArq = new PrintWriter(Arquivo);
                gravarArq.print(jTextAreaEscritor.getText());

                gravarArq.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "O arquivo não pode ser salvo");
            }
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAbrirActionPerformed

        seletorDeArquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int retorno = seletorDeArquivos.showOpenDialog(null);

        if (retorno == JFileChooser.APPROVE_OPTION) {

            try {

                java.io.File Arquivo = seletorDeArquivos.getSelectedFile();
                //criar leitor do arquivo
                FileReader arq = new FileReader(seletorDeArquivos.getSelectedFile());
                BufferedReader lerArq = new BufferedReader(arq);

                jTextAreaEscritor.setText("");
                jTextAreaEscritor.append(lerArq.readLine());

                //Append coloca no final da area de texto
                while (lerArq.ready()) {
                    jTextAreaEscritor.append("\n" + lerArq.readLine());

                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "O arquivo não pode ser aberto");
            }

        }


    }//GEN-LAST:event_jButtonAbrirActionPerformed

    private void jButtonSubstituirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubstituirActionPerformed
        // TODO add your handling code here:
        Scanner leia = new Scanner(System.in);

        String texto = "";
        texto = jTextAreaEscritor.getText();
        String textoFinal = "";
        String palavraParaSubstituir = "";
        String palavraEscolhida = JOptionPane.showInputDialog("Que palavra você deseja substituir?");

        if (palavraEscolhida == null) {

        } else if (!palavraEscolhida.equals("")) {
            palavraParaSubstituir = JOptionPane.showInputDialog("Digite por qual palavra você quer substituir.");

            if (palavraParaSubstituir == null) {

            } else if(!palavraParaSubstituir.equals("")) {
                textoFinal = texto.replace(palavraEscolhida, palavraParaSubstituir);

                jTextAreaEscritor.setText(textoFinal);
            }

        }

    }//GEN-LAST:event_jButtonSubstituirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAbrir;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JButton jButtonSubstituir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaEscritor;
    private javax.swing.JToolBar jToolBar1;
    // End of variables declaration//GEN-END:variables
}



//By: Antony Henrique Bresolin. 

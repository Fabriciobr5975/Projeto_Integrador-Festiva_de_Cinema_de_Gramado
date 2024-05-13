/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

import dao.FestivalCinemaGramadoDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ruan.lviana
 */
public class AlterarSubmissaoFilmes extends javax.swing.JFrame {

    /**
     * Creates new form AlterarSubmissaoFilmes
     */
    public AlterarSubmissaoFilmes() {
        initComponents();
    }
    
    public AlterarSubmissaoFilmes(String cod, String filme, String duracao, String classificacao, String genero, String nomeDiretor, String sobrenomeDiretor, String informacoes) {
        initComponents();
    
        txtCod.setText(cod);
        txtCod.setEnabled(false);
        txtFilme.setText(filme);
        txtDuracao.setText(duracao);
        txtClassificacao.setText(classificacao);
        txtGenero.setText(genero);
        txtNomeDiretor.setText(nomeDiretor);
        txtSobrenomeDiretor.setText(sobrenomeDiretor);
        txtInformacoes.setText(informacoes);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFilme = new javax.swing.JLabel();
        txtFilme = new javax.swing.JTextField();
        lblDuracao = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        lblClassificacao = new javax.swing.JLabel();
        txtClassificacao = new javax.swing.JTextField();
        lblGenero = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        lblSobrenomeDiretor = new javax.swing.JLabel();
        txtNomeDiretor = new javax.swing.JTextField();
        txtSobrenomeDiretor = new javax.swing.JTextField();
        lblInformacoes = new javax.swing.JLabel();
        lblNomeDiretor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInformacoes = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        lblCod = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alteração Subimissão de filmes");
        getContentPane().setLayout(null);

        lblFilme.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblFilme.setText("Filme:");
        getContentPane().add(lblFilme);
        lblFilme.setBounds(40, 80, 50, 40);

        txtFilme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFilmeActionPerformed(evt);
            }
        });
        getContentPane().add(txtFilme);
        txtFilme.setBounds(110, 80, 550, 40);

        lblDuracao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblDuracao.setText("Duração:");
        getContentPane().add(lblDuracao);
        lblDuracao.setBounds(40, 150, 70, 40);

        txtDuracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDuracaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDuracao);
        txtDuracao.setBounds(110, 150, 110, 40);

        lblClassificacao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblClassificacao.setText("Classificação:");
        getContentPane().add(lblClassificacao);
        lblClassificacao.setBounds(240, 150, 90, 40);

        txtClassificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClassificacaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtClassificacao);
        txtClassificacao.setBounds(330, 150, 110, 40);

        lblGenero.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblGenero.setText("Gênero:");
        getContentPane().add(lblGenero);
        lblGenero.setBounds(450, 150, 60, 40);

        txtGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGeneroActionPerformed(evt);
            }
        });
        getContentPane().add(txtGenero);
        txtGenero.setBounds(510, 150, 150, 40);

        lblSobrenomeDiretor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblSobrenomeDiretor.setText("Sobrenome Diretor:");
        getContentPane().add(lblSobrenomeDiretor);
        lblSobrenomeDiretor.setBounds(320, 220, 130, 40);

        txtNomeDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeDiretorActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeDiretor);
        txtNomeDiretor.setBounds(140, 220, 170, 40);

        txtSobrenomeDiretor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSobrenomeDiretorActionPerformed(evt);
            }
        });
        getContentPane().add(txtSobrenomeDiretor);
        txtSobrenomeDiretor.setBounds(460, 220, 200, 40);

        lblInformacoes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblInformacoes.setText("Informações:");
        getContentPane().add(lblInformacoes);
        lblInformacoes.setBounds(40, 320, 90, 40);

        lblNomeDiretor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNomeDiretor.setText("Nome Diretor:");
        getContentPane().add(lblNomeDiretor);
        lblNomeDiretor.setBounds(40, 220, 90, 40);

        txtInformacoes.setColumns(20);
        txtInformacoes.setRows(5);
        jScrollPane1.setViewportView(txtInformacoes);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 290, 520, 120);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(250, 450, 230, 50);

        lblCod.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCod.setText("Código:");
        getContentPane().add(lblCod);
        lblCod.setBounds(40, 10, 70, 40);
        getContentPane().add(txtCod);
        txtCod.setBounds(110, 10, 350, 40);

        setSize(new java.awt.Dimension(730, 559));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtFilmeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFilmeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFilmeActionPerformed

    private void txtDuracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDuracaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDuracaoActionPerformed

    private void txtClassificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClassificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClassificacaoActionPerformed

    private void txtGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGeneroActionPerformed

    private void txtNomeDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeDiretorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeDiretorActionPerformed

    private void txtSobrenomeDiretorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSobrenomeDiretorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSobrenomeDiretorActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
     String cod, filme, duracao, classificacao, genero, nomeDiretor, sobrenomeDiretor, informacoes;
        
        // Pegando as informações dos campos;
        cod = txtCod.getText();
        filme = txtFilme.getText();
        duracao = txtDuracao.getText();
        classificacao = txtClassificacao.getText();
        genero = txtGenero.getText();
        nomeDiretor = txtNomeDiretor.getText();
        sobrenomeDiretor = txtSobrenomeDiretor.getText();
        informacoes = txtInformacoes.getText();

        try {
            // Instanciando a classe dao que contém a parte da conexão e os comandos SQL;
            new FestivalCinemaGramadoDao().alterarSubmissaoFilmes(cod, filme, duracao, classificacao, genero, filme, sobrenomeDiretor, informacoes);

            // Mensagem para dizer que o filme foi cadastro;
            JOptionPane.showMessageDialog(null, "Filme alterado com sucesso", "Alteração de Filme", JOptionPane.INFORMATION_MESSAGE);

            // Limpar a tela e reposicionar o cursor do mouse;
            dispose();

        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte e informe o erro: " + ex.getMessage());

        } 
        
    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(AlterarSubmissaoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AlterarSubmissaoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AlterarSubmissaoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AlterarSubmissaoFilmes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AlterarSubmissaoFilmes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClassificacao;
    private javax.swing.JLabel lblCod;
    private javax.swing.JLabel lblDuracao;
    private javax.swing.JLabel lblFilme;
    private javax.swing.JLabel lblGenero;
    private javax.swing.JLabel lblInformacoes;
    private javax.swing.JLabel lblNomeDiretor;
    private javax.swing.JLabel lblSobrenomeDiretor;
    private javax.swing.JTextField txtClassificacao;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtFilme;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextArea txtInformacoes;
    private javax.swing.JTextField txtNomeDiretor;
    private javax.swing.JTextField txtSobrenomeDiretor;
    // End of variables declaration//GEN-END:variables
}

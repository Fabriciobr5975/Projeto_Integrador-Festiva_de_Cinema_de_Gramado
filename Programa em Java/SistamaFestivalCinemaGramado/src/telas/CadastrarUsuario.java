package telas;

import dao.FestivalCinemaGramadoDao;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author arauj
 */
public class CadastrarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form CadastrarUsuario
     */
    public CadastrarUsuario() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblSenha = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        btnCadastrar = new javax.swing.JButton();
        lblCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        lblSobrenome = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        lblTipoUsuario = new javax.swing.JLabel();
        cmbTipoUsuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastrar-Se");
        getContentPane().setLayout(null);

        lblNome.setText("Nome:");
        getContentPane().add(lblNome);
        lblNome.setBounds(30, 30, 60, 30);

        lblEmail.setText("Email:");
        getContentPane().add(lblEmail);
        lblEmail.setBounds(210, 100, 40, 30);

        lblSenha.setText("Senha:");
        getContentPane().add(lblSenha);
        lblSenha.setBounds(30, 170, 60, 30);
        getContentPane().add(txtNome);
        txtNome.setBounds(80, 30, 200, 30);
        getContentPane().add(txtEmail);
        txtEmail.setBounds(250, 100, 360, 30);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(80, 170, 200, 30);

        btnCadastrar.setText("Cadastrar-se");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadastrar);
        btnCadastrar.setBounds(250, 270, 110, 30);

        lblCpf.setText("CPF:");
        getContentPane().add(lblCpf);
        lblCpf.setBounds(30, 100, 40, 30);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(80, 100, 120, 30);

        lblSobrenome.setText("Sobrenome:");
        getContentPane().add(lblSobrenome);
        lblSobrenome.setBounds(300, 30, 70, 30);
        getContentPane().add(txtSobrenome);
        txtSobrenome.setBounds(380, 30, 230, 30);

        lblTipoUsuario.setText("Tipo de Usuário");
        getContentPane().add(lblTipoUsuario);
        lblTipoUsuario.setBounds(300, 170, 100, 30);

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Visitante", "Cineasta", "Avaliador" }));
        getContentPane().add(cmbTipoUsuario);
        cmbTipoUsuario.setBounds(400, 170, 210, 30);

        setSize(new java.awt.Dimension(649, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        String nome, sobrenome, cpf, email, senha, tipoUsu;

        nome = txtNome.getText();
        sobrenome = txtSobrenome.getText();
        cpf = txtCpf.getText();
        email = txtEmail.getText();
        senha = txtSenha.getText();
        tipoUsu = (String) cmbTipoUsuario.getSelectedItem();

        try {
            new FestivalCinemaGramadoDao().cadastrarUsuarios(nome, sobrenome, email, senha, cpf, tipoUsu);

            // Mensagem para finalizar o cadastro;
            JOptionPane.showMessageDialog(null, "Usuário cadastro com sucesso", "Usuário Cadastrado", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Fechar a tela após a mensagem;
            new Login().setVisible(true);
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Entre em contato com o suporte e informe o erro: " + ex.getMessage());

        } catch (SQLException ex) {
            String erro = ex.getMessage();

            if(erro.contains("Duplicate entry")){
                JOptionPane.showMessageDialog(null, "Outro usuário já foi cadastro com esse CPF", "Erro no cadastro", JOptionPane.WARNING_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Entre em contato com o suporte e informe o erro: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private javax.swing.JLabel lblCpf;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSenha;
    private javax.swing.JLabel lblSobrenome;
    private javax.swing.JLabel lblTipoUsuario;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package telas;

/**
 *
 * @author arauj
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
    }

    public MenuPrincipal(String tipoUsu) {
        initComponents();

        if (tipoUsu.equalsIgnoreCase("Visitante")) {
            itmBuscarUsuario.setVisible(false);
            itmListarUsuario.setVisible(false);
            itmExcluirUsuario.setVisible(false);
            mnuSubmissaoFilmes.setVisible(false);

        } else if (tipoUsu.equalsIgnoreCase("Cineasta")) {
            itmBuscarUsuario.setVisible(false);
            itmListarUsuario.setVisible(false);
            itmExcluirUsuario.setVisible(false);

        } else if (tipoUsu.equalsIgnoreCase("Avaliador")) {
            itmBuscarUsuario.setVisible(false);
            itmListarUsuario.setVisible(false);
            itmExcluirUsuario.setVisible(false);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnuUsuario = new javax.swing.JMenu();
        itmAlterarInfoUsuario = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        itmBuscarUsuario = new javax.swing.JMenuItem();
        itmListarUsuario = new javax.swing.JMenuItem();
        itmExcluirUsuario = new javax.swing.JMenuItem();
        mnuProgramacaoFilmes = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        mnuSubmissaoFilmes = new javax.swing.JMenu();
        mnuEventosParalelos = new javax.swing.JMenu();
        mnuMaisInformacoes = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/telas/img-festival-cinema-full.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -30, 820, 560);

        mnuUsuario.setText("Usuario");

        itmAlterarInfoUsuario.setText("Alterar Informações");
        mnuUsuario.add(itmAlterarInfoUsuario);
        mnuUsuario.add(jSeparator1);

        itmBuscarUsuario.setText("Buscar");
        mnuUsuario.add(itmBuscarUsuario);

        itmListarUsuario.setText("Listar");
        mnuUsuario.add(itmListarUsuario);

        itmExcluirUsuario.setText("Excluir");
        mnuUsuario.add(itmExcluirUsuario);

        jMenuBar1.add(mnuUsuario);

        mnuProgramacaoFilmes.setText("Programação dos Filmes");

        jMenuItem1.setText("Ver Filmes");
        mnuProgramacaoFilmes.add(jMenuItem1);

        jMenuBar1.add(mnuProgramacaoFilmes);

        mnuSubmissaoFilmes.setText("Submissão de Filmes");
        jMenuBar1.add(mnuSubmissaoFilmes);

        mnuEventosParalelos.setText("Eventos Paralelos");
        jMenuBar1.add(mnuEventosParalelos);

        mnuMaisInformacoes.setText("Mais Informações");
        jMenuBar1.add(mnuMaisInformacoes);

        setJMenuBar(jMenuBar1);

        setSize(new java.awt.Dimension(820, 536));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itmAlterarInfoUsuario;
    private javax.swing.JMenuItem itmBuscarUsuario;
    private javax.swing.JMenuItem itmExcluirUsuario;
    private javax.swing.JMenuItem itmListarUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu mnuEventosParalelos;
    private javax.swing.JMenu mnuMaisInformacoes;
    private javax.swing.JMenu mnuProgramacaoFilmes;
    private javax.swing.JMenu mnuSubmissaoFilmes;
    private javax.swing.JMenu mnuUsuario;
    // End of variables declaration//GEN-END:variables
}

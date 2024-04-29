/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author arauj
 */
public class FestivalCinemaGramadoDao {

    // Variável para se conectar;
    Connection conectar;

    private void conectar() throws ClassNotFoundException, SQLException {
        // Conectar ao Banco de Dados azure;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:mysql://bdfestival-cinema-gramado.mysql.database.azure.com:3306/festival?useSSL=true";
        conectar = DriverManager.getConnection(url, "rootfabricio", "@Festival7458");

    }

    public void cadastrarUsuarios(String nome, String sobrenome, String email, String senha, String cpf, String tipo) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("INSERT INTO usuario VALUES(?,?,?,?,?,?)");
        st.setString(1, cpf);
        st.setString(2, nome);
        st.setString(3, sobrenome);
        st.setString(4, email);
        st.setString(5, senha);
        st.setString(6, tipo);
        st.executeUpdate();

    }

    public ResultSet loginUsuario(String email, String senha) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuario WHERE email_usu = ? AND senha_usu = ?");
        st.setString(1, email);
        st.setString(2, senha);
        ResultSet usuario = st.executeQuery();

        return usuario;
    }

    public ResultSet buscarUsuario(String cpf) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuario WHERE cpf_usu = ?");
        st.setString(1, cpf);
        ResultSet usuario = st.executeQuery();

        return usuario;

    }

    public void alterarUsuario(String nome, String sobrenome, String email, String senha, String cpf, String tipo) throws ClassNotFoundException, SQLException {
        conectar();
        
        PreparedStatement st = conectar.prepareStatement("UPADATE usuario SET nome_usu?, sobrenome_usu=?, senha_usu=?, tipo_usu=? WHERE cpf_usu = ?");
        st.setString(1, nome);
        st.setString(2, sobrenome);
        st.setString(3, senha);
        st.setString(4, tipo);
        st.setString(5, cpf);
        st.executeUpdate();
    }
}

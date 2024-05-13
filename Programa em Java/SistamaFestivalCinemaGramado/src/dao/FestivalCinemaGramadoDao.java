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

    /**
     * Método para cadastrar os usuários que forem usar o aplicativo
     * 
     * @param nome - Recebe o Nome de um campo txt dentro da tela de cadastro de usuário;
     * @param sobrenome - Recebe o Sobrenome de um campo txt dentro da tela de cadastro de usuário;
     * @param email - Recebe o E-Mail de um campo txt dentro da tela de cadastro de usuário;
     * @param senha - Recebe a Senha de um campo txt dentro da tela de cadastro de usuário;
     * @param cpf - Recebe o CPF de um campo txt dentro da tela de cadastro de usuário;
     * @param tipo - Recebe o Tipo de usuário do sistema de um campo txt dentro da tela de cadastro de usuário
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    
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

    public void alterarUsuario(String nome, String sobrenome, String senha, String cpf) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("UPDATE usuario SET nome_usu = ?, sobrenome_usu = ?, senha_usu = ? WHERE cpf_usu = ?");
        st.setString(1, nome);
        st.setString(2, sobrenome);
        st.setString(3, senha);
        st.setString(4, cpf);
        st.executeUpdate();
    }

    public int excluirUsuario(String cpf) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("DELETE FROM usuario WHERE cpf_usu = ?");
        st.setString(1, cpf);
        int retorno = st.executeUpdate();

        return retorno;
    }

    public void submiterFilmes(String cod, String filme, String duracao, String classificao, String genero, String nome, String sobrenome, String informacoes) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("INSERT INTO submissao_filme VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, cod);
        st.setString(2, filme);
        st.setString(3, classificao);
        st.setString(4, genero);
        st.setString(5, duracao);
        st.setString(6, nome);
        st.setString(7, sobrenome);
        st.setString(8, informacoes);
        st.executeUpdate();

    }

    public ResultSet buscarFilme(String cod) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM submissao_filme WHERE id_sub_film = ?");
        st.setString(1, cod);
        ResultSet filme = st.executeQuery();

        return filme;

    }

    public ResultSet listarUsuario() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuario");
        ResultSet usuario = st.executeQuery();

        return usuario;
    }

    public ResultSet listarUsuarioPorNome(String nome) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuario WHERE nome_usu LIKE ?");
        st.setString(1, "%" + nome + "%");
        ResultSet usuario = st.executeQuery();

        return usuario;
    }

    public ResultSet listarSubmissaoFilmes() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM submissao_filme");
        ResultSet submissao = st.executeQuery();

        return submissao;
    }

    public ResultSet listarSubmissaoPorNome(String nome) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM submissao_filme WHERE nome_sub_film LIKE ?");
        st.setString(1, "%" + nome + "%");
        ResultSet submissao = st.executeQuery();

        return submissao;
    }

    public void alterarSubmissaoFilmes(String cod, String filme, String duracao, String classificao, String genero, String nome, String sobrenome, String informacoes) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("UPDATE submissao_filme SET "
                + "nome_sub_film = ?, categoria_sub_film = ?, faixa_etaria_sub_film = ?,  duracao_sub_film = ?,  "
                + "nome_diretor_sub_film = ?, sobrenome_diretor_sub_film = ?,  info_sub_film = ? WHERE id_sub_film = ?");
        st.setString(1, filme);
        st.setString(2, classificao);
        st.setString(3, genero);
        st.setString(4, duracao);
        st.setString(5, nome);
        st.setString(6, sobrenome);
        st.setString(7, informacoes);
        st.setString(8, cod);
        st.executeUpdate();

    }

    public int excluirSubmissaoFilmes(String cod) throws ClassNotFoundException, SQLException{
        conectar();
        
        PreparedStatement st = conectar.prepareStatement("DELETE FROM submissao_filme WHERE id_sub_film = ?");
        st.setString(1, cod);
        int resultado = st.executeUpdate();
        
        return resultado;
        
    }

    public void cadastrarProgramacao(String idFilme, String idProgramacao, String local, String data, String hora, String info) throws ClassNotFoundException, SQLException{
        conectar();
        
        PreparedStatement st = conectar.prepareStatement("INSERT INTO programacao_filme VALUES(?,?,?,?,?,?)");
        st.setString(1, idFilme);
        st.setString(2, idProgramacao);
        st.setString(3, local);
        st.setString(4, data);
        st.setString(5, hora);
        st.setString(6, info);
        st.executeUpdate();
        
    }

    public ResultSet ListarProgramacao() throws ClassNotFoundException, SQLException{
        conectar();
        
       PreparedStatement st = conectar.prepareStatement("SELECT * FROM listagem_filmes");
       ResultSet programacao = st.executeQuery();
       
       return programacao;
        
    }
    
    public void cadastrarEventosParalelos (String id_evt_paral, String nome_evt_paral, String responsavel_evt_paral, String info_evt_paral, String local_evt_paral, String data_evt_paral, String hora_evt_paral) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("INSERT INTO evento_paralelo VALUES (?, ?, ?, ?, ?, ?, ?)");
        st.setString(1, id_evt_paral);
        st.setString(2, nome_evt_paral);
        st.setString(3, responsavel_evt_paral);
        st.setString(4, info_evt_paral);
        st.setString(5, local_evt_paral);
        st.setString(6, data_evt_paral);
        st.setString(7, hora_evt_paral);
        st.executeUpdate();

    }
    
    public void alterarEventosParalelos (String id_evt_paral, String nome_evt_paral, String responsavel_evt_paral, String info_evt_paral, 
            String local_evt_paral, String data_evt_paral, String hora_evt_paral) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("UPDATE evento_paralelo SET "
                + "nome_evt_paral = ?, responsavel_evt_paral = ?, info_evt_paral = ?,  local_evt_paral = ?,  "
                + "data_evt_paral = ?, hora_evt_paral = ? WHERE id_evt_paral = ?");
        st.setString(1, nome_evt_paral);
        st.setString(2, responsavel_evt_paral);
        st.setString(3, info_evt_paral);
        st.setString(4, local_evt_paral);
        st.setString(5, data_evt_paral);
        st.setString(6, hora_evt_paral);
        st.setString(7, id_evt_paral);
        st.executeUpdate();

    }
    
     public ResultSet buscarEventosParalelos(String id_evt_paral) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM evento_paralelo WHERE id_evt_paral = ?");
        st.setString(1, id_evt_paral);
        ResultSet evento = st.executeQuery();

        return evento;

    }
     
     public int excluirEventosParalelos(String id_evt_paral) throws ClassNotFoundException, SQLException{
        conectar();
        
        PreparedStatement st = conectar.prepareStatement("DELETE FROM evento_paralelo WHERE id_evt_paral = ?");
        st.setString(1, id_evt_paral);
        int resultado = st.executeUpdate();
        
        return resultado;
        
    }
     
     public ResultSet listarEventosParalelos() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM evento_paralelo");
        ResultSet evento = st.executeQuery();

        return evento;
    }

    public ResultSet listarEventosParalelosPorNome (String nomeEvento) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM evento_paralelo WHERE nome_evt_paral LIKE ?");
        st.setString(1, "%" + nomeEvento + "%");
        ResultSet evento = st.executeQuery();

        return evento;
    }
}

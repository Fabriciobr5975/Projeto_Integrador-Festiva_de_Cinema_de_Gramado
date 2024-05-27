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

    /**
     * Método com as linhas de código para a conexão do Banco de dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private void conectar() throws ClassNotFoundException, SQLException {
        // Conectar ao Banco de Dados azure;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:mysql://bdfestival-cinema-gramado.mysql.database.azure.com:3306/festival?useSSL=true";
        conectar = DriverManager.getConnection(url, "rootfabricio", "@Festival7458");
    }

    /**
     * Método para cadastrar os usuários que forem usar o aplicativo
     *
     * @param nome - Recebe o Nome de um campo txt dentro da tela de cadastro de
     * usuário;
     * @param sobrenome - Recebe o Sobrenome de um campo txt dentro da tela de
     * cadastro de usuário;
     * @param email - Recebe o E-Mail de um campo txt dentro da tela de cadastro
     * de usuário;
     * @param senha - Recebe a Senha de um campo txt dentro da tela de cadastro
     * de usuário;
     * @param cpf - Recebe o CPF de um campo txt dentro da tela de cadastro de
     * usuário;
     * @param tipo - Recebe o Tipo de usuário do sistema de um campo txt dentro
     * da tela de cadastro de usuário
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

    /**
     * Método para efetuar o login dos usuários
     *
     * @param email - Recebe o E-Mail de um campo txt dentro da tela de login
     * @param senha - Recebe a senha de um campo psw dentro da tela de login
     *
     * @return Retorna os dados do usuário que estão guardados no Banco de Dados
     * para tela de login, onde é verificado se o E-mail e a Senha informados
     * existe dentro do Banco de Dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet loginUsuario(String email, String senha) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM usuario WHERE email_usu = ? AND senha_usu = ?");
        st.setString(1, email);
        st.setString(2, senha);
        ResultSet usuario = st.executeQuery();

        return usuario;
    }

    /**
     * Método que busca os dados de um usuário específico através do cpf
     *
     * @param cpf - Recebe o CPF do usuário para realizar a busca
     * @return Retorna os dados do usuário que estão guardados no Banco de Dados
     * para a tela, onde é verificado se o usuário existe
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet buscarUsuario(String cpf) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_usuarios WHERE cpf_usu = ?");
        st.setString(1, cpf);
        ResultSet usuario = st.executeQuery();

        return usuario;

    }

    /**
     * Método que alterar os dados do usuário (O próprio usuário pode realizar
     * alterações em seus dados)
     *
     * @param nome - Recebe o nome do usuário de um campo txt na tela de Alterar
     * Dados do Usuário
     * @param sobrenome - Recebe o sobrenome do usuário de um campo txt na
     * telaAlterar Dados do Usuário
     * @param senha - Recebe a senha do usuário de um campo txt na tela Alterar
     * Dados do Usuário
     * @param cpf - Recebe o CPF do usuário de um campo txt na tela Alterar
     * Dados do Usuário
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void alterarUsuario(String nome, String sobrenome, String senha, String cpf) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("UPDATE usuario SET nome_usu = ?, sobrenome_usu = ?, senha_usu = ? WHERE cpf_usu = ?");
        st.setString(1, nome);
        st.setString(2, sobrenome);
        st.setString(3, senha);
        st.setString(4, cpf);
        st.executeUpdate();
    }

    /**
     * Método para excluir um usuário
     *
     * @param cpf - Recebe o CPF do usuário
     * @return Retorna o usuário deletado do Banco de Dados, caso ele ache o
     * usuário
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int excluirUsuario(String cpf) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("DELETE FROM usuario WHERE cpf_usu = ?");
        st.setString(1, cpf);
        int retorno = st.executeUpdate();

        return retorno;
    }

    /**
     * Método para a submissão (cadastro) dos filmes
     *
     * @param cod - Recebe o código de um campo txt dentro da tela de submissão
     * de filmes
     * @param filme - Recebe o filme de um campo txt dentro da tela de submissão
     * de filmes
     * @param duracao - Recebe a duração do filme de um campo txt dentro da tela
     * de submissão de filmes
     * @param classificao - Recebe a classificação do filme de um campo txt
     * dentro da tela de submissão de filmes
     * @param genero - Recebe o gênero do filme de um campo txt dentro da tela
     * de submissão de filmes
     * @param nome - Recebe o nome do diretor do filme de um campo txt dentro da
     * tela de submissão de filmes
     * @param sobrenome - Recebe o sobrenome do diretor do filme de um campo txt
     * dentro da tela de submissão de filmes
     * @param informacoes - Recebe as informações adicionais sobre o filme de um
     * campo txt dentro da tela de submissão de filmes
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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

    /**
     * Método que busca os dados de um filme específico
     *
     * @param cod - Recebe o código do filme para a busca
     * @return Retorna todos os dados do filme, caso ele seja encontrado
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet buscarFilme(String cod) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_submissoes WHERE id_sub_film = ?");
        st.setString(1, cod);
        ResultSet filme = st.executeQuery();

        return filme;

    }

    /**
     * Método para listar todos os usuários do Banco de Dados
     *
     * @return Retorna todos os dados de usuários salvos no Banco de Dados, caso
     * o usuário seja encontrado
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet listarUsuario() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_usuarios");
        ResultSet usuario = st.executeQuery();

        return usuario;
    }

    /**
     * Método para listar os usuários pelo nome
     *
     * @param nome - Recebe o nome do usuário
     * @return Retorna todos os dados de usuários salvos no Banco de Dados, caso
     * o nome informado seja de um usuário real no Banco de Dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet listarUsuarioPorNome(String nome) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_usuarios WHERE nome_usu LIKE ?");
        st.setString(1, "%" + nome + "%");
        ResultSet usuario = st.executeQuery();

        return usuario;
    }

    /**
     * Método que lista todos os filmes salvos no Banco de Dados
     *
     * @return Retorna todos os dados dos filmes salvos no Banco de Dados, caso
     * o filme seja encontrado
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet listarSubmissaoFilmes() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_submissoes");
        ResultSet submissao = st.executeQuery();

        return submissao;
    }

    /**
     * Método para listar todos os filmes salvos no Banco de Dados pelo nome
     *
     * @param nome - Recebe o nome do filme para a listagem
     * @return Retorna todos os dados dos filmes salvos no Banco de Dados, caso
     * o nome do filme seja encontrado
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet listarSubmissaoPorNome(String nome) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_submissoes WHERE nome_sub_film LIKE ?");
        st.setString(1, "%" + nome + "%");
        ResultSet submissao = st.executeQuery();

        return submissao;
    }

    /**
     * Método para alterar os dados do filme (tela AlterarSubmissaoFilmes)
     *
     * @param cod - Recebe o código do filme
     * @param filme - Recebe o filme
     * @param duracao - Recebe a duração do filme
     * @param classificao - Recebe a classificação do filme
     * @param genero - Recebe o gênero do filme
     * @param nome - Recebe o nome do Diretor
     * @param sobrenome - Recebe o sobrenome do Diretor
     * @param informacoes - Recebe as informações adicionais sobre o filme
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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

    /**
     * Método para excluir filmes
     *
     * @param cod - Recebe o código do filme para a exclusão
     * @return - Retorno o filme excluido, caso o filme seja encontrado
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int excluirSubmissaoFilmes(String cod) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("DELETE FROM submissao_filme WHERE id_sub_film = ?");
        st.setString(1, cod);
        int resultado = st.executeUpdate();

        return resultado;

    }

    /**
     * Método para cadastrar a Programação de Filmes (tela
     * CadastrarProgramacaoFilmes)
     *
     * @param idFilme - Recebe o código do filme de um campo txt
     * @param idProgramacao - Recebe o código da programação de um campo txt
     * @param local - Recebe o local da programação de um campo txt
     * @param data - Recebe a data da programação de um campo txt
     * @param hora - Recebe a hora da programação de um campo txt
     * @param info - Recebe as informações adicionais sobre a programação de um
     * campo txt
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void cadastrarProgramacao(String idFilme, String idProgramacao, String local, String data, String hora, String info) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("INSERT INTO programacao_filme(id_sub_film, id_prog_film, local_prog_film, data_prog_film, hora_prog_film, info_prog_film) "
                + "VALUES((SELECT id_sub_film FROM submissao_filme WHERE nome_sub_film = ?),?,?,?,?,?)");
        st.setString(1, idFilme);
        st.setString(2, idProgramacao);
        st.setString(3, local);
        st.setString(4, data);
        st.setString(5, hora);
        st.setString(6, info);
        st.executeUpdate();

    }

    /**
     * Método para a listagem dos dados da programação
     *
     * @return Retorna todos os dados de programação salvos no Banco de Dados,
     * caso haja programações salvas no Banco de Dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet ListarProgramacao() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listagem_filmes");
        ResultSet programacao = st.executeQuery();

        return programacao;

    }

    /**
     * Método para a listagem dos dados da programação pelo nome do filme
     *
     * @param nome - Recebe o nome do filme para a listagem
     * @return Retorna todos os dados de programação salvos no Banco de Dados,
     * caso o nome informado seja válido no Banco de Dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet ListarProgramacaoPorNome(String nome) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listagem_filmes WHERE Filme LIKE ?");
        st.setString(1, "%" + nome + "%");
        ResultSet programacao = st.executeQuery();

        return programacao;
    }

    /**
     * Método para excluir programações pelo código da programação
     *
     * @param codProgramacao - Recebe o código da programacação para a exclusão
     * @return Retorna a programação deletada do banco de dados, caso a
     * programação seja encontrada
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int excluirProgramacao(String codProgramacao) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("DELETE FROM programacao_filme WHERE id_prog_film = ?");
        st.setString(1, codProgramacao);
        int retorno = st.executeUpdate();

        return retorno;
    }

    /**
     * Método que busca os dados de uma programação específico
     *
     * @param codProgramacao - Recebe o código da programação para realizar a
     * busca
     * @return Retorna todos os dados da programação, caso a programação seja
     * encontrada
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet buscarProgramacao(String codProgramacao) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_programacoes WHERE id_prog_film = ?");
        st.setString(1, codProgramacao);
        ResultSet programacao = st.executeQuery();

        return programacao;
    }

    /**
     * Método para alterar os dados da programação (tela
     * AlterarProgramacaoFilmes)
     *
     * @param idFilme - Recebe o código do Filme
     * @param idProgramacao - Recebe o código da programacao
     * @param local - Recebe o local da programação
     * @param data - Recebe a data da programação
     * @param hora - Recebe a hora da programação
     * @param info - Recebe as informações adicionais da programação
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void alterarProgramacao(String idFilme, String idProgramacao, String local, String data, String hora, String info) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("UPDATE programacao_filme SET id_sub_film = ?, local_prog_film = ?,"
                + " data_prog_film = ?, hora_prog_film = ?, info_prog_film = ? WHERE id_prog_film = ?");
        st.setString(1, idFilme);
        st.setString(2, local);
        st.setString(3, data);
        st.setString(4, hora);
        st.setString(5, info);
        st.setString(6, idProgramacao);
        st.executeUpdate();
    }

    /**
     * Método para cadastrar os Eventos Paralelos (tela
     * CadastrarEventosParelelos)
     *
     * @param id_evt_paral - Recebe o código do evento paralelo
     * @param nome_evt_paral - Recebe o nome do evento parelelo
     * @param responsavel_evt_paral - Recebe o responsável do evento paralelo
     * @param info_evt_paral - Recebe as informações adicionais sobre o evento
     * paralelo
     * @param local_evt_paral - Recebe o local do evento paralelo
     * @param data_evt_paral - Recebe a data do evento paralelo
     * @param hora_evt_paral - Recebe a hora do evento parelelo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void cadastrarEventosParalelos(String id_evt_paral, String nome_evt_paral, String responsavel_evt_paral, String info_evt_paral, String local_evt_paral, String data_evt_paral, String hora_evt_paral) throws ClassNotFoundException, SQLException {
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

    /**
     * Método para alterar os dados do evento paralelo (tela
     * AlterarEventosParalelos)
     *
     * @param id_evt_paral - Recebe o código do evento paralelo
     * @param nome_evt_paral - Recebe o nome do evento parelelo
     * @param responsavel_evt_paral - Recebe o nome do responsável do evento
     * paralelo
     * @param info_evt_paral - Recebe as informações adicionais sobre o evento
     * parelelo
     * @param local_evt_paral - Recebe o local do evento paralelo
     * @param data_evt_paral - Recebe a data do evento parelelo
     * @param hora_evt_paral - Recebe a hora do evento paraleo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void alterarEventosParalelos(String id_evt_paral, String nome_evt_paral, String responsavel_evt_paral, String info_evt_paral,
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

    /**
     * Métoda que busca os dados de um evento paralelo específico
     *
     * @param id_evt_paral - Recebe o código do evento paralelo para a busca
     * @return Retorna todos os dados do evento paralelo, caso o evento seja
     * encontrado pelo Banco de Dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet buscarEventosParalelos(String id_evt_paral) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_eventos WHERE id_evt_paral = ?");
        st.setString(1, id_evt_paral);
        ResultSet evento = st.executeQuery();

        return evento;

    }

    /**
     * Método para excluir o evento paralelo
     *
     * @param id_evt_paral - Recebe o código do evento paralelo para a exclusão
     * @return Retorna o evento paralelo deletado do banco de dados, caso ele
     * seja encontrado
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public int excluirEventosParalelos(String id_evt_paral) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("DELETE FROM evento_paralelo WHERE id_evt_paral = ?");
        st.setString(1, id_evt_paral);
        int resultado = st.executeUpdate();

        return resultado;

    }

    /**
     * Método para listar todos os dados dos eventos paralelos (tela
     * ListarEventoParalelo)
     *
     * @return - Retorna todos os eventos paralelos cadastrado no Banco de Dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet listarEventosParalelos() throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_eventos");
        ResultSet evento = st.executeQuery();

        return evento;
    }

    /**
     * Método para listar todos os dados dos eventos paralelos pelo nome do
     * evento
     *
     * @param nomeEvento - Recebe o nome do evento para realizar a listagem
     * @return Retorna todos os eventos parelelos selecionados pelo nome do
     * evento cadastrados no Banco de dados
     *
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ResultSet listarEventosParalelosPorNome(String nomeEvento) throws ClassNotFoundException, SQLException {
        conectar();

        PreparedStatement st = conectar.prepareStatement("SELECT * FROM listar_eventos WHERE nome_evt_paral LIKE ?");
        st.setString(1, "%" + nomeEvento + "%");
        ResultSet evento = st.executeQuery();

        return evento;
    }
}

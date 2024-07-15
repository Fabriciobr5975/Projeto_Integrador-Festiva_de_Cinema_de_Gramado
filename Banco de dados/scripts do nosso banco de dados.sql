---- Criando o nosso Banco de dados ----
CREATE DATABASE festival;

---- OBS: As tabelas necessárias para o funcionamento do sistema estão citadas abaixo: ----
---- Tabela: usuario ----
---- Tabela: submissao_filme ----
---- tabela: programacao_filme ----
---- tabela: evento_paralelo ----

---- Criando a tabela de usuários ----
CREATE Table usuario (
    cpf_usu VARCHAR(11) PRIMARY KEY,
    nome_usu VARCHAR(25) NOT NULL,
    sobrenome_usu VARCHAR(25) NOT NULL,
    email_usu VARCHAR(100) UNIQUE NOT NULL,
    senha_usu VARCHAR(20) NOT NULL,
    tipo_usu VARCHAR(14)
);

---- Criando a tabela de submissão de filmes ----
CREATE TABLE submissao_filme (
    id_sub_film int PRIMARY KEY AUTO_INCREMENT,
    nome_sub_film VARCHAR(100) NOT NULL,
    categoria_sub_film VARCHAR(50) NOT NULL,
    faixa_etaria_sub_film VARCHAR(50) NOT NULL,
    duracao_sub_film TIME NOT NULL,
    nome_diretor_sub_film VARCHAR(25) NOT NULL,
    sobrenome_diretor_sub_film VARCHAR(25) NOT NULL,
    info_sub_film VARCHAR(500)
);

---- Criando a tabela de programação dos filmes -----
CREATE Table programacao_filme (
    id_prog_film VARCHAR(20) PRIMARY KEY,
    local_prog_film VARCHAR(100) NOT NULL,
    info_prog_film VARCHAR(500),
    data_prog_film DATE NOT NULL,
    hora_prog_film TIME NOT NULL,
    id_sub_film VARCHAR(30) NOT NULL,
    CONSTRAINT fk_id_sub_film FOREIGN KEY (id_sub_film) REFERENCES submissao_filme (id_sub_film)
);

---- Criando a tabela de eventos paralelos -----
CREATE Table evento_paralelo (
    id_evt_paral INT PRIMARY KEY AUTO_INCREMENT,
    nome_evt_paral VARCHAR(200) NOT NULL,
    responsavel_evt_paral VARCHAR(100),
    info_evt_paral VARCHAR(500),
    local_evt_paral VARCHAR(100) NOT NULL,
    data_evt_paral DATE NOT NULL,
    hora_evt_paral TIME NOT NULL
);

---- Criando a tabela de fluxo da programação ----
---- Essa tabela não foi usada neste sistema, pois ela foi criada pensando em futuras atualizações do sistema ----
CREATE Table fluxo_programacao (
    id_flux_prog INT PRIMARY KEY AUTO_INCREMENT,
    cpf_usu VARCHAR(11),
    CONSTRAINT fk_cpf_flx_prog FOREIGN KEY (cpf_usu) REFERENCES usuario (cpf_usu),
    id_prog_film INT,
    CONSTRAINT fk_prog_flx_prog FOREIGN KEY (id_prog_film) REFERENCES programacao_filme(id_prog_film)
);

---- Criando a tabela de fluxo do evento paralelo ----
---- Essa tabela não foi usada neste sistema, pois ela foi criada pensando em futuras atualizações do sistema ----
CREATE Table fluxo_evento_paralelo (
    id_flux_evt_paral INT PRIMARY KEY AUTO_INCREMENT,
    cpf_usu VARCHAR(11),
    CONSTRAINT fk_cpf_flx_evt_paral Foreign Key (cpf_usu) REFERENCES usuario(cpf_usu),
    id_evt_paral INT,
    CONSTRAINT fk_id_evt_paral_flx_evt_paral Foreign Key (id_evt_paral) REFERENCES evento_paralelo(id_evt_paral)
);

---- Criando a tabele para o controle dos filmes ----
---- Essa tabela não foi usada neste sistema, pois ela foi criada pensando em futuras atualizações do sistema ----
CREATE TABLE controle_filme (
    id_control_film INT PRIMARY KEY AUTO_INCREMENT,
    id_prog_film INT,
    CONSTRAINT fk_id_prog_film_control_film Foreign Key (id_prog_film) REFERENCES programacao_filme (id_prog_film),
    id_sub_film INT,
    CONSTRAINT fk_id_sub_film_control_film Foreign Key (id_sub_film) REFERENCES submissao_filme (id_sub_film)
);

---- Adicionando um usuário ADM que terá acesso total ao sistema ---- 
INSERT into usuarios
VALUES(
        '7548566751',
        'Teste',
        'teste',
        'r',
        '1',
        'Administrador'
    );

---- Testando um consulta que será transformada em uma View ----
SELECT filme.nome_sub_film as "Filme",
    programacao.local_prog_film as "Local",
    programacao.data_prog_film as "Data",
    programacao.hora_prog_film as "Hora",
    filme.categoria_sub_film as "Categoria",
    filme.faixa_etaria_sub_film as "Classificação",
    CONCAT(
        filme.info_sub_film,
        ' ',
        filme.sobrenome_diretor_sub_film
    ) as "Diretor",
    programacao.info_prog_film as "Informações"
FROM programacao_filme as programacao
    INNER JOIN submissao_filme as filme USING(id_sub_film)
GROUP BY programacao.id_prog_film;

---- Criando um View para juntar as consultas das tabelas a programação com os filmes ----
create VIEW listagem_filmes as
SELECT filme.nome_sub_film as "Filme",
    programacao.local_prog_film as "Local",
    programacao.data_prog_film as "Data",
    programacao.hora_prog_film as "Hora",
    filme.categoria_sub_film as "Categoria",
    filme.faixa_etaria_sub_film as "Classificação",
    CONCAT(
        filme.nome_diretor_sub_film,
        ' ',
        filme.sobrenome_diretor_sub_film
    ) as "Diretor",
    programacao.info_prog_film as "Informações"
FROM programacao_filme as programacao
    INNER JOIN submissao_filme as filme USING(id_sub_film)
GROUP BY programacao.id_prog_film;

---- Modificando uma coluna ----
ALTER Table programacao_filme DROP COLUMN nome_prog_film;

---- Criando View simples para todas as consultas ----
CREATE VIEW listar_usuarios as
SELECT *
FROM usuario;
CREATE View listar_submissoes as
SELECT *
FROM submissao_filme;
CREATE View listar_eventos as
SELECT *
FROM evento_paralelo;
CREATE VIEW listar_programacoes as
SELECT *
FROM programacao_filme;

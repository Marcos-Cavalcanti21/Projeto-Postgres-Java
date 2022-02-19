---------------------------
--------- TABELAS ---------
---------------------------

CREATE DATABASE NOVA_MODA_DB;

CREATE TABLE CATEGORIA(
  ID SERIAL PRIMARY KEY,
  NOME VARCHAR NOT NULL
);

CREATE TABLE CARGO(
  ID SERIAL PRIMARY KEY,
  TITULO VARCHAR NOT NULL
);

CREATE TABLE PRODUTO(
  ID SERIAL PRIMARY KEY,
  NOME VARCHAR NOT NULL,
  CATEGORIAID INT NOT NULL,
  VENDAS INT NOT NULL DEFAULT 0,
  ESTOQUE INT NOT NULL DEFAULT 0,
  PRECO MONEY NOT NULL,
  FOREIGN KEY (CATEGORIAID) REFERENCES CATEGORIA(ID)
);

CREATE TABLE FUNCIONARIO(
  ID SERIAL PRIMARY KEY,
  NOME VARCHAR NOT NULL,
  TELEFONE VARCHAR NOT NULL,
  CPF VARCHAR NOT NULL,
  VALORVENDIDO MONEY,
  QTDENTREG INT,
  ENDERECO VARCHAR,
  EMAIL VARCHAR,
  CARGOID INT,
  FOREIGN KEY (CARGOID) REFERENCES CARGO(ID)
 );

 CREATE TABLE CLIENTE(
   ID SERIAL PRIMARY KEY,
   NOME VARCHAR NOT NULL,
   TELEFONE VARCHAR,
   ENDERECO VARCHAR,
   EMAIL VARCHAR,
   CPF VARCHAR
 );

 CREATE TABLE VENDA(
   ID SERIAL PRIMARY KEY,
   DATAHORA TIMESTAMP DEFAULT NOW(),
   IDCLIENTE INT,
   IDFUNCIONARIO INT,
   IDPRODUTO INT NOT NULL,
   QTD INT DEFAULT 1 NOT NULL,
   TOTAL MONEY NOT NULL,
   ENTREGA BOOLEAN DEFAULT FALSE,
   IDENTREGADOR INT,
   FOREIGN KEY (IDCLIENTE) REFERENCES CLIENTE(ID),
   FOREIGN KEY (IDFUNCIONARIO) REFERENCES FUNCIONARIO(ID),
   FOREIGN KEY (IDPRODUTO) REFERENCES PRODUTO(ID),
   FOREIGN KEY (IDENTREGADOR) REFERENCES FUNCIONARIO(ID)
 );

 CREATE TABLE CAIXA(
	DIA DATE,
	INICIO MONEY,
	ENTRADAS MONEY,
	SAIDAS MONEY,
	SALDO MONEY
);

-------------------------------
--- FUNCTIONS && PROCEDURES ---
-------------------------------

--- CONFIGURAÇÕES DE CAIXA ---

CREATE OR REPLACE FUNCTION ABRE_CAIXA(MONEY)
RETURNS VOID
AS $$
	INSERT INTO CAIXA
    		VALUES (NOW(), $1, 0, 0, $1);
$$
LANGUAGE 'sql';

-------------------------------------------------------

CREATE OR REPLACE FUNCTION ATUALIZA_CAIXA(MONEY)
RETURNS VOID
AS $$
	UPDATE CAIXA SET ENTRADAS = ((SELECT ENTRADAS FROM CAIXA WHERE DIA = NOW()) + $1)
    WHERE DIA = NOW();

    UPDATE CAIXA SET SALDO = ((SELECT INICIO FROM CAIXA WHERE DIA = NOW()) +
                              (SELECT ENTRADAS FROM CAIXA WHERE DIA = NOW()) -
                              (SELECT SAIDAS FROM CAIXA WHERE DIA = NOW())
                              );
$$
LANGUAGE 'sql';

-------------------------------------------------------

CREATE OR REPLACE FUNCTION FECHA_CAIXA(MONEY)
RETURNS MONEY
AS $$
		SELECT SALDO FROM CAIXA WHERE DIA = NOW();
$$
LANGUAGE 'sql';


--------------------------------------------------------

------------------------
-- INSERTS PROCEDURES --
------------------------

CREATE OR REPLACE PROCEDURE INSERT_CATEGORIA(C_NOME VARCHAR)
AS $$
		INSERT INTO CATEGORIA(NOME)
        VALUES (C_NOME);
$$
LANGUAGE 'sql';

----------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_CARGO(C_TITULO VARCHAR)
AS $$
		INSERT INTO CARGO(TITULO)
        VALUES (C_TITULO);
$$
LANGUAGE 'sql';

----------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_PRODUTO(P_NOME VARCHAR
                                           , P_CATEGORIA VARCHAR
                                           , P_PRECO MONEY)
AS $$
		INSERT INTO PRODUTO (NOME, CATEGORIAID, PRECO)
        VALUES (P_NOME
                , (SELECT ID FROM CATEGORIA WHERE NOME LIKE '%'||P_CATEGORIA||'%')
                , P_PRECO);
$$
LANGUAGE 'sql';

----------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_FUNCIONARIO(F_NOME VARCHAR
                                               , F_TELEFONE VARCHAR
                                               , F_CPF VARCHAR
                                               , F_ENDERECO VARCHAR
                                               , F_EMAIL VARCHAR
                                               , F_CARGO VARCHAR)
AS $$

		INSERT INTO FUNCIONARIO(NOME, TELEFONE, CPF, ENDERECO, EMAIL, CARGOID)
        VALUES (F_NOME, F_TELEFONE, F_CPF, F_ENDERECO, F_EMAIL, (SELECT ID FROM CARGO WHERE TITULO LIKE '%'||F_CARGO||'%'))
$$
LANGUAGE 'sql';

-----------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_CLIENTE(C_NOME VARCHAR
                                           , C_TELEFONE VARCHAR
                                           , C_ENDERECO VARCHAR
                                           , C_EMAIL VARCHAR
                                           , C_CPF VARCHAR)
AS $$
		INSERT INTO CLIENTE(NOME, TELEFONE, ENDERECO, EMAIL, CPF)
        VALUES (C_NOME, C_TELEFONE, C_ENDERECO, C_EMAIL, C_CPF)
$$
LANGUAGE 'sql';

-------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_VENDA(V_CLIENTE VARCHAR
                                         , V_FUNCIONARIO VARCHAR
                                         , V_PRODUTO VARCHAR
                                         , V_QTD INT
                                         , V_ENTREGA BOOLEAN
                                         , V_ENTREGADOR VARCHAR)
AS $$
	INSERT INTO VENDA(IDCLIENTE, IDFUNCIONARIO, IDPRODUTO, QTD, TOTAL, ENTREGA, IDENTREGADOR)
    VALUES (/*SELECIONA PELO ID vvv*/
/*CLIENTE*/ (SELECT ID FROM CLIENTE WHERE NOME LIKE '%'||V_CLIENTE||'%'),
/*FUNCIO*/  (SELECT ID FROM FUNCIONARIO WHERE NOME LIKE '%'||V_FUNCIONARIO||'%'),
/*PRODUTO*/ (SELECT ID FROM PRODUTO WHERE NOME LIKE '%'||V_PRODUTO||'%'),
/*QUANTIDADE*/ V_QTD,
      		(SELECT PRECO FROM PRODUTO WHERE NOME LIKE '%'||V_PRODUTO||'%' ),
      		V_ENTREGA,
/*ENTRGDR*/ (SELECT ID FROM FUNCIONARIO WHERE NOME LIKE '%'||V_ENTREGADOR||'%')
      );

      UPDATE PRODUTO SET ESTOQUE =(ESTOQUE - V_QTD) WHERE NOME LIKE '%'||V_PRODUTO||'%'
$$
LANGUAGE 'sql';
---------------------------------------------------------------

CREATE OR REPLACE PROCEDURE INSERT_ESTOQUE(E_PRODUTO VARCHAR
                                          , E_QTD INT)
AS $$
	UPDATE PRODUTO SET ESTOQUE = (ESTOQUE + E_QTD) WHERE NOME LIKE '%'||E_PRODUTO||'%';
$$
LANGUAGE 'sql';

----------------------------------------------------------------

---------------------------
----- GETS PROCEDURES -----
---------------------------

CREATE OR REPLACE PROCEDURE GET_

---------------------------------------------------------------








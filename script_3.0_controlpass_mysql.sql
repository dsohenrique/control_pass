
DROP DATABASE IF EXISTS control_pass;

CREATE DATABASE control_pass;

USE control_pass;

CREATE TABLE tbl_usuario(
	id_usuario		int				NOT NULL ,
	cpf			    varchar(11)		NOT NULL,
    nome 			varchar(100)	NOT NULL,
    tipo_usuario	int				NOT NULL,
    email 			varchar(150)	NOT NULL,
    status 			int 			NOT NULL,
    login 			varchar(50)		NOT NULL,
	senha 	  		varchar(244)	NOT NULL);

ALTER TABLE tbl_usuario ADD CONSTRAINT usuario_pk  PRIMARY KEY(id_usuario);
ALTER TABLE tbl_usuario MODIFY id_usuario int AUTO_INCREMENT;

CREATE TABLE tbl_aluno(
	id_aluno			int NOT NULL  ,
	id_usuario_fk		int	NOT NULL,
    codigo_biometria	int NOT NULL
);
ALTER TABLE		tbl_aluno ADD CONSTRAINT aluno_pk				PRIMARY KEY (id_aluno);
ALTER TABLE 	tbl_aluno MODIFY id_aluno int AUTO_INCREMENT;

ALTER TABLE		tbl_aluno ADD CONSTRAINT id_usuario_aluno_fk	FOREIGN KEY (id_usuario_fk)		REFERENCES tbl_usuario(id_usuario);

CREATE TABLE tbl_curso(
	id_curso	 int		  NOT NULL,
	qtd_modulo	 int 		  NOT NULL);

ALTER TABLE tbl_curso  ADD CONSTRAINT curso_pk  PRIMARY KEY (id_curso);
ALTER TABLE tbl_curso  MODIFY id_curso int AUTO_INCREMENT;

CREATE TABLE tbl_turma(
	id_turma	int			NOT NULL,
	nm_turma	varchar(20) NOT NULL,
	id_curso	int			NOT NULL);

ALTER TABLE tbl_turma ADD CONSTRAINT turma_pk  PRIMARY KEY (id_turma);
ALTER TABLE tbl_turma MODIFY id_turma int AUTO_INCREMENT;

ALTER TABLE tbl_turma ADD CONSTRAINT id_curso_turma_fk FOREIGN KEY (id_curso) references tbl_curso(id_curso);

CREATE TABLE tbl_materia(
	id_materia		int			NOT NULL,
	nm_materia		varchar(20) NOT NULL);

ALTER TABLE 	tbl_materia ADD PRIMARY KEY (id_materia);
ALTER TABLE 	tbl_materia MODIFY id_materia int AUTO_INCREMENT;

CREATE TABLE tbl_chamada(
	id_chamada		int			NOT NULL,
	id_curso_fk 	int			NOT NULL,
	id_turma_fk 	int			NOT NULL,
	id_aluno_fk  	int			NOT NULL,
	id_materia_fk 	int			NOT NULL,
	data			datetime	NOT NULL,
	hora_inicio 	time		NOT NULL,
	hora_final		time		NOT NULL);

ALTER TABLE tbl_chamada ADD CONSTRAINT chamada_pk  PRIMARY KEY (id_chamada);
ALTER TABLE tbl_chamada MODIFY id_chamada int AUTO_INCREMENT;

ALTER TABLE		tbl_chamada ADD CONSTRAINT id_curso_chamada_fk			FOREIGN KEY (id_curso_fk)			REFERENCES tbl_curso(id_curso);

ALTER TABLE		tbl_chamada ADD CONSTRAINT id_turma_chamada_fk			FOREIGN KEY ( id_turma_fk)			REFERENCES tbl_turma(id_turma);
ALTER TABLE		tbl_chamada ADD CONSTRAINT id_aluno_chamada_fk			FOREIGN KEY (id_aluno_fk)			REFERENCES tbl_aluno(id_aluno);

ALTER TABLE		tbl_chamada ADD CONSTRAINT id_materia_chamada_fk		FOREIGN KEY (id_materia_fk)			REFERENCES tbl_materia(id_materia);

SELECT*FROM tbl_chamada;

SELECT*FROM tbl_turma;

SELECT*FROM tbl_materia;

SELECT*FROM tbl_aluno;

INSERT INTO tbl_usuario (id_usuario, cpf, nome, tipo_usuario, email, status, login, senha)
VALUES 					(1,1234, 'masterPadrao', 1, 'teste', 1, 'admin', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92');

SELECT*FROM tbl_usuario;





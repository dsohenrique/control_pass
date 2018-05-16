/*USE master*/
/*go*/
DROP DATABASE IF EXISTS control_pass;
/*go*/
CREATE DATABASE control_pass;
/*go*/

USE control_pass;
/*go*/

CREATE TABLE tbl_usuario(
	id_usuario		int				NOT NULL ,
	cpf			    varchar(11)		NOT NULL,
    nome 			varchar(100)	NOT NULL,
    tipo_usuario	int				NOT NULL,
    email 			varchar(150)	NOT NULL,
    status 			int 			NOT NULL,
    login 			varchar(50)		NOT NULL,
	senha 	  		varchar(244)	NOT NULL);
/*go*/
ALTER TABLE tbl_usuario ADD CONSTRAINT usuario_pk  PRIMARY KEY(id_usuario);
ALTER TABLE tbl_usuario MODIFY id_usuario int AUTO_INCREMENT;
/*go*/
CREATE TABLE tbl_aluno(
	id_aluno			int NOT NULL  ,
	id_usuario_fk		int	NOT NULL,
    codigo_biometria	int NOT NULL
);
ALTER TABLE		tbl_aluno ADD CONSTRAINT aluno_pk				PRIMARY KEY (id_aluno);
ALTER TABLE 	tbl_aluno MODIFY id_aluno int AUTO_INCREMENT;
/*go*/
ALTER TABLE		tbl_aluno ADD CONSTRAINT id_usuario_aluno_fk	FOREIGN KEY (id_usuario_fk)		REFERENCES tbl_usuario(id_usuario);
/*go*/
/*CREATE TABLE tbl_professor(
    id_professor int NOT NULL,
    
)
ALTER TABLE tbl_professor ADD CONSTRAINT professor_pk   PRIMARY KEY (id_professor)*/
/*go*/
CREATE TABLE tbl_curso(
	id_curso	 int		  NOT NULL  AUTO_INCREMENT,
	qtd_modulo	 int 		  NOT NULL);
/*go*/
ALTER TABLE tbl_curso  ADD CONSTRAINT curso_pk  PRIMARY KEY (id_curso);
/*go*/
CREATE TABLE tbl_turma(
	id_turma	int			NOT NULL  AUTO_INCREMENT,
	nm_turma	varchar(20) NOT NULL,
	id_curso	int			NOT NULL);
/*go*/
ALTER TABLE tbl_turma ADD CONSTRAINT turma_pk  PRIMARY KEY (id_turma);
/*go*/
ALTER TABLE tbl_turma ADD CONSTRAINT id_curso_turma_fk FOREIGN KEY (id_curso) references tbl_curso(id_curso);
/*go*/
CREATE TABLE tbl_materia(
	id_materia		int			NOT NULL  AUTO_INCREMENT,
	/*id_professor_fk int 		NOT NULL,*/
	nm_materia		varchar(20) NOT NULL);
/*go*/
ALTER TABLE 	tbl_materia ADD PRIMARY KEY (id_materia);
/*go*/
/*ALTER TABLE		tbl_materia ADD CONSTRAINT id_professor_materia_fk		FOREIGN KEY (id_professor_fk)		REFERENCES tbl_professor(id_professor)*/
/*go*/
CREATE TABLE tbl_chamada(
	id_chamada		int			NOT NULL  AUTO_INCREMENT,
	id_curso_fk 	int			NOT NULL,
	id_turma_fk 	int			NOT NULL,
/*	id_professor_fk int			NOT NULL, */
	id_aluno_fk  	int			NOT NULL,
	id_materia_fk 	int			NOT NULL,
	data			datetime	NOT NULL,
	hora_inicio 	time		NOT NULL,
	hora_final		time		NOT NULL);
/*go*/
ALTER TABLE tbl_chamada ADD CONSTRAINT chamada_pk  PRIMARY KEY (id_chamada);
/*go*/
ALTER TABLE		tbl_chamada ADD CONSTRAINT id_curso_chamada_fk			FOREIGN KEY (id_curso_fk)			REFERENCES tbl_curso(id_curso);
/*go*/	
ALTER TABLE		tbl_chamada ADD CONSTRAINT id_turma_chamada_fk			FOREIGN KEY ( id_turma_fk)			REFERENCES tbl_turma(id_turma);
/*go*/
/*ALTER TABLE		tbl_chamada ADD CONSTRAINT id_professor_chamada_fk		FOREIGN KEY (id_professor_fk)		REFERENCES tbl_professor(id_professor);*/
/*go*/
ALTER TABLE		tbl_chamada ADD CONSTRAINT id_aluno_chamada_fk			FOREIGN KEY (id_aluno_fk)			REFERENCES tbl_aluno(id_aluno);
/*go*/
ALTER TABLE		tbl_chamada ADD CONSTRAINT id_materia_chamada_fk		FOREIGN KEY (id_materia_fk)			REFERENCES tbl_materia(id_materia);
/*go*/
SELECT*FROM tbl_chamada;
/*go*/
SELECT*FROM tbl_turma;
/*go*/
/*SELECT*FROM tbl_professor*/
/*go*/
SELECT*FROM tbl_materia;
/*go*/
SELECT*FROM tbl_aluno;
/*go*/
INSERT INTO tbl_usuario (id_usuario, nome, tipo_usuario, email, status, login, senha)
VALUES 					(1,1234, 'masterPadrao', 1, 'teste', 1, 'admin', 123456 
);
/*go*/
SELECT*FROM tbl_usuario;

/*ALTER TABLE Persons ADD PRIMARY KEY (ID); */
/*ALTER TABLE Orders ADD FOREIGN KEY (PersonID) REFERENCES Persons(PersonID);*/
/*go SELECT*FROM usuario */
/*go*/




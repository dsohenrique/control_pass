DROP DATABASE IF EXISTS control_pass;

CREATE DATABASE control_pass;

USE control_pass;

CREATE TABLE tbl_tipo(
        id      INT NOT NULL,
        tipo    varchar(15) NOT NULL
);

ALTER TABLE tbl_tipo ADD CONSTRAINT id_pk  PRIMARY KEY (id);
ALTER TABLE tbl_tipo  MODIFY id int AUTO_INCREMENT;

INSERT INTO tbl_tipo (tipo) VALUES('Administrador');
INSERT INTO tbl_tipo (tipo) VALUES('Responsavel');
INSERT INTO tbl_tipo (tipo) VALUES('Professor');


CREATE TABLE tbl_status(
        id      INT NOT NULL,
        status    varchar(10) NOT NULL
);

ALTER TABLE tbl_status ADD CONSTRAINT id_pk  PRIMARY KEY (id);
ALTER TABLE tbl_status  MODIFY id int AUTO_INCREMENT;

INSERT INTO tbl_status (status) VALUES('Ativo');
INSERT INTO tbl_status (status) VALUES('Inativo');

CREATE TABLE tbl_usuario(
	id_usuario		int				NOT NULL,
	rm              int,
	cpf			    varchar(11)		NOT NULL,
    nome 			varchar(100)	NOT NULL,
    tipo_usuario	char(1)					,				
    email 			varchar(150)	NOT NULL,
    status 			varchar(10)		NOT NULL,
    login 			varchar(50)		NOT NULL,
	senha 	  		varchar(244)	NOT NULL);

ALTER TABLE tbl_usuario ADD CONSTRAINT usuario_pk  PRIMARY KEY(id_usuario);
ALTER TABLE tbl_usuario MODIFY id_usuario int AUTO_INCREMENT;

CREATE TABLE tbl_aluno(
	rm					int NOT NULL,
	nome_aluno          varchar(30) NOT NULL
);
ALTER TABLE	tbl_aluno ADD CONSTRAINT aluno_pk PRIMARY KEY (rm);



CREATE TABLE tbl_curso(
	id_curso	 int		  NOT NULL,
	qtd_modulo	 int 		  NOT NULL,
	nm_curso	varchar(30)	  NOT NULL);

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
	rm_fk  			int			NOT NULL,
	id_materia_fk 	int			NOT NULL,
	data            date        NOT NULL,
	hora_inicio 	time		NOT NULL,
	hora_final		time		,
    situacao		varchar(8));

ALTER TABLE tbl_chamada ADD CONSTRAINT chamada_pk  PRIMARY KEY (id_chamada);

ALTER TABLE tbl_chamada MODIFY id_chamada int AUTO_INCREMENT;

ALTER TABLE		tbl_chamada ADD CONSTRAINT id_curso_chamada_fk			FOREIGN KEY (id_curso_fk)			REFERENCES tbl_curso(id_curso);

ALTER TABLE		tbl_chamada ADD CONSTRAINT id_turma_chamada_fk			FOREIGN KEY ( id_turma_fk)			REFERENCES tbl_turma(id_turma);

ALTER TABLE		tbl_chamada ADD CONSTRAINT id_materia_chamada_fk		FOREIGN KEY (id_materia_fk)			REFERENCES tbl_materia(id_materia);

ALTER TABLE		tbl_chamada ADD CONSTRAINT rm_fk		        		FOREIGN KEY (rm_fk)	        		REFERENCES tbl_aluno(rm);

INSERT INTO tbl_usuario (cpf, nome, tipo_usuario, email, status, login, senha)
VALUES 					(1234, 'masterPadrao', 1, 'teste', 1, 'admin', '8D969EEF6ECAD3C29A3A629280E686CF0C3F5D5A86AFF3CA12020C923ADC6C92');

INSERT INTO tbl_aluno ( rm, nome_aluno)
VALUES 					(000001, 'Lucas');
INSERT INTO tbl_aluno ( rm, nome_aluno)
VALUES 					(000002, 'Joel');
INSERT INTO tbl_aluno ( rm, nome_aluno)
VALUES 					(000003, 'Gustavo');

INSERT INTO tbl_aluno ( rm, 	nome_aluno)
VALUES 				  (000004, 'Douglas');


INSERT INTO tbl_curso (qtd_modulo, nm_curso) VALUES (3,'INFORMATICA'); 
INSERT INTO tbl_turma(nm_turma, id_curso) VALUES ('3Q',1);
INSERT INTO tbl_materia(nm_materia) value ('TLBD');

DELIMITER $$
CREATE TRIGGER set_data BEFORE INSERT
ON tbl_chamada
FOR EACH ROW
BEGIN
SET NEW.data = (CURRENT_TIMESTAMP());
SET NEW.hora_inicio = (CURRENT_TIME());
END $$
DELIMITER ;



INSERT INTO tbl_chamada(id_curso_fk, id_turma_fk,id_materia_fk, rm_fk)
VALUES 					(1, 1,1,000001);

INSERT INTO tbl_chamada(id_curso_fk, id_turma_fk, id_materia_fk, rm_fk)
VALUES 					(1,1,1,000002);

INSERT INTO tbl_chamada(id_curso_fk, id_turma_fk,id_materia_fk, rm_fk)
VALUES 					(1,1,1,000003);


INSERT INTO tbl_chamada(id_curso_fk, id_turma_fk,id_materia_fk, rm_fk)
VALUES 					(1, 1,1,000004);


DROP PROCEDURE IF EXISTS set_situacao;

 DELIMITER $$
    CREATE PROCEDURE set_situacao (IN rm_aluno int, IN data date)
	BEGIN
		(SELECT TimeDiff(c.hora_final ,c.hora_inicio)  INTO @permanencia  FROM tbl_chamada c WHERE rm_fk = rm_aluno AND c.data = data);
        
		/*(SELECT data INTO @data FROM tbl_chamada WHERE rm_fk = rm_aluno);*/

        IF (select @permanencia > '00:02:00' /*@data = CURRENT_TIMESTAMP()*/)
        
        THEN
                SET @situacao = 'PRESENTE';
        ELSE
                SET @situacao = 'AUSENTE';
           
        END IF;
        
        UPDATE tbl_chamada c SET c.situacao = @situacao WHERE rm_fk = rm_aluno AND c.data = data;
        
    END $$
    DELIMITER ; 
    
	DELIMITER $$
		CREATE PROCEDURE reset_senha (IN cpf varchar(11))
		BEGIN
		 UPDATE tbl_usuario u  SET u.senha = 'A113175A068F0E2EF8BA11225965DD8F56B11827637C996C2206094D39273695' WHERE u.cpf = cpf;        
		END $$
	DELIMITER ;
    
	

    UPDATE tbl_chamada c SET c.hora_final = CURRENT_TIME() WHERE c.rm_fk = 000001 AND c.data = CURRENT_DATE();
    UPDATE tbl_chamada c SET c.hora_final = CURRENT_TIME() WHERE c.rm_fk = 000002 AND c.data = CURRENT_DATE();
    UPDATE tbl_chamada c SET c.hora_final = CURRENT_TIME() WHERE c.rm_fk = 000003 AND c.data = CURRENT_DATE();
    UPDATE tbl_chamada c SET c.hora_final = CURRENT_TIME() WHERE c.rm_fk = 000004 AND c.data = CURRENT_DATE();
    
    CALL set_situacao(1, CURRENT_DATE());
    CALL set_situacao(2, CURRENT_DATE());
    CALL set_situacao(3, CURRENT_DATE());
    CALL set_situacao(4, CURRENT_DATE());
    

    SELECT * FROM tbl_chamada;

/*
DELIMITER $$
    CREATE PROCEDURE reset_senha (IN cpf varchar(11))
    BEGIN
     UPDATE tbl_usuario u  SET u.senha = 'A113175A068F0E2EF8BA11225965DD8F56B11827637C996C2206094D39273695' WHERE u.cpf =cpf;        
    END $$
    DELIMITER ;
CALL reset_senha(29927608896);
DELIMITER $$
    CREATE TRIGGER get_presenca AFTER UPDATE
		ON tbl_chamada
		FOR EACH ROW
        BEGIN
		CALL set_situacao(NEW.rm_fk);
        END $$
	DELIMITER ;*/
 
   
/*
DELIMITER $$
		CREATE TRIGGER get_presenca AFTER UPDATE
			ON tbl_chamada
			FOR EACH ROW
			BEGIN
			CALL set_situacao(4);
			END $$
		DELIMITER ;
        
    UPDATE tbl_chamada c SET c.hora_final = CURRENT_TIME() WHERE c.rm_fk = 000004;

 DROP TRIGGER IF EXISTS get_presenca;
DROP TABLE tbl_chamada;

  CALL set_situacao (000001);
   CALL set_situacao (000002);
   CALL set_situacao (4);

    SELECT * FROM tbl_chamada ;
SELECT*FROM tbl_curso;
    UPDATE tbl_chamada c SET c.hora_final = CURRENT_TIME() WHERE c.rm_fk = 4;

SELECT*FROM tbl_turma;

SELECT*FROM tbl_materia;

SELECT*FROM tbl_aluno;

SELECT				id_aluno, nome, data, hora_inicio, hora_final 
FROM		 		tbl_aluno a 
INNER JOIN 			tbl_usuario u 	
ON 					u.id_usuario = a.id_usuario_fk 
INNER JOIN 			tbl_chamada c 
ON 					id_aluno = id_aluno_fk 
WHERE 				tipo_usuario = 2 
AND 				cpf = 47467670842 


SELECT a.rm, nome_aluno, u.rm, u.cpf, u.tipo_usuario, data, hora_inicio, 
hora_final FROM tbl_aluno a INNER JOIN tbl_usuario u ON 69591218 = u.rm INNER JOIN tbl_chamada c ON c.rm = a.rm  
WHERE u.rm = ? AND u.tipo_usuario = 2;



DROP TRIGGER IF EXISTS set_data;
CREATE TRIGGER set_data BEFORE INSERT
ON tbl_chamada
FOR EACH ROW
SET NEW.data = (CURRENT_TIMESTAMP());

DROP  TRIGGER IF EXISTS set_hora ;
CREATE TRIGGER set_hora BEFORE INSERT
ON tbl_chamada
FOR EACH ROW
SET NEW.hora_inicio = (CURRENT_TIMESTAMP());


    INSERT INTO tbl_aluno ( rm, nome_aluno)
VALUES 					(000004, 'Douglas');


INSERT INTO tbl_chamada(id_curso_fk, id_turma_fk,id_materia_fk, nome_aluno, rm_fk, status_inicio)
VALUES 					(1, 1,1,'Douglas',000004, 1);

UPDATE tbl_chamada SET status_final = 1 WHERE rm_fk = 000004;

 DELIMITER $$
    CREATE PROCEDURE set_situacao (IN rm_aluno int)
    BEGIN
        (SELECT c.status_inicio     INTO @status_inicio         FROM tbl_chamada c WHERE c.rm_fk = rm_aluno);
        
        (SELECT c.status_final      INTO  @status_final         FROM tbl_chamada c WHERE c.rm_fk  = rm_aluno);
        
        (SELECT c.hora_inicio       INTO @hora_inicio           FROM tbl_chamada c WHERE c.rm_fk = rm_aluno);
        
        (SELECT c.hora_final        INTO @hora_final            FROM tbl_chamada c WHERE c.rm_fk = rm_aluno);
        
      /* SET @permanecia = TIMEDIFF(@hora_inicio, @hora_final);*//*
        
        IF TIMEDIFF(@hora_inicio, @hora_final) > 01 AND (@status_inicio = 1) AND (@status_final = 1)
        
        THEN
                SET @situacao = 'PRESENTE';
        ELSE
                SET @situacao = 'AUSENTE';
           
        END IF; 
        UPDATE tbl_chamada c SET c.situacao = @situacao WHERE rm_fk = rm_aluno;
        
    END $$
    DELIMITER ;
*/
CREATE TABLE if NOT EXISTS  estadio(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) UNIQUE NOT NULL,
  ativo BOOLEAN,
  PRIMARY KEY (id)
)engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO estadio(nome, ativo) VALUES ('Pelezão', 1);
INSERT INTO estadio(nome, ativo) VALUES ('Garrinchão', 1);
CREATE TABLE if NOT EXISTS  time(
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) UNIQUE NOT NULL,
  PRIMARY KEY (id)
)engine=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO time(nome) VALUES ('Nova Terra');
INSERT INTO time(nome) VALUES ('Cidade Verde');
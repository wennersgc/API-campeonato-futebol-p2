CREATE TABLE IF NOT EXISTS campeonato (
  id INTEGER NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL ,
  ano_campeonato DATE NOT NULL,
  ativo BOOLEAN NOT NULL,
  PRIMARY KEY (id)
)engine=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO campeonato(nome, ano_campeonato, ativo)
        VALUES ('Intermunicipal', '2018-01-01', true);
INSERT INTO campeonato(nome, ano_campeonato, ativo)
        VALUES ('Baixadão', '2017-01-01', false);


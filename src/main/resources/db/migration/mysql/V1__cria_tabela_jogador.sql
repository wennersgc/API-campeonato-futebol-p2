CREATE TABLE IF NOT EXISTS jogador (
  id INTEGER NOT NULL AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL ,
  data_nascimento DATE NOT NULL,
  genero VARCHAR(255) NOT NULL ,
  altura DOUBLE NOT NULL,
  ativo BOOLEAN NOT NULL,
  id_time INTEGER NOT NULL ,
  instante_criacao DATETIME NOT NULL,
  ultima_atualizacao DATETIME,
  PRIMARY KEY (`id`)
  )engine=InnoDB DEFAULT CHARSET=utf8;

  INSERT INTO jogador(nome, data_nascimento, genero, altura, ativo, id_time, instante_criacao, ultima_atualizacao)
        VALUES ('Mario Joaquim', '1998-03-12', 'M', 1.78, true, 1, '1998-01-19 03:14:07', '2018-01-19 03:14:07');

  INSERT INTO jogador(nome, data_nascimento, genero, altura, ativo, id_time, instante_criacao, ultima_atualizacao)
        VALUES ('Fernandi', '2000-07-06', 'M', 1.87, true, 1, '1998-01-19 03:14:07', '2018-01-19 03:14:07');

 INSERT INTO jogador(nome, data_nascimento, genero, altura, ativo, id_time, instante_criacao, ultima_atualizacao)
        VALUES ('Pedro', '2000-07-06', 'M', 1.87, false, 2, '1998-01-19 03:14:07', '2018-01-19 03:14:07');
CREATE TABLE IF NOT EXISTS partida (
  id INTEGER NOT NULL AUTO_INCREMENT,
  data_partida DATE NOT NULL,
  id_anfitriao INT,
  id_visitante INT,
  gols_anfitriao INT NOT NULL,
  gols_visitante INT NOT NULL,
  pontos_anfitriao INT(1) NOT NULL,
  pontos_visitante INT(1) NOT NULL,
  PRIMARY KEY (`id`)
)engine=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE partida ADD CONSTRAINT fk_anfitriao FOREIGN KEY (id_anfitriao) REFERENCES time (id);
ALTER TABLE partida ADD CONSTRAINT fk_visitante FOREIGN KEY (id_visitante) REFERENCES time (id);


INSERT INTO partida(data_partida, id_anfitriao, id_visitante, gols_anfitriao, gols_visitante,
              pontos_anfitriao,  pontos_visitante) VALUES ('2018-03-03', 1, 2, 2, 1, 3, 0);

INSERT INTO partida(data_partida, id_anfitriao, id_visitante, gols_anfitriao, gols_visitante,
              pontos_anfitriao,  pontos_visitante) VALUES ('2018-05-03', 2, 1, 1, 0, 3, 0);

INSERT INTO partida(data_partida, id_anfitriao, id_visitante, gols_anfitriao, gols_visitante,
              pontos_anfitriao,  pontos_visitante) VALUES ('2018-05-03', 1, 2, 0, 2, 0, 3);

INSERT INTO partida(data_partida, id_anfitriao, id_visitante, gols_anfitriao, gols_visitante,
              pontos_anfitriao,  pontos_visitante) VALUES ('2018-05-03', 1, 2, 1, 1, 1, 1);

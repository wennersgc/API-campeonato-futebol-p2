CREATE TABLE IF NOT EXISTS campeonato_times (
  id_campeonato INTEGER NOT NULL,
  id_time INTEGER NOT NULL
)engine=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE campeonato_times ADD CONSTRAINT fk_campeonato_time
      FOREIGN KEY (id_campeonato) REFERENCES campeonato (id);

ALTER TABLE campeonato_times ADD CONSTRAINT fk_time_campeonato
      FOREIGN KEY (id_time) REFERENCES time (id);

INSERT INTO campeonato_times(id_campeonato, id_time) VALUES (1, 1);
INSERT INTO campeonato_times(id_campeonato, id_time) VALUES (1, 2);
INSERT INTO campeonato_times(id_campeonato, id_time) VALUES (2, 1);
INSERT INTO campeonato_times(id_campeonato, id_time) VALUES (2, 2);

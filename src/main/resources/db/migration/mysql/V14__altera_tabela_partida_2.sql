ALTER TABLE partida ADD id_campeonato INT;
ALTER TABLE partida ADD CONSTRAINT fk_partida_campeonato
            FOREIGN KEY (id_campeonato) REFERENCES campeonato(id);

UPDATE partida SET id_campeonato = 1 WHERE id = 1;
UPDATE partida SET id_campeonato = 2 WHERE id = 2;
UPDATE partida SET id_campeonato = 1 WHERE id = 3;
UPDATE partida SET id_campeonato = 2 WHERE id = 4;
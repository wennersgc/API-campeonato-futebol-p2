ALTER TABLE partida ADD id_estadio INT;
ALTER TABLE partida ADD CONSTRAINT fk_estadio_partida FOREIGN KEY (id_estadio) REFERENCES estadio(id);

UPDATE partida SET id_estadio = 1 WHERE id = 1;
UPDATE partida SET id_estadio = 2 WHERE id = 2;
UPDATE partida SET id_estadio = 1 WHERE id = 3;
UPDATE partida SET id_estadio = 1 WHERE id = 4;
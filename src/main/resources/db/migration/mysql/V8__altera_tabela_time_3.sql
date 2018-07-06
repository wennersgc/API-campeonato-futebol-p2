ALTER TABLE time ADD id_sede int(11) AFTER id_capitao;

ALTER TABLE time ADD CONSTRAINT fk_estadio
FOREIGN KEY (id_sede) REFERENCES estadio (id);

UPDATE time SET id_sede = 1 WHERE id = 1;
UPDATE time SET id_sede = 2  WHERE id = 2;



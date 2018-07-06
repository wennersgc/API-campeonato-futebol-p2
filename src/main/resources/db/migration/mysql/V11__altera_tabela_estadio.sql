ALTER TABLE estadio ADD endereco VARCHAR (255);

UPDATE estadio SET endereco = 'Rua dos Atletas, Mocajituba' WHERE id = 1;
UPDATE estadio SET endereco = 'Rua do Barro, Cururupu' WHERE id = 2;

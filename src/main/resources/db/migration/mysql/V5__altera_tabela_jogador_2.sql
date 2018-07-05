ALTER TABLE jogador ADD numero_camisa int(11) NOT NULL AFTER altura;
ALTER TABLE jogador ADD posicao VARCHAR(255) NOT NULL AFTER numero_camisa;

INSERT INTO jogador (numero_camisa, posicao) VALUES(10, 'Meia esquerda');
INSERT INTO jogador (numero_camisa, posicao) VALUES(5, 'Volante');
INSERT INTO jogador (numero_camisa, posicao) VALUES(1, 'Goleiros');


ALTER TABLE jogador ADD numero_camisa int(11) NOT NULL AFTER altura;
ALTER TABLE jogador ADD posicao VARCHAR(255) NOT NULL AFTER numero_camisa;
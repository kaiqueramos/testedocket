--DROP DE TABELAS--
DROP TABLE IF EXISTS TB_CARTORIOS_CERTIDOES;
DROP TABLE IF EXISTS TB_CERTIDOES; 
DROP TABLE IF EXISTS TB_CARTORIOS;

--TABELA CARTÓRIOS--
CREATE TABLE TB_CARTORIOS(
	id_cartorio INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(45) NOT NULL UNIQUE,
	endereco VARCHAR(100) NOT NULL
);

--TABELA CERTIDÕES--
CREATE TABLE TB_CERTIDOES(
	id_certidao INT AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(45) NOT NULL UNIQUE
);

--TABELA DE RELACIONAMENTO 1 CARTORIO :: CERTIDÕES 1..N --
CREATE TABLE TB_CARTORIOS_CERTIDOES(
	fk_id_cartorio INT NOT NULL,
	fk_id_certidao INT NOT NULL,
	FOREIGN KEY (fk_id_cartorio) REFERENCES TB_CARTORIOS(id_cartorio),
	FOREIGN KEY (fk_id_certidao) REFERENCES TB_CERTIDOES(id_certidao)
);

--DADOS FICTÍCIOS--
--TB_CARTORIOS--
INSERT INTO TB_CARTORIOS (nome, endereco) VALUES
('Cartorio do Sul', 'Av. Sul, 456'),
('Cartorio do Norte', 'Av. Norte, 123'),
('Cartorio do Leste', 'Av. Leste, 789'),
('Cartorio do Oeste', 'Av. Oeste, 753');

--TB_CERTIDOES--
INSERT INTO TB_CERTIDOES (nome) VALUES
('Certidão de casamento'),
('Certidão de óbito'),
('Certidão de nascimento'),
('Certidão de imóvel'),
('Certidão de trabalho'),
('Certidão de empresa'),
('Certidão de automovel');

--TB_CARTORIOS_CERTIDOES--
INSERT INTO TB_CARTORIOS_CERTIDOES (fk_id_cartorio, fk_id_certidao) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 2),
(2, 3),
(3, 2),
(3, 3),
(3, 5),
(3, 6),
(4, 1),
(4, 3),
(4, 4),
(4, 5),
(4, 7);


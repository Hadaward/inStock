create database sce;
use sce;

create table user(
	user_id INT NOT NULL AUTO_INCREMENT,
    user_name VARCHAR(100) NOT NULL,
    user_login VARCHAR(50) NOT NULL,
    user_password VARCHAR(20) NOT NULL,
    user_admin BOOLEAN NOT NULL,
    PRIMARY KEY(user_id)
);

CREATE TABLE produto(
	produto_id INT NOT NULL AUTO_INCREMENT,
    produto_name VARCHAR(150) NOT NULL,
    produto_peso FLOAT,
    produto_unidade VARCHAR(3) NOT NULL,
    produto_fornecedor VARCHAR(150),
    produto_quant INT NOT NULL,
    PRIMARY KEY(produto_id)
);

CREATE TABLE entrada(
	entrada_id INT NOT NULL AUTO_INCREMENT,
    produto_id INT NOT NULL,
    entrada_data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    entrada_quantidade INT NOT NULL,
    PRIMARY KEY(entrada_id),
    FOREIGN KEY(produto_id) REFERENCES produto(produto_id)
);

CREATE TABLE saida(
	saida_id INT NOT NULL AUTO_INCREMENT,
    produto_id INT NOT NULL,
    saida_data TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    saida_quantidade INT NOT NULL,
    PRIMARY KEY(saida_id),
    FOREIGN KEY(produto_id) REFERENCES produto(produto_id)
);


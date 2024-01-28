CREATE TABLE Cliente (
    idCliente INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    ativo BIT DEFAULT 1 NOT NULL,
    UNIQUE (cpf),
    PRIMARY KEY (idCliente)
);
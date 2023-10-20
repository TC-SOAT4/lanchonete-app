CREATE TABLE PagamentoMercadoPago (
    idPagamentoMercadoPago INT NOT NULL AUTO_INCREMENT,
    pagamentoId INT NULL,
    valor DECIMAL(15, 2) NOT NULL,
    tokenConfirmacao VARCHAR(255) NULL,
    dataConfirmacao VARCHAR(255) NULL,
    PRIMARY KEY (idPagamentoMercadoPago),
    FOREIGN KEY (pagamentoId) REFERENCES Pagamento(idPagamento)
);
CREATE TABLE Pagamento (
    idPagamento INT NOT NULL AUTO_INCREMENT,
    pedidoId INT NOT NULL,
    formaPagamentoId INT NOT NULL,
    statusPagamentoId INT,
    valor DECIMAL(15, 2) NOT NULL,
    PRIMARY KEY (idPagamento),
    FOREIGN KEY (pedidoId) REFERENCES Pedido(idPedido),
    FOREIGN KEY (formaPagamentoId) REFERENCES FormaPagamento(idFormaPagamento),
    FOREIGN KEY (statusPagamentoId) REFERENCES FormaPagamento(idFormaPagamento)
);
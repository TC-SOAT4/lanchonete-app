CREATE TABLE Pedido (
    idPedido INT NOT NULL AUTO_INCREMENT,
    clienteId INT,
    statusPedidoId INT NOT NULL,
    statusPagamentoId INT,
    valorTotal DECIMAL(15, 2) NULL,
    data DATETIME NOT NULL,
    PRIMARY KEY (idPedido),
    FOREIGN KEY (clienteId) REFERENCES Cliente(idCliente),
    FOREIGN KEY (statusPedidoId) REFERENCES StatusPedido(idStatusPedido),
    FOREIGN KEY (statusPagamentoId) REFERENCES StatusPagamento(idStatusPagamento)
);
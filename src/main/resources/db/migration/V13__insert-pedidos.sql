-- PEDIDO PRONTO
INSERT INTO Pedido (idPedido, clienteId, statusPedidoId, statusPagamentoId, data) VALUES (1, 1, 3, 1, current_timestamp);
-- PEDIDO EM PREPARACAO
INSERT INTO Pedido (idPedido, clienteId, statusPedidoId, statusPagamentoId, data) VALUES (2, 1, 2, 1, current_timestamp);
-- PEDIDO RECEBIDO
INSERT INTO Pedido (idPedido, clienteId, statusPedidoId, statusPagamentoId, data) VALUES (3, 1, 1, 1, current_timestamp);

--INSERT INTO Item (produtoId,pedidoId,quantidade) VALUES (1, 1, 1);
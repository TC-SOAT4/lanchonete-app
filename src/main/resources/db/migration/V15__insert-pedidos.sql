-- PEDIDO PRONTO
INSERT INTO Pedido (idPedido, clienteId, statusPedidoId, data) VALUES (1, 1, 3, current_timestamp);
-- PEDIDO EM PREPARACAO
INSERT INTO Pedido (idPedido, clienteId, statusPedidoId, data) VALUES (2, 1, 2, current_timestamp);
-- PEDIDO RECEBIDO
INSERT INTO Pedido (idPedido, clienteId, statusPedidoId, data) VALUES (3, 1, 1, current_timestamp);

--INSERT INTO Item (produtoId,pedidoId,quantidade) VALUES (1, 1, 1);
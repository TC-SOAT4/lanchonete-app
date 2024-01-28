package com.fiap.lanchoneteapp.domain.pedido.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.lanchoneteapp.domain.cliente.entity.Cliente;
import com.fiap.lanchoneteapp.domain.produto.entity.Produto;
import com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity.PedidoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {

    private Integer idPedido;

    private List<Item> itens;

    private Cliente cliente;

    private StatusPedido statusPedido;

    private StatusPagamento statusPagamento;

    private BigDecimal valorTotal;

    private LocalDateTime data;

    public void setPedidoNosItens() {
        itens.forEach(item -> item.setPedido(this));
    }

    public Pedido(PedidoEntity pedidoEntity) {
        this.idPedido = pedidoEntity.getIdPedido();
        this.itens = pedidoEntity.getItens().stream().map(item -> {
            return Item.builder()
            .idItem(item.getIdItem())
            .produto(new Produto(item.getProduto()))
            .quantidade(item.getQuantidade())
            .build();
        }).toList();
        this.cliente = pedidoEntity.getCliente() != null ? new Cliente(pedidoEntity.getCliente()) : null;
        this.statusPedido = new StatusPedido( pedidoEntity.getStatusPedido());
        this.statusPagamento = pedidoEntity.getStatusPagamento() != null ? new StatusPagamento(pedidoEntity.getStatusPagamento()) : null;
        this.valorTotal = pedidoEntity.getValorTotal();
        this.data = pedidoEntity.getData();
    }

}

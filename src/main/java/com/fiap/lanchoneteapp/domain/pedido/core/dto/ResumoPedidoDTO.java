package com.fiap.lanchoneteapp.domain.pedido.core.dto;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.Normalized;

import com.fiap.lanchoneteapp.domain.pedido.core.model.Pedido;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Normalized
public class ResumoPedidoDTO {

    private Integer codigoPedido;
    private Object nomeCliente;
    private BigDecimal valorTotal;
    private List<ResumoItemDTO> itens;
    private String statusPedido;

    public ResumoPedidoDTO(Pedido pedido) {
        this.codigoPedido = pedido.getIdPedido();
        this.statusPedido = pedido.getStatusPedido().getDescricao();
        this.nomeCliente = pedido.getCliente() != null ? pedido.getCliente().getNome() : null;
        this.valorTotal = pedido.getValorTotal();
        this.itens = pedido.getItens().stream().map(item -> new ResumoItemDTO(item)).toList();
    }
    
}

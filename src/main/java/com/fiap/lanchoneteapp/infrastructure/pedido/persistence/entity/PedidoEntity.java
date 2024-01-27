package com.fiap.lanchoneteapp.infrastructure.pedido.persistence.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.lanchoneteapp.infrastructure.cliente.persistence.entity.ClienteEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemEntity> itens;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private ClienteEntity cliente;

    @ManyToOne
    @JoinColumn(name = "statusPedidoId")
    private StatusPedidoEntity statusPedido;

    private BigDecimal valorTotal;

    private LocalDateTime data;

    private String statusPagamento;

    public void setPedidoNosItens(){
        itens.forEach(item -> item.setPedido(this));
    }

}

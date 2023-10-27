package com.fiap.lanchoneteapp.domain.pedido.core.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.lanchoneteapp.domain.cliente.core.model.Cliente;

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
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<Item> itens;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "statusPedidoId")
    private StatusPedido statusPedido;

    private BigDecimal valorTotal;

    private LocalDateTime data;


    public void setPedidoNosItens(){
        itens.forEach(item -> item.setPedido(this));
    }

}

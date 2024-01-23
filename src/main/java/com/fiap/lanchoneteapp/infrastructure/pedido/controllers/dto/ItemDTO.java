package com.fiap.lanchoneteapp.infrastructure.pedido.controllers.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDTO {

    private Integer codigoProduto;
    private Integer quantidade;
    
}

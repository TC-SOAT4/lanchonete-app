package com.fiap.lanchoneteapp.domain.pedido.core.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemDTO {

    private Integer codigoProduto;
    private Integer quantidade;
    
}

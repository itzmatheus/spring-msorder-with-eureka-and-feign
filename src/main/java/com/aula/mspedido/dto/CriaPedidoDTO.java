package com.aula.mspedido.dto;

import java.time.LocalDate;

public record CriaPedidoDTO(
        Long idProduto,
        LocalDate dataPedido,
        String endereco
) {}

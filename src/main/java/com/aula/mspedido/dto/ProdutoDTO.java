package com.aula.mspedido.dto;

import java.math.BigDecimal;

public record ProdutoDTO(
        Long id,
        String nome,
        int quantidade,
        String descricao,
        BigDecimal preco
) {
    public boolean isPossuiQuantidadeDisponivelParaCriarPedido(int quantidadeDesejada) {
        return quantidade > quantidadeDesejada;
    }
}
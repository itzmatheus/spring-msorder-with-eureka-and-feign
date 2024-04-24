package com.aula.mspedido.service;

import com.aula.mspedido.dto.CriaPedidoDTO;
import com.aula.mspedido.entity.Pedido;
import com.aula.mspedido.external.MsProdutoClient;
import com.aula.mspedido.repository.PedidoRepository;
import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    private final PedidoRepository pedidoRepository;
    private final MsProdutoClient msProdutoClient;

    @Inject
    public ProdutoService(PedidoRepository pedidoRepository, MsProdutoClient msProdutoClient) {
        this.pedidoRepository = pedidoRepository;
        this.msProdutoClient = msProdutoClient;
    }

    public Pedido criaPedido(CriaPedidoDTO criaPedidoDTO) {

        validaProduto(criaPedidoDTO.idProduto());

        var pedido = new Pedido(criaPedidoDTO);
        pedido = pedidoRepository.save(pedido);

        notificaAlteracaoNaQuantidadeDoProduto(pedido.getIdProduto(), 1);
        return pedido;
    }

    private void validaProduto(Long idProduto) {
        var produto = msProdutoClient.obterProdutoPorId(idProduto);

        if (!produto.isPossuiQuantidadeDisponivelParaCriarPedido(1)) {
            throw new RuntimeException("Quantidade de produto inferior a solicitada");
        }
    }

    private void notificaAlteracaoNaQuantidadeDoProduto(Long idProduto, int quantidadeParaReduzir) {
        msProdutoClient.updateQuantidadeProduto(idProduto, quantidadeParaReduzir);
    }

}

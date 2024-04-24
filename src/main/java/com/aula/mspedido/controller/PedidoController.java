package com.aula.mspedido.controller;

import com.aula.mspedido.dto.CriaPedidoDTO;
import com.aula.mspedido.entity.Pedido;
import com.aula.mspedido.service.ProdutoService;
import jakarta.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/pedidos", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
public class PedidoController {

    private final ProdutoService produtoService;

    @Inject
    public PedidoController(ProdutoService produtoService) {
        super();
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> criaPedido(@RequestBody CriaPedidoDTO criaPedidoDTO) {
        return ResponseEntity.status(201).body(produtoService.criaPedido(criaPedidoDTO));
    }

}

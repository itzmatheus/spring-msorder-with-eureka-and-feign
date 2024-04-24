package com.aula.mspedido.external;

import com.aula.mspedido.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient("msproduto")
public interface MsProdutoClient {

    @GetMapping(value = "/produtos/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    ProdutoDTO obterProdutoPorId(@PathVariable Long id);

    @PutMapping(value = "/produtos/{id}/update-quantidade", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    String updateQuantidadeProduto(@PathVariable Long id, @RequestBody int quantidade);

}

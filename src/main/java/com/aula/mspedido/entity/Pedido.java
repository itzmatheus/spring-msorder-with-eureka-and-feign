package com.aula.mspedido.entity;

import com.aula.mspedido.dto.CriaPedidoDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate dataPedido;
    private String endereco;
    private Long idProduto;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    public Pedido() {
    }

    public Pedido(CriaPedidoDTO dto) {
        super();
        this.dataPedido = dto.dataPedido();
        this.idProduto = dto.idProduto();
        this.endereco = dto.endereco();
        this.statusPedido = StatusPedido.PENDENTE;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", dataPedido=" + dataPedido +
                ", endereco='" + endereco + '\'' +
                ", idProduto=" + idProduto +
                ", statusPedido=" + statusPedido +
                '}';
    }
}

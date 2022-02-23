package com.gerenciador.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Component
@Table(name = "frete")
public class Frete implements Serializable{

    private static final long serialVersionUID = -6888542263201514002L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "local_entrega", nullable = false)
    private String localDeEntrega;


    @Column(name = "quantidade", nullable = false)
    private Integer quantidade;

    @Column(name = "transportadora", nullable = true)
    private String transportadora;

    @Column(name = "produto", nullable = true)
    private String produto;

    public Frete() {

    }

    public Frete(Long id, String localDeEntrega, Integer quantidade, String transportadora, String produto) {
        this.id = id;
        this.localDeEntrega = localDeEntrega;
        this.quantidade = quantidade;
        this.transportadora = transportadora;
        this.produto = produto;
    }


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }


    public String getTransportadora() {
        return transportadora;
    }

    public void setTransportadora(String dataEntrega) {
        this.transportadora = transportadora;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocalDeEntrega() {
        return localDeEntrega;
    }

    public void setLocalDeEntrega(String localDeEntrega) {
        this.localDeEntrega = localDeEntrega;
    }

    @Override
    public String toString() {
        return "Viagem [id=" + id + ", localDeEntrega=" + localDeEntrega + ", quantidade =" + quantidade
                + ", transportadora=" + transportadora + ", produto=" + produto + "]";
    }



}

package com.gerenciador.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class FreteDTO implements Serializable{

    private static final long serialVersionUID = -8105241933692707649L;

    private Long id;

    private String localDeEntrega;

    private Integer quantidade;

    private String transportadora;

    private String produto;

    public FreteDTO(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull(message = "Local de Entrega é uma informação obrigatória")
    @Length(min = 3, max = 40, message = "Local de Destino deve estar entre 3 e 40 caracteres")
    public String getLocalDeEntrega(){
        return localDeEntrega;
    }

    public void setLocalDeEntrega(String localDeEntrega){
        this.localDeEntrega = localDeEntrega;

    }

    @NotNull(message = "quantidade é uma informação obrigatória")
    public Integer getQuantidade(){
        return quantidade;
    }

    public void setQuantidade (Integer quantidade){
        this.quantidade = quantidade;
    }

    public String getTranspordora(){ return transportadora; }

    public void setTransportadora(String transportadora){
        this.transportadora = transportadora;
    }

    public String getProduto(){
        return produto;
    }

    public void setProduto(String produto){
        this.produto = produto;
    }

    @Override
    public String toString(){
        return "FreteDTO [id="+ id + ", localDeEntrega = " + localDeEntrega + ", quantidade = " + quantidade +
                ", transportadora = " + transportadora + " produto = " + produto + "]";

    }

}

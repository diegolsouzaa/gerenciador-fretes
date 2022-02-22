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
public class Frete implements Serializable {

    private static final long serialVersionUID = -6888542263201514002L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "local_entrega", nullable = false)
    private String localDeEntrega;

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "data_coleta", nullable = false)
    private Date dataColeta;

    @JsonSerialize(using = DateSerializer.class)
    @Column(name = "data_entrega", nullable = true)
    private Date dataEntrega;

    @Column(name = "produto", nullable = true)
    private String produto;

    public Frete() {

    }

    public Frete(Long id, String localDeEntrega, Date dataColeta, Date dataEntrega, String produto) {
        this.id = id;
        this.localDeEntrega = localDeEntrega;
        this.dataColeta = dataColeta;
        this.dataEntrega = dataEntrega;
        this.produto = produto;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Date dataColeta) {
        this.dataColeta = dataColeta;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
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
        return "Viagem [id=" + id + ", localDeEntrega=" + localDeEntrega + ", dataColeta=" + dataColeta
                + ", dataEntrega=" + dataEntrega + ", produto=" + produto + "]";
    }



}

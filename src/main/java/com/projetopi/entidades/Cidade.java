package com.projetopi.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "cidade")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCidade;
    private String nomeCidade;
    private String uf;

    private String siglaIbge;

    public Cidade(int idCidade, String nomeCidade,String uf, String siglaIbge) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.uf = uf;
        this.siglaIbge = siglaIbge;
    }

    public Cidade() {

    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getSiglaIbge() {
        return siglaIbge;
    }

    public void setSiglaIbge(String siglaIbge) {
        this.siglaIbge = siglaIbge;
    }





    public int getId() {
        return idCidade;
    }

    public void setId(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(idCidade, cidade.idCidade) && Objects.equals(nomeCidade, cidade.nomeCidade)  && Objects.equals(uf, cidade.uf) && Objects.equals(siglaIbge, cidade.siglaIbge);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCidade, nomeCidade, uf, siglaIbge);
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "idCidade=" + idCidade +
                ", nomeCidade='" + nomeCidade + '\'' +
                ", uf='" + uf + '\'' +
                ", siglaIbge='" + siglaIbge + '\'' +
                '}';
    }
}

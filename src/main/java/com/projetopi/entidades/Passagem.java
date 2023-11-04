package com.projetopi.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "passagem")
public class Passagem {

    public Passagem() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passagem passagem = (Passagem) o;
        return poltrona == passagem.poltrona && Float.compare(valorPassagem, passagem.valorPassagem) == 0 && Objects.equals(idPassagem, passagem.idPassagem) && Objects.equals(veiculo, passagem.veiculo) && Objects.equals(dataSaida, passagem.dataSaida) && Objects.equals(horaSaida, passagem.horaSaida) && Objects.equals(cidadeOrigem, passagem.cidadeOrigem) && Objects.equals(cidadeDestino, passagem.cidadeDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassagem, veiculo, poltrona, dataSaida, horaSaida, cidadeOrigem, cidadeDestino, valorPassagem);
    }

    public Integer getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(Integer idPassagem) {
        this.idPassagem = idPassagem;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public int getPoltrona() {
        return poltrona;
    }

    public void setPoltrona(int poltrona) {
        this.poltrona = poltrona;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Cidade getCidadeOrigem() {
        return cidadeOrigem;
    }

    public void setCidadeOrigem(Cidade cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public Cidade getCidadeDestino() {
        return cidadeDestino;
    }

    public void setCidadeDestino(Cidade cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public float getValorPassagem() {
        return valorPassagem;
    }

    public void setValorPassagem(float valorPassagem) {
        this.valorPassagem = valorPassagem;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPassagem;

    @Override
    public String toString() {
        return "Passagem{" +
                "idPassagem=" + idPassagem +
                ", veiculo=" + veiculo +
                ", poltrona=" + poltrona +
                ", dataSaida=" + dataSaida +
                ", horaSaida='" + horaSaida + '\'' +
                ", cidadeOrigem=" + cidadeOrigem +
                ", cidadeDestino=" + cidadeDestino +
                ", valorPassagem=" + valorPassagem +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    private int poltrona;

    @Temporal(TemporalType.DATE)
    @Pattern(regexp = "dd-MM-yyyy", message = "Date format should be dd-MM-yyyy")
    private Date dataSaida;
    private String horaSaida;

    @ManyToOne
    @JoinColumn(name = "cidade_origem_id")
    private Cidade cidadeOrigem;

    @ManyToOne
    @JoinColumn(name = "cidade_destino_id")
    private Cidade cidadeDestino;

    private float valorPassagem;

    public void decrementPoltrona() {
        veiculo.decrementPoltrona();
    }

    public Passagem(Integer idPassagem, Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigem, Cidade cidadeDestino, float valorPassagem) {
        this.idPassagem = idPassagem;
        this.veiculo = veiculo;
        this.poltrona = poltrona;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.valorPassagem = valorPassagem;
    }
}
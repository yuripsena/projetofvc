package com.projetopi.entidades;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "passagem")
public class Passagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPassagem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    private int poltrona;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy") // Specify the date format
    private Date dataSaida;

    private String horaSaida;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cidadeOrigem_id")
    private Cidade cidadeOrigem;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cidadeDestino_id")
    private Cidade cidadeDestino;

    private float valorPassagem;

    @Column
    private boolean vendida;

    public Passagem(int idPassagem, Veiculo veiculo, int poltrona, Date dataSaida, String horaSaida, Cidade cidadeOrigem, Cidade cidadeDestino, float valorPassagem, boolean vendida) {
        this.idPassagem = idPassagem;
        this.veiculo = veiculo;
        this.poltrona = poltrona;
        this.dataSaida = dataSaida;
        this.horaSaida = horaSaida;
        this.cidadeOrigem = cidadeOrigem;
        this.cidadeDestino = cidadeDestino;
        this.valorPassagem = valorPassagem;
        this.vendida = vendida;
    }

    public Passagem() {

    }

    public int getIdPassagem() {
        return idPassagem;
    }

    public void setIdPassagem(int idPassagem) {
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

    public boolean isVendida() {
        return vendida;
    }

    public void setVendida(boolean vendida) {
        this.vendida = vendida;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passagem passagem = (Passagem) o;
        return idPassagem == passagem.idPassagem && poltrona == passagem.poltrona && vendida == passagem.vendida && Objects.equals(veiculo, passagem.veiculo) && Objects.equals(dataSaida, passagem.dataSaida) && Objects.equals(horaSaida, passagem.horaSaida) && Objects.equals(cidadeOrigem, passagem.cidadeOrigem) && Objects.equals(cidadeDestino, passagem.cidadeDestino) && Objects.equals(valorPassagem, passagem.valorPassagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassagem, veiculo, poltrona, dataSaida, horaSaida, cidadeOrigem, cidadeDestino, valorPassagem, vendida);
    }

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
                ", vendida=" + vendida +
                '}';
    }
}




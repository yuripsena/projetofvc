package com.projetopi.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String numero;
    private String motorista;
    private String placa;
    private String modelo;
    private String dataCompra;
    private int qtdPoltrnas;



    public Veiculo() {
    }

    public Veiculo(int id, String numero, String motorista, String placa, String modelo, String dataCompra,
                   int qtdPoltrnas) {
        this.id = id;
        this.numero = numero;
        this.motorista = motorista;
        this.placa = placa;
        this.modelo = modelo;
        this.dataCompra = dataCompra;
        this.qtdPoltrnas = qtdPoltrnas;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(String dataCompra) {
        this.dataCompra = dataCompra;
    }

    public int getQtdPoltrnas() {
        return qtdPoltrnas;
    }

    public void setQtdPoltrnas(int qtdPoltrnas) {
        this.qtdPoltrnas = qtdPoltrnas;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", motorista='" + motorista + '\'' +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", dataCompra=" + dataCompra +
                ", qtdPoltrnas=" + qtdPoltrnas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) && Objects.equals(numero, veiculo.numero) && Objects.equals(motorista, veiculo.motorista) && Objects.equals(placa, veiculo.placa) && Objects.equals(modelo, veiculo.modelo) && Objects.equals(dataCompra, veiculo.dataCompra) && Objects.equals(qtdPoltrnas, veiculo.qtdPoltrnas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, numero, motorista, placa, modelo, dataCompra, qtdPoltrnas);
    }
}
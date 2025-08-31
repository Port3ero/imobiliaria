package com.lucas.model;

import java.time.LocalDate;

public class Contrato {
    private int idContrato;
    private int idImovel;
    private int idCliente;
    private double valorMensal;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private boolean ativo;

    public Contrato() {}

    public Contrato(int idImovel, int idCliente, double valorMensal, LocalDate dataInicio, LocalDate dataFim) {
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.valorMensal = valorMensal;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.ativo = true;
    }

    public int getIdContrato() { return idContrato; }
    public void setIdContrato(int idContrato) { this.idContrato = idContrato; }

    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public double getValorMensal() { return valorMensal; }
    public void setValorMensal(double valorMensal) { this.valorMensal = valorMensal; }

    public LocalDate getDataInicio() { return dataInicio; }
    public void setDataInicio(LocalDate dataInicio) { this.dataInicio = dataInicio; }

    public LocalDate getDataFim() { return dataFim; }
    public void setDataFim(LocalDate dataFim) { this.dataFim = dataFim; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }

    @Override
    public String toString() {
        return "Contrato{" +
                "id=" + idContrato +
                ", Imóvel=" + idImovel +
                ", Cliente=" + idCliente +
                ", Valor=" + valorMensal +
                ", Início=" + dataInicio +
                ", Fim=" + dataFim +
                ", Ativo=" + ativo +
            '}';
    }
}

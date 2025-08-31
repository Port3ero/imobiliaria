package com.lucas.model;

public class Imovel {
    private int idImovel;
    private String tipo;
    private String endereco;
    private String cidade;
    private String estado;
    private String cep;
    private int quartos;
    private int banheiros;
    private double areaM2;
    private double valorAluguelSugerido;
    private String status; // DISPONIVEL, ALUGADO, INATIVO

    public Imovel() {}

    public Imovel(String tipo, String endereco, String cidade, String estado, String cep,
                  int quartos, int banheiros, double areaM2, double valorAluguelSugerido) {
        this.tipo = tipo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.areaM2 = areaM2;
        this.valorAluguelSugerido = valorAluguelSugerido;
        this.status = "DISPONIVEL";
    }

    public int getIdImovel() { return idImovel; }
    public void setIdImovel(int idImovel) { this.idImovel = idImovel; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public int getQuartos() { return quartos; }
    public void setQuartos(int quartos) { this.quartos = quartos; }

    public int getBanheiros() { return banheiros; }
    public void setBanheiros(int banheiros) { this.banheiros = banheiros; }

    public double getAreaM2() { return areaM2; }
    public void setAreaM2(double areaM2) { this.areaM2 = areaM2; }

    public double getValorAluguelSugerido() { return valorAluguelSugerido; }
    public void setValorAluguelSugerido(double valorAluguelSugerido) { this.valorAluguelSugerido = valorAluguelSugerido; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Imovel{" +
                "id=" + idImovel +
                ", tipo='" + tipo + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", quartos=" + quartos +
                ", banheiros=" + banheiros +
                ", área=" + areaM2 +
                ", valor=" + valorAluguelSugerido +
                ", status='" + status + '\'' +
            '}';
    }
}

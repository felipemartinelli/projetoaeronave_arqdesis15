package com.example.felipe.projetoaeronave_arqdesis15.model;

/**
 * Created by Felipe on 13/09/2015.
 */
import java.io.Serializable;

/**
 * Created by asbonato on 9/5/15.
 */
public class Voo implements Comparable<Voo>, Serializable{
    private String origem;
    private String destino;
    private String imagem;
    private String horario;
    private double preco;

    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Voo(String origem, String destino, String horario,String imagem,  double preco) {
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
        this.imagem = imagem;
        this.preco = preco;

    }

    public String getDestino() {

        return destino;
    }

    public String getHorario() {

        return horario;
    }

    public String getImagem() {

        return imagem;
    }

    public double getPreco() {
        return preco;
    }

    public String getOrigem() {
        return origem;
    }


    @Override
    public String toString() {
        return "com.example.felipe.projetoaeronave_arqdesis.model.Voo{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", horario='" + horario + '\'' +
                ", imagem='" + imagem + '\'' +
                ", preco='" + preco + '\'' +
                '}';
    }

    @Override
    public int compareTo(Voo voo) {
        if (origem.equals(voo.getOrigem())
                && destino.equals(voo.getDestino())){
            return 0;
        }
        return this.getOrigem().compareTo(voo.getOrigem());
    }
}

package br.com.luukzfilmes.modelos;

import br.com.luukzfilmes.calculos.Classificavel;

public class Episodio implements Classificavel {
    private int numero;
    private String nome;
    private Serie serie;

    public int getTotalDeVisualizacoes() {
        return totalDeVisualizacoes;
    }

    public void setTotalDeVisualizacoes(int totalDeVisualizacoes) {
        this.totalDeVisualizacoes = totalDeVisualizacoes;
    }

    private int totalDeVisualizacoes;

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        if (totalDeVisualizacoes > 100) {
            return 5;
        } else if (totalDeVisualizacoes > 50) {
            return 4;
        } else if (totalDeVisualizacoes > 20) {
            return 3;
        } else if (totalDeVisualizacoes > 10) {
            return 2;
        } else {
            return 1;
        }
    }
}

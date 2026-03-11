package br.com.luukzfilmes.calculos;

import br.com.luukzfilmes.modelos.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public int getTempoTotal() {
        return this.tempoTotal;
    }

    public void inclui(Titulo item) {
        this.tempoTotal += item.getDuracaoEmMinutos();
    }

}

package br.com.luukzfilmes.calculos;

public class FiltroRecomendacao {

    public String filtra(Classificavel classificavel) {
        if (classificavel.getClassificacao() >= 4) {
            return  "Excelente";
        } else if (classificavel.getClassificacao() >= 3) {
            return  "Recomendado";
        } else if (classificavel.getClassificacao() >= 2) {
            return "Regular";
        } else {
            return "Ruim";
        }
    }
}

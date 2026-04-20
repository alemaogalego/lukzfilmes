package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.calculos.CalculadoraDeTempo;
import br.com.luukzfilmes.calculos.FiltroRecomendacao;
import br.com.luukzfilmes.modelos.Episodio;
import br.com.luukzfilmes.modelos.Filme;
import br.com.luukzfilmes.modelos.Serie;

import java.util.ArrayList;


//
public class Principal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
    //  meuFilme.setNome("O Poderoso Chefão");
    //  meuFilme.setAnoDeLancamento(1972);
        meuFilme.setDuracaoEmMinutos(175);
        meuFilme.exibirFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5.0);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.obterMedia());

        Serie lost = new Serie("Lost", 2004);
//        lost.setNome("Lost");
//        lost.setAnoDeLancamento(2004);
        lost.setTemporadas(10);
        lost.exibirFichaTecnica();
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracao do filme: " + lost.getDuracaoEmMinutos());

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(lost);
        System.out.println("Tempo total: " + calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        System.out.println(filtro.filtra(meuFilme));

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalDeVisualizacoes(300);
        System.out.println(filtro.filtra(episodio));

        var filmeDoLucas = new Filme("Avatar", 2022);

        filmeDoLucas.setDuracaoEmMinutos(192);
        filmeDoLucas.avalia(9);

        var outroFilmeDoLucas = new Filme("A casa branca", 2020);
//        outroFilmeDoLucas.setAnoDeLancamento(2020);
        outroFilmeDoLucas.setDuracaoEmMinutos(120);
        outroFilmeDoLucas.avalia(6);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filmeDoLucas);
        listaDeFilmes.add(outroFilmeDoLucas);

        System.out.println("Lista de filmes: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}

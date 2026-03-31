package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.modelos.Filme;
import br.com.luukzfilmes.modelos.Serie;
import br.com.luukzfilmes.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainComLista {
    static void main() {
        Filme meuFilme = new Filme("O Poderoso Chefão", 1972);
        meuFilme.avalia(8);
        Serie lost = new Serie("Lost", 2004);
        var filmeDoLucas = new Filme("Avatar", 2022);
        filmeDoLucas.avalia(9);
        var outroFilmeDoLucas = new Filme("A casa branca", 2020);
        outroFilmeDoLucas.avalia(6);

        List<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(filmeDoLucas);
        lista.add(outroFilmeDoLucas);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNome());
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificaçao " + filme.getClassificacao());
            }

        }

        //Ordenando Lista..............

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Selena");
        buscaPorArtista.add("Bruce Lee");
        System.out.println(buscaPorArtista);

        Collections.sort(buscaPorArtista);
        System.out.println("Ordenando por ordem alfabética");
        System.out.println(buscaPorArtista);
        System.out.println("Lista de filmes ordenada por nome");
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Lista de filmes ordenada por ano de lançamento");
        System.out.println(lista);

    }
}

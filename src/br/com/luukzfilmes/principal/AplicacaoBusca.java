package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.excecao.ErroDeConversaoDeAnoException;
import br.com.luukzfilmes.modelos.Titulo;
import br.com.luukzfilmes.modelos.TituloOmdb;
import br.com.luukzfilmes.servicos.ClienteOmdb;
import br.com.luukzfilmes.servicos.PersistenciaTitulosJson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AplicacaoBusca {
    private final ClienteOmdb clienteOmdb;
    private final PersistenciaTitulosJson persistencia;

    public AplicacaoBusca(ClienteOmdb clienteOmdb, PersistenciaTitulosJson persistencia) {
        this.clienteOmdb = clienteOmdb;
        this.persistencia = persistencia;
    }

    public void executar() throws IOException, InterruptedException {
        List<Titulo> titulos = new ArrayList<>();

        try (Scanner leitura = new Scanner(System.in)) {
            String busca = "";

            while (!busca.equalsIgnoreCase("sair")) {
                System.out.println("Digite o nome do filme para buscar: ");
                busca = leitura.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }

                adicionarTitulo(busca, titulos);
                System.out.println(titulos);
                persistencia.salvar(titulos);
                System.out.println("programa finalizado");
            }
        }
    }

    private void adicionarTitulo(String busca, List<Titulo> titulos) throws IOException, InterruptedException {
        String json = clienteOmdb.buscarJsonPorTitulo(busca);
        System.out.println(json);

        try {
            TituloOmdb meuTituloOmdb = clienteOmdb.converterJsonParaTituloOmdb(json);
            System.out.println(meuTituloOmdb);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println("titulo convertido com sucesso");
            System.out.println(meuTitulo);

            titulos.add(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro ao converter os dados do filme: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ocorreu um erro ao criar o objeto Titulo: " + e.getMessage());
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }
    }
}


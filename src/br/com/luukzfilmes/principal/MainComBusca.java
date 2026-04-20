package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.excecao.ErroDeConversaoDeAnoException;
import br.com.luukzfilmes.modelos.Titulo;
import br.com.luukzfilmes.modelos.TituloOmdb;
import br.com.luukzfilmes.servicos.ClienteOmdb;
import br.com.luukzfilmes.servicos.FabricaGson;
import br.com.luukzfilmes.servicos.LeitorConfiguracao;
import br.com.luukzfilmes.servicos.PersistenciaTitulosJson;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";

        List<Titulo> titulos = new ArrayList<>();

        Gson gson = FabricaGson.criarPadrao();
        LeitorConfiguracao leitorConfiguracao = new LeitorConfiguracao();
        String apiKey = leitorConfiguracao.obterApiKeyOmdb("config.properties");
        ClienteOmdb clienteOmdb = new ClienteOmdb(apiKey, gson);
        PersistenciaTitulosJson persistencia = new PersistenciaTitulosJson("filmes.json", gson);

        try (Scanner leitura = new Scanner(System.in)) {
            while (!busca.equalsIgnoreCase("sair")) {
                System.out.println("Digite o nome do filme para buscar: ");
                busca = leitura.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }

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

                System.out.println(titulos);

                persistencia.salvar(titulos);

                System.out.println("programa finalizado");

            }
        }
    }

}


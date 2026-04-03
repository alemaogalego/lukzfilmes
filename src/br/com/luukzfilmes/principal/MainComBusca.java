package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.modelos.Titulo;
import br.com.luukzfilmes.modelos.TituloOmdb;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.FileInputStream;
import java.util.Properties;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainComBusca {
    static void main(String[] args) throws IOException, InterruptedException {

        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));
        String apiKey = props.getProperty("omdb.api.key");

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme para buscar: ");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "%20") + "&apikey=" + apiKey;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(com.google.gson.FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            //Titulo meuTitulo = gson.fromJson(json, Titulo.class);

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);


            try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println("titulo convertido com sucesso");
                System.out.println(meuTitulo);
            }catch (NumberFormatException e) {
                System.out.println("Ocorreu um erro ao converter os dados do filme: " + e.getMessage());
            }catch (IllegalArgumentException e){
                System.out.println("Ocorreu um erro ao criar o objeto Titulo: " + e.getMessage());
            }catch (Exception e) {
                System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            }




            System.out.println("programa finalizado");





        }
    }
}

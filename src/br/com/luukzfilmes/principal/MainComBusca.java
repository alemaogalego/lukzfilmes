package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.modelos.Titulo;
import com.google.gson.Gson;

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

            Gson gson = new Gson();
            Titulo meuTitulo = gson.fromJson(json, Titulo.class);
            System.out.println(meuTitulo);
        }
    }
}

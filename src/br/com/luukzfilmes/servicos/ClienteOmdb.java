package br.com.luukzfilmes.servicos;

import br.com.luukzfilmes.modelos.TituloOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;

public class ClienteOmdb {
    private final String apiKey;
    private final Gson gson;
    private final HttpClient httpClient;

    public ClienteOmdb(String apiKey, Gson gson) {
        this.apiKey = apiKey;
        this.gson = gson;
        this.httpClient = HttpClient.newHttpClient();
    }

    public String buscarJsonPorTitulo(String titulo) throws IOException, InterruptedException {
        String tituloCodificado = URLEncoder.encode(titulo, StandardCharsets.UTF_8);
        String endereco = "https://www.omdbapi.com/?t=" + tituloCodificado + "&apikey=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public TituloOmdb converterJsonParaTituloOmdb(String json) {
        return gson.fromJson(json, TituloOmdb.class);
    }
}


package br.com.luukzfilmes.principal;

import br.com.luukzfilmes.servicos.ClienteOmdb;
import br.com.luukzfilmes.servicos.FabricaGson;
import br.com.luukzfilmes.servicos.LeitorConfiguracao;
import br.com.luukzfilmes.servicos.PersistenciaTitulosJson;
import com.google.gson.Gson;

import java.io.IOException;

public class MainComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = FabricaGson.criarPadrao();
        String apiKey = new LeitorConfiguracao().obterApiKeyOmdb("config.properties");
        ClienteOmdb clienteOmdb = new ClienteOmdb(apiKey, gson);
        PersistenciaTitulosJson persistencia = new PersistenciaTitulosJson("filmes.json", gson);

        new AplicacaoBusca(clienteOmdb, persistencia).executar();
    }

}


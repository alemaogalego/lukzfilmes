package br.com.luukzfilmes.servicos;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LeitorConfiguracao {
    public String obterApiKeyOmdb(String caminhoArquivo) throws IOException {
        Properties props = new Properties();
        try (FileInputStream input = new FileInputStream(caminhoArquivo)) {
            props.load(input);
        }

        String apiKey = props.getProperty("omdb.api.key");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("A chave 'omdb.api.key' nao foi encontrada no arquivo de configuracao.");
        }

        return apiKey;
    }
}


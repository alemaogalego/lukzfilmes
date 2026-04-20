package br.com.luukzfilmes.servicos;

import br.com.luukzfilmes.modelos.Titulo;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PersistenciaTitulosJson {
    private final String caminhoArquivo;
    private final Gson gson;

    public PersistenciaTitulosJson(String caminhoArquivo, Gson gson) {
        this.caminhoArquivo = caminhoArquivo;
        this.gson = gson;
    }

    public void salvar(List<Titulo> titulos) throws IOException {
        try (FileWriter escrita = new FileWriter(caminhoArquivo)) {
            escrita.write(gson.toJson(titulos));
        }
    }
}


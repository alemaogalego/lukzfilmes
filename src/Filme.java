public class Filme {

    String nome;
    int anoDeLancamento;
    boolean incluirNoPlano;
    double somaDasAvaliacoes;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

    void exibirFichaTecnica() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totalDeAvaliacoes ++;
    }

    double obterMedia() {
        return somaDasAvaliacoes / totalDeAvaliacoes;
    }
}
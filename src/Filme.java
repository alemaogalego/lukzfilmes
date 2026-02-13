public class Filme {
    private String nome;
    private int duracaoEmMinutos;
    private String genero;
    boolean incluidoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;

    public Filme(String nome, int duracaoEmMinutos, String genero, boolean incluidoNoPlano, double avaliacao, int totalDeAvaliacoes) {
        this.nome = nome;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.genero = genero;
        this.incluidoNoPlano = incluidoNoPlano;
        this.avaliacao = avaliacao;
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public String getNome() {
        return nome;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

}

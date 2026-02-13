public class Main {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.nome = "O Poderoso Chefão";
        meuFilme.anoDeLancamento = 1972;
        meuFilme.duracaoEmMinutos = 175;


        meuFilme.exibirFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5.0);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.obterMedia());
    }
}

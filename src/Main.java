import br.com.luukzfilmes.modelos.Filme;

public class Main {
    public static void main(String[] args) {

        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1972);
        meuFilme.setDuracaoEmMinutos(175);



        meuFilme.exibirFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5.0);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.obterMedia());
    }
}

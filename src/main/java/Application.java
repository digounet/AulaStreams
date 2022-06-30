import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    static List<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        var joao = new Pessoa("João", 18);
        joao.addCarro(new Carro("AVC1234"));
        joao.addCarro(new Carro("AVC1235"));
        pessoas.add(joao);

        var maria = new Pessoa("Maria", 20);
        maria.addCarro(new Carro("HGHGH", "Branco"));
        pessoas.add(maria);

        pessoas.add(new Pessoa("Isabela", 19));
        pessoas.add(new Pessoa("Miguel", 38));
        pessoas.add(new Pessoa("Miguel", 17));


        //formasDeObterStream();
        //filtrandoStreams();
        transformandoStreams();

    }

    private static void transformandoStreams() {

         pessoas.stream()
                 .filter(p -> p.getIdade() >= 20 && p.getIdade() <= 40)
                 .filter(p -> p.getCarros().stream().anyMatch(c -> c.getCor().equals("Branco")))
                 .map(p -> p.getNome())
                 .forEach(p -> System.out.printf("%s possui um carro na cor Branca\n\n", p));

         pessoas.stream()
                 .filter(p -> p.getCarros().stream().count() > 0)
                 .map(p -> p.getCarros())
                 .forEach(System.out::println);

         pessoas.stream()
                 .flatMap(p -> p.getCarros().stream())
                 .forEach(System.out::println);




    }

    private static void filtrandoStreams() {
        pessoas.stream()
                .filter(p -> p.getIdade() == 18)
                .forEach(System.out::println);

/*        pessoas.stream()
                .forEach(System.out::println);*/

        var existe = pessoas.stream()
                .anyMatch(p -> p.getNome().equals("Isabela"));
        System.out.println(existe);


        pessoas.stream()
                .filter(p -> p.getIdade() >= 18)
                .forEach(System.out::println);


        var todosMaior = pessoas.stream()
                .allMatch(p -> p.getIdade() >= 18);
        if (todosMaior) {
            System.out.println("Todos de maior");
        } else {
            System.out.println("Nem todos são de maior");
        }

    }

    private static void formasDeObterStream() throws IOException {
        var st1 = pessoas.stream();
        var st2 = Stream.of("João", "Maria");

        String[] nomes = new String[] {"João", "Maria", "Gui"};
        var st3 = Arrays.stream(nomes);

        var st4 = Stream.empty();

        var st5 = new Random().ints(1, 6);

        //TO-DO: Ver se carrega o arquivo todo na memória
        File file = new File("dengue-dataset.csv");
        Scanner scanner = new Scanner(file);
        var s = scanner.next();
        System.out.println(s);

        var fileReader = new FileReader("dengue-dataset.csv", StandardCharsets.UTF_8);
        try(BufferedReader reader = new BufferedReader(fileReader)) {
            reader.lines().forEach(System.out::println);
        }
    }

    private static Optional<Pessoa> pesquisar(String nome)  {
        for (Pessoa p: pessoas) {
            if (p.getNome().equals(nome)) {
                return Optional.of(p);
            }
        }

        return Optional.empty();
    }
}

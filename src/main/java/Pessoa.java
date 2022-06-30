import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String nome;
    private int idade;

    private List<Carro> carros;

    public Pessoa(String nome, Integer idade) {
        this.nome = nome;
        this.idade = idade;
        this.carros = new ArrayList<>();
    }

    public void addCarro(Carro carro)  {
        this.carros.add(carro);
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}

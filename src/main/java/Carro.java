public class Carro {
    private String placa;
    private String cor;

    public Carro(String placa) {
        this.placa = placa;
        this.cor = "Não informada";
    }

    public Carro(String placa, String cor) {
        this.placa = placa;
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", cor='" + cor + '\'' +
                '}';
    }
}

// Classe auxiliar Pessoa
public class Pessoa {
    String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    // NOVO MÉTODO - Adicionado para o 'show()' funcionar
    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Pessoa{nome='" + this.nome + "'}";
    }
}

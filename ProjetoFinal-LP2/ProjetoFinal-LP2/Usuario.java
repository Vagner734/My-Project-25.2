import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario implements Serializable, TrilhaObserver {
    private static final long serialVersionUID = 1L;

    String nome;
    String senha;
    String endereco;
    LocalDate dataNascimento;
    ArrayList<Trilha> trilhasFavoritas;

    public Usuario(String nome, String senha, String endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.senha = senha;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
        this.trilhasFavoritas = new ArrayList<>();
    }

    public void adicionarFavorita(Trilha trilha) {
        if (!trilhasFavoritas.contains(trilha)) {
            trilhasFavoritas.add(trilha);
            trilha.registrarObservador(this);
            System.out.println("Trilha favoritada!");
        }
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println(">>> NOTIFICACAO PARA " + this.nome + ": " + mensagem);
    }
}
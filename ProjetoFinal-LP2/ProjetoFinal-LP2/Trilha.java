import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trilha implements Serializable {
    private static final long serialVersionUID = 1L;

    String nome;
    ArrayList<Ponto> pontos;
    LocalDate dataCadastro;
    LocalDate ultimaAtualizacao;

    // Transient impede erro ao salvar no arquivo
    private transient List<TrilhaObserver> observadores;

    public Trilha(String nome) {
        this.nome = nome;
        this.pontos = new ArrayList<>();
        this.dataCadastro = LocalDate.now();
        this.ultimaAtualizacao = LocalDate.now();
        this.observadores = new ArrayList<>();
    }

    private void verificarObservadores() {
        if (this.observadores == null) {
            this.observadores = new ArrayList<>();
        }
    }

    public void registrarObservador(TrilhaObserver observador) {
        verificarObservadores();
        observadores.add(observador);
    }

    public void notificarObservadores() {
        verificarObservadores();
        for (TrilhaObserver obs : observadores) {
            obs.atualizar("A trilha '" + this.nome + "' foi atualizada!");
        }
    }

    public void adicionarPonto(Ponto ponto) {
        pontos.add(ponto);
        ultimaAtualizacao = LocalDate.now();
        notificarObservadores(); 
    }

    @Override
    public String toString() {
        return "Trilha: " + nome + " | Pontos: " + pontos.size();
    }
}
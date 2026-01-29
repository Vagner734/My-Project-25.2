import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioDados {
    private static RepositorioDados instance;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Trilha> trilhas;
    private IPersistencia persistencia;

    private RepositorioDados() {
        this.usuarios = new ArrayList<>();
        this.trilhas = new ArrayList<>();
    }

    public static RepositorioDados getInstance() {
        if (instance == null) {
            instance = new RepositorioDados();
        }
        return instance;
    }

    public void inicializar(IPersistencia persistenciaEscolhida) {
        this.persistencia = persistenciaEscolhida;
        this.usuarios = persistencia.carregarUsuarios();
        this.trilhas = persistencia.carregarTrilhas();

        if (this.usuarios.isEmpty()) {
            System.out.println("Base vazia. Criando usuário inicial...");
            // Vagner cadastrado conforme sua solicitação
            this.usuarios.add(new Usuario("Vagner", "123", "Rua - Afonso Costa", LocalDate.of(2026, 1, 14))); 
            salvarTudo();
        }
    }

    // NOVO MÉTODO: Permite adicionar usuários e salvar no disco
    public void adicionarUsuario(Usuario u) {
        this.usuarios.add(u);
        salvarTudo();
    }

    public void salvarTudo() {
        if (persistencia != null) {
            persistencia.salvarUsuarios(usuarios);
            persistencia.salvarTrilhas(trilhas);
        }
    }

    public ArrayList<Usuario> getUsuarios() { return usuarios; }
    public ArrayList<Trilha> getTrilhas() { return trilhas; }
    
    public void adicionarTrilha(Trilha t) {
        this.trilhas.add(t);
        salvarTudo();
    }
}

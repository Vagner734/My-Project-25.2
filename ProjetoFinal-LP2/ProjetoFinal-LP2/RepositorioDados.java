import java.time.LocalDate;
import java.util.ArrayList;

public class RepositorioDados {

    // PADRÃO SINGLETON: Instância única
    private static RepositorioDados instance;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Trilha> trilhas;
    
    // Interface para persistência (Adapter)
    private IPersistencia persistencia;

    private RepositorioDados() {
        // Inicialmente vazio, os dados serão carregados no 'init'
        this.usuarios = new ArrayList<>();
        this.trilhas = new ArrayList<>();
    }

    public static RepositorioDados getInstance() {
        if (instance == null) {
            instance = new RepositorioDados();
        }
        return instance;
    }

    // Configura qual armazenamento usar (requisito da escolha de armazenamento)
    public void inicializar(IPersistencia persistenciaEscolhida) {
        this.persistencia = persistenciaEscolhida;
        this.usuarios = persistencia.carregarUsuarios();
        this.trilhas = persistencia.carregarTrilhas();

        // Cria ADMIN se não existir ninguém
        if (this.usuarios.isEmpty()) {
            System.out.println("Base vazia. Criando usuário admin...");
            this.usuarios.add(new Usuario("admin", "123", "Rua A", LocalDate.of(1990, 1, 1)));
            salvarTudo();
        }
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

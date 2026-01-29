import java.util.ArrayList;

// Interface comum para permitir a troca de estratégias de salvamento
public interface IPersistencia {
    void salvarUsuarios(ArrayList<Usuario> usuarios);
    ArrayList<Usuario> carregarUsuarios();
    
    void salvarTrilhas(ArrayList<Trilha> trilhas);
    ArrayList<Trilha> carregarTrilhas();
}
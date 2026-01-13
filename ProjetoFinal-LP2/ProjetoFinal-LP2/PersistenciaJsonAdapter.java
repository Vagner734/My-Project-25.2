import java.util.ArrayList;
import java.util.List;

public class PersistenciaJsonAdapter implements IPersistencia {
    private ServicoJson servicoJson;

    public PersistenciaJsonAdapter() {
        this.servicoJson = new ServicoJson();
    }

    @Override
    public void salvarUsuarios(ArrayList<Usuario> usuarios) {
        List<Object> lista = new ArrayList<>(usuarios);
        servicoJson.gravarArquivoJson("usuarios.json", lista);
    }

    @Override
    public ArrayList<Usuario> carregarUsuarios() {
        List<Object> objetos = servicoJson.lerArquivoJson("usuarios.json");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        if (objetos != null) {
            for (Object obj : objetos) {
                if (obj instanceof Usuario) usuarios.add((Usuario) obj);
            }
        }
        return usuarios;
    }

    @Override
    public void salvarTrilhas(ArrayList<Trilha> trilhas) {
        List<Object> lista = new ArrayList<>(trilhas);
        servicoJson.gravarArquivoJson("trilhas.json", lista);
    }

    @Override
    public ArrayList<Trilha> carregarTrilhas() {
        List<Object> objetos = servicoJson.lerArquivoJson("trilhas.json");
        ArrayList<Trilha> trilhas = new ArrayList<>();
        if (objetos != null) {
            for (Object obj : objetos) {
                if (obj instanceof Trilha) trilhas.add((Trilha) obj);
            }
        }
        return trilhas;
    }
}
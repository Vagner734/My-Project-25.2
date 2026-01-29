import java.io.*;
import java.util.ArrayList;

public class ArquivoUtil implements IPersistencia {

    private static final String ARQ_USUARIOS = "usuarios.dat";
    private static final String ARQ_TRILHAS = "trilhas.dat";

    @Override
    public void salvarUsuarios(ArrayList<Usuario> usuarios) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQ_USUARIOS))) {
            oos.writeObject(usuarios);
        } catch (IOException e) { System.out.println("Erro ao salvar usuários."); }
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Usuario> carregarUsuarios() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQ_USUARIOS))) {
            return (ArrayList<Usuario>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }

    @Override
    public void salvarTrilhas(ArrayList<Trilha> trilhas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQ_TRILHAS))) {
            oos.writeObject(trilhas);
        } catch (IOException e) { System.out.println("Erro ao salvar trilhas."); }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ArrayList<Trilha> carregarTrilhas() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQ_TRILHAS))) {
            return (ArrayList<Trilha>) ois.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
import java.util.ArrayList;
import java.util.List;

public class ListaFesta {

    private static ListaFesta instance;

    // A lista que os métodos da imagem usam
    private List<Pessoa> lista;

    // Construtor privado
    private ListaFesta() {
        lista = new ArrayList<Pessoa>();
        lista.add(new Pessoa("Pedro"));
        lista.add(new Pessoa("José"));
        lista.add(new Pessoa("João"));
        lista.add(new Pessoa("Maria"));
        lista.add(new Pessoa("João"));
    }

    // Método getInstance (Singleton)
    public static ListaFesta getInstance() {
        if (instance == null) {
            instance = new ListaFesta();
        }
        return instance;
    }

    /**
     * Método para mostrar todos os convidados na lista.
     */
    public void show() {
        System.out.println("LISTA DE FESTA");
        // Corrigido de 'lista' para 'lista'
        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getNome());
        }
    }

    /**
     * Método para adicionar uma nova pessoa à lista.
     * @param nome O nome da pessoa a adicionar.
     */
    public void addPessoa(String nome){
    }

    // Método auxiliar (pode manter se quiser)
    public List<Pessoa> getLista() {
        return lista;
    }
}
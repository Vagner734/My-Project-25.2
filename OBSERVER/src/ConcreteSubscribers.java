import java.util.ArrayList;
import java.util.List;
public class ConcreteSubscribers {

    private List<Subscriber> subscribers = new ArrayList<>();
    private String mainState;

    public String getMainState() {
        return mainState;
    }

    public void subscribe(Subscriber s) {
        System.out.println("-> Assinante adicionado: " + s.getClass().getSimpleName());
        this.subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        System.out.println("-> Assinante removido: " + s.getClass().getSimpleName());
        this.subscribers.remove(s);
    }

    public void notifySubscribers() {
        System.out.println("\n--- Notificando Assinantes (" + subscribers.size() + " ativos) ---");
        for (Subscriber s : new ArrayList<>(subscribers)) {
            s.update(this);
        }
        System.out.println("--- Notificação Concluída ---\n");
    }

    public void mainBusinessLogic(String newState) {
        System.out.println("\n[Publisher] Executando lógica de negócio...");
        this.mainState = newState;
        System.out.println("[Publisher] Estado alterado para: " + this.mainState);
        notifySubscribers();
    }
}

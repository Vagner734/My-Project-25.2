//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        private String name;

    public Man(String name) {
            this.name = name;
        }

        @Override
        public void update(Publisher publisher) {
            String publisherState = publisher.getMainState();

            System.out.println(">>> [" + name + "] Recebeu uma notificação.");
            System.out.println(">>> [" + name + "] Analisando o estado: " + publisherState);

            if (publisherState.equals("Alerta de Risco")) {
                System.out.println(">>> [" + name + "] REAÇÃO: Acionando procedimento de segurança! 🚨");
            } else if (publisherState.equals("Tudo OK")) {
                System.out.println(">>> [" + name + "] REAÇÃO: Registrando o status normal. 😊");
            }
        }

    }
}
public class Client {

    public class Client {
        public static void main(String[] args) {

            Publisher central = new Publisher();

            Man john = new Man("John (Superintendente)");
            Subscriber systemLog = new ConcreteSubscriber("Sistema de Logs");
            Subscriber uiMonitor = new ConcreteSubscriber("Monitor de UI");

            central.subscribe(john);
            central.subscribe(systemLog);
            central.subscribe(uiMonitor);

            System.out.println("\n=============================================");
            System.out.println("               SIMULAÇÃO 1: ALERTA");
            System.out.println("=============================================");
            central.mainBusinessLogic("Alerta de Risco");

            System.out.println("\n=============================================");
            System.out.println("            SIMULAÇÃO 2: TUDO OK");
            System.out.println("=============================================");
            central.mainBusinessLogic("Tudo OK");

            central.unsubscribe(uiMonitor);

            System.out.println("\n=============================================");
            System.out.println("        SIMULAÇÃO 3: APENAS 2 ATIVOS");
            System.out.println("=============================================");
            central.mainBusinessLogic("Manutenção Agendada");
        }
    }
}

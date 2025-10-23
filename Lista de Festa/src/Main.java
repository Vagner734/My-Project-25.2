public class Main {

    public static void main(String[] args) {

        // 1. Pega a instância única da lista
        ListaFesta lista = ListaFesta.getInstance();

        // 2. Mostra a lista original (SEM Wagner)
        System.out.println("--- Lista Original ---");
        lista.show();

        // 3. AQUI VOCÊ CHAMA O MÉTODO PARA ADICIONAR
        System.out.println("\n...Adicionando Wagner...");
        lista.addPessoa("Wagner"); // <--- ESTA LINHA EXECUTA O CÓDIGO

        // 4. Mostra a lista atualizada (COM Wagner)
        System.out.println("\n--- Lista Atualizada ---");
        lista.show(); // <--- AGORA O WAGNER APARECE
    }
}
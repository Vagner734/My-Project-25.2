import java.util.Scanner;

public class Main {

    static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Singleton
        RepositorioDados repo = RepositorioDados.getInstance();

        // --- MENU DE CONFIGURACAO (Requisito: Escolha de armazenamento) ---
        System.out.println("=== CONFIGURACAO INICIAL ===");
        System.out.println("Escolha o tipo de armazenamento:");
        System.out.println("1 - Arquivo Binario (.dat) - Padrao");
        System.out.println("2 - Arquivo JSON (Adapter) - Simulacao");
        System.out.print("Opcao: ");
        
        int tipoArq = 0;
        if (sc.hasNextInt()) {
            tipoArq = sc.nextInt();
            sc.nextLine(); // Limpar buffer
        } else {
            sc.nextLine();
        }

        if (tipoArq == 2) {
            System.out.println("-> Usando Adaptador JSON.");
            repo.inicializar(new PersistenciaJsonAdapter());
        } else {
            System.out.println("-> Usando Arquivo Binario.");
            repo.inicializar(new ArquivoUtil());
        }

        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Login (Use: admin / 123)");
            System.out.println("2 - Criar/Atualizar trilha (Teste Observer)");
            System.out.println("3 - Listar trilhas");
            System.out.println("4 - Adicionar trilha aos favoritos");
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                opcao = 99; // Opção inválida
                sc.nextLine();
            }

            switch (opcao) {
                case 1 -> login(sc, repo);
                case 2 -> criarOuAtualizarTrilha(sc, repo);
                case 3 -> listarTrilhas(repo);
                case 4 -> adicionarFavorito(sc, repo);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        repo.salvarTudo();
        sc.close();
    }

    static void login(Scanner sc, RepositorioDados repo) {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        for (Usuario u : repo.getUsuarios()) {
            if (u.nome.equals(nome) && u.senha.equals(senha)) {
                usuarioLogado = u;
                System.out.println("Login realizado! Bem-vindo " + u.nome);
                return;
            }
        }
        System.out.println("Usuario ou senha invalidos.");
    }

    static void criarOuAtualizarTrilha(Scanner sc, RepositorioDados repo) {
        if (usuarioLogado == null) {
            System.out.println("Faca login primeiro.");
            return;
        }

        System.out.println("1 - Criar NOVA trilha");
        System.out.println("2 - Adicionar ponto em trilha existente (Gera Notificacao Observer)");
        System.out.print("Opcao: ");
        int op = sc.nextInt();
        sc.nextLine();

        if (op == 1) {
            System.out.print("Nome da trilha: ");
            Trilha trilha = new Trilha(sc.nextLine());
            repo.adicionarTrilha(trilha);
            System.out.println("Trilha criada com sucesso!");
            
        } else if (op == 2) {
            listarTrilhas(repo);
            System.out.print("Digite o ID da trilha para atualizar: ");
            int idx = sc.nextInt();
            
            if (idx >= 0 && idx < repo.getTrilhas().size()) {
                Trilha t = repo.getTrilhas().get(idx);
                System.out.println("Adicionando novo ponto (Check-in)...");
                // ISSO DISPARA O OBSERVER:
                t.adicionarPonto(new Ponto(10, 20)); 
                repo.salvarTudo();
            } else {
                System.out.println("Trilha invalida.");
            }
        }
    }

    static void listarTrilhas(RepositorioDados repo) {
        if (repo.getTrilhas().isEmpty()) {
            System.out.println("Nenhuma trilha cadastrada.");
            return;
        }
        for (int i = 0; i < repo.getTrilhas().size(); i++) {
            System.out.println("ID " + i + " - " + repo.getTrilhas().get(i));
        }
    }

    static void adicionarFavorito(Scanner sc, RepositorioDados repo) {
        if (usuarioLogado == null) {
             System.out.println("Faca login primeiro.");
             return;
        }
        listarTrilhas(repo);
        System.out.print("Escolha o ID da trilha para favoritar: ");
        int idx = sc.nextInt();

        if (idx >= 0 && idx < repo.getTrilhas().size()) {
            usuarioLogado.adicionarFavorita(repo.getTrilhas().get(idx));
            repo.salvarTudo();
        } else {
            System.out.println("ID invalido.");
        }
    }
}
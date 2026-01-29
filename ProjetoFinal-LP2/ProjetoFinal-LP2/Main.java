import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static Usuario usuarioLogado = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Singleton
        RepositorioDados repo = RepositorioDados.getInstance();

        // --- MENU DE CONFIGURACAO (Mantido conforme sua imagem) ---
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
            System.out.println("1 - Login");
            System.out.println("2 - Criar/Atualizar trilha (Teste Observer)");
            System.out.println("3 - Listar trilhas");
            System.out.println("4 - Adicionar trilha aos favoritos");
            System.out.println("5 - Cadastrar novo usuario"); // Nova opção adicionada
            System.out.println("0 - Sair");
            System.out.print("Opcao: ");
            
            if (sc.hasNextInt()) {
                opcao = sc.nextInt();
                sc.nextLine();
            } else {
                opcao = 99; 
                sc.nextLine();
            }

            switch (opcao) {
                case 1 -> login(sc, repo);
                case 2 -> criarOuAtualizarTrilha(sc, repo);
                case 3 -> listarTrilhas(repo);
                case 4 -> adicionarFavorito(sc, repo);
                case 5 -> cadastrarUsuario(sc, repo);
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opcao invalida.");
            }

        } while (opcao != 0);

        repo.salvarTudo();
        sc.close();
    }

    // Método para cadastrar novos usuários em tempo de execução
    static void cadastrarUsuario(Scanner sc, RepositorioDados repo) {
        System.out.println("\n--- NOVO CADASTRO ---");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Endereco: ");
        String endereco = sc.nextLine();
        System.out.print("Data de Nascimento (AAAA-MM-DD): ");
        String dataStr = sc.nextLine();
        
        try {
            LocalDate data = LocalDate.parse(dataStr);
            Usuario novo = new Usuario(nome, senha, endereco, data);
            repo.adicionarUsuario(novo);
            System.out.println("Usuario " + nome + " cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: Formato de data invalido. Use AAAA-MM-DD.");
        }
    }

    // Os demais métodos (login, criarOuAtualizarTrilha, etc) 
    // permanecem com a lógica original de funcionamento.
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

    static void listarTrilhas(RepositorioDados repo) {
        if (repo.getTrilhas().isEmpty()) {
            System.out.println("Nenhuma trilha cadastrada.");
            return;
        }
        for (int i = 0; i < repo.getTrilhas().size(); i++) {
            System.out.println("ID " + i + " - " + repo.getTrilhas().get(i));
        }
    }

    static void criarOuAtualizarTrilha(Scanner sc, RepositorioDados repo) {
        if (usuarioLogado == null) {
            System.out.println("Faca login primeiro.");
            return;
        }
        System.out.println("1 - Criar NOVA trilha");
        System.out.println("2 - Adicionar ponto (Gera Notificacao)");
        int op = sc.nextInt(); sc.nextLine();

        if (op == 1) {
            System.out.print("Nome da trilha: ");
            repo.adicionarTrilha(new Trilha(sc.nextLine()));
        } else if (op == 2) {
            listarTrilhas(repo);
            System.out.print("ID da trilha: ");
            int idx = sc.nextInt();
            if (idx >= 0 && idx < repo.getTrilhas().size()) {
                repo.getTrilhas().get(idx).adicionarPonto(new Ponto(10, 20));
            }
        }
    }

    static void adicionarFavorito(Scanner sc, RepositorioDados repo) {
        if (usuarioLogado == null) {
             System.out.println("Faca login primeiro.");
             return;
        }
        listarTrilhas(repo);
        System.out.print("ID da trilha para favoritar: ");
        int idx = sc.nextInt();
        if (idx >= 0 && idx < repo.getTrilhas().size()) {
            usuarioLogado.adicionarFavorita(repo.getTrilhas().get(idx));
            repo.salvarTudo();
        }
    }
}
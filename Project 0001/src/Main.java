public class Main {
    public static void main(String[] args) {
        // Exemplo 1: Criando um objeto PessoaFisica
        PessoaFisica pessoa1 = new PessoaFisica();
        pessoa1.setNome("Luis Carlos Feira de Santana");
        pessoa1.setIdade(35); // Idade de exemplo
        pessoa1.setEndereco("Rua da Programação, 101");
        pessoa1.setCpf("067.259.6-29"); // CPF do exemplo (formatei)

        // Mostrando os dados
        pessoa1.showData();

        System.out.println("\n==================================\n");

        // Exemplo 2: Criando um objeto PessoaJuridica
        PessoaJuridica empresa = new PessoaJuridica();
        empresa.setNome("Tech Solutions Ltda.");
        empresa.setIdade(10); // Anos de fundação
        empresa.setEndereco("Avenida do Código, 2048");
        empresa.setCnpj("12.345.678/0001-99");

        // Mostrando os dados
        empresa.showData();
    }
}
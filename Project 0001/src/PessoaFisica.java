public class PessoaFisica extends Pessoa {
    // Atributo específico
    private String cpf;

    // Métodos Getters e Setters para o CPF
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Implementação do método showData
    @Override
    public void showData() {
        System.out.println("--- Dados da Pessoa Física ---");
        System.out.println("Nome: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("CPF: " + getCpf());
    }
}

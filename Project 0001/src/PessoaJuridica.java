public class PessoaJuridica extends Pessoa {
    // Atributo específico
    private String cnpj;

    // Métodos Getters e Setters para o CNPJ
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    // Implementação do método showData
    @Override
    public void showData() {
        System.out.println("--- Dados da Pessoa Jurídica ---");
        System.out.println("Nome/Razão Social: " + getNome());
        System.out.println("Idade/Anos de Fundação: " + getIdade());
        System.out.println("Endereço: " + getEndereco());
        System.out.println("CNPJ: " + getCnpj());
    }
}
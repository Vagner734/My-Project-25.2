import java.util.ArrayList;
import java.util.List;

// Simulação de uma biblioteca de terceiros
public class ServicoJson {
    
    public void gravarArquivoJson(String nomeArquivo, List<Object> dados) {
        System.out.println("[JSON SYSTEM] Gravando " + dados.size() + " registros em " + nomeArquivo);
    }

    public List<Object> lerArquivoJson(String nomeArquivo) {
        System.out.println("[JSON SYSTEM] Lendo dados de " + nomeArquivo);
        return new ArrayList<>(); // Retorna vazio na simulação
    }
}
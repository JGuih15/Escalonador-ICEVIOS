import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Criar o escalonador
        scheduler s = new scheduler();

        try {
            // Caminho do arquivo com os processos
            // Você pode alterar para um caminho absoluto se preferir
            String caminho = "processos.txt";

            // 1. Carregar os processos no escalonador
            s.leitura(caminho);

            // 2. Executar os processos organizados por prioridade
            s.executarFila();

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

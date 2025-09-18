import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String nomeArquivo = "processos.txt"; // ou args[0] se quiser passar argumento
        scheduler scheduler = new scheduler();

        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (linha.isEmpty() || linha.startsWith("#")) continue; // ignora comentários e linhas vazias

                String[] dados = linha.split("\\s+"); // separa por espaços
                if (dados.length < 4) {
                    System.err.println("Linha ignorada por formato incorreto: " + linha);
                    continue;
                }

                try {
                    String nome = dados[0];
                    int prioridade = Integer.parseInt(dados[1]);
                    int id = Integer.parseInt(dados[2]);
                    int ciclos = Integer.parseInt(dados[3]);
                    String recursos = (dados.length > 4) ? dados[4] : null;

                    Processos processo = new Processos(nome, prioridade, id, ciclos, recursos);
                    scheduler.adicionar_Processo(processo);
                } catch (NumberFormatException e) {
                    System.err.println("Erro de número na linha: " + linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo '" + nomeArquivo + "' não encontrado.");
            return;
        }

        System.out.println("Processos carregados com sucesso. Iniciando simulação...");
        scheduler.execucaoCompleta();
    }
}

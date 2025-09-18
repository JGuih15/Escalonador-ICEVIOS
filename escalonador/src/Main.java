import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Erro: forneça o nome do arquivo de dados como argumento.");
            return;
        }

        String nomeArquivo = args[0];
        scheduler scheduler = new scheduler();

        try (Scanner scanner = new Scanner(new File(nomeArquivo))) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine().trim();
                if (linha.isEmpty()) continue;

                String[] dados = linha.split(",");
                if (dados.length < 4) {
                    System.err.println("Linha ignorada por formato incorreto: " + linha);
                    continue;
                }

                try {
                    int id = Integer.parseInt(dados[0].trim());
                    String nome = dados[1].trim();
                    int prioridade = Integer.parseInt(dados[2].trim());
                    int ciclos = Integer.parseInt(dados[3].trim());
                    String recursos = (dados.length > 4) ? dados[4].trim() : null;

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

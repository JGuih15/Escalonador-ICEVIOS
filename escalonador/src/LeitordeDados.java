import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeitordeDados{

    public static Processos[] leituraTXT(String arquivo) throws IOException {
        System.out.println("Iniciando a leitura do arquivo...");

        //verificacao inicial do arquivo.
        int numeroDeProcessosValidos = 0;
        BufferedReader leitorContador = null;

        try {
            leitorContador = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = leitorContador.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty() || linha.startsWith("#")) {
                    continue; // Ignora linhas vazias ou de comentário
                }

                // Verifica se a linha tem o formato mínimo esperado
                String[] dados = linha.split("\\s+");
                if (dados.length >= 4) {
                    try {
                        Integer.parseInt(dados[1]); // Tenta converter prioridade
                        Integer.parseInt(dados[2]); // Tenta converter ID
                        Integer.parseInt(dados[3]); // Tenta converter ciclos
                        numeroDeProcessosValidos++;
                    } catch (NumberFormatException e) {

                        System.err.println("Aviso: Formato numérico incorreto na linha, será ignorada.");
                    }
                } else {
                    System.err.println("Aviso: Formato de linha incorreto, será ignorada.");
                }
            }
        } finally {
            if (leitorContador != null) {
                leitorContador.close();
            }
        }

        if (numeroDeProcessosValidos == 0) {
            System.out.println("Nenhum processo válido encontrado no arquivo.");
            return new Processos[0];
        }

        System.out.println("Total de processos válidos a serem lidos: " + numeroDeProcessosValidos);
        Processos[] processos = new Processos[numeroDeProcessosValidos];

       //leitura do processo que cria e organiza os objetos dos processos
        BufferedReader leitorProcessos = null;
        int indice = 0;

        try {
            leitorProcessos = new BufferedReader(new FileReader(arquivo));
            String linha;
            int contadorLinhas = 0;

            while ((linha = leitorProcessos.readLine()) != null) {
                contadorLinhas++;
                linha = linha.trim();

                if (linha.isEmpty() || linha.startsWith("#")) {
                    continue; // Ignora linhas vazias ou de comentário
                }

                String[] dados = linha.split("\\s+");

                // Valida novamente a linha antes de processá-la
                if (dados.length < 4) {
                    System.err.println("Erro: Formato incorreto na linha " + contadorLinhas + ". Linha ignorada.");
                    continue;
                }

                try {
                    String nome = dados[0];
                    int prioridade = Integer.parseInt(dados[1]);
                    int id = Integer.parseInt(dados[2]);
                    int ciclos = Integer.parseInt(dados[3]);

                   //A String recurso e opcional(quando houver algo diferente de null)
                    String recurso = null;
                    if (dados.length >= 5) {
                        recurso = dados[4];
                        if (recurso.equalsIgnoreCase("null")) {
                            recurso = null;
                        }
                    }

                    // Validações de dados
                    if (prioridade < 1 || prioridade > 3) {
                        prioridade = 2; // Padrão
                        System.out.println("Aviso: Prioridade inválida na linha " + contadorLinhas + ". Definida como 2.");
                    }
                    if (ciclos <= 0) {
                        ciclos = 1; // Padrão
                        System.out.println("Aviso: Ciclos inválidos na linha " + contadorLinhas + ". Definidos como 1.");
                    }

                    // Cria o novo objeto Processo e o adiciona ao array
                    processos[indice] = new Processos(nome, prioridade, id, ciclos, recurso);
                    indice++;
                    System.out.println("Processo lido com sucesso: " + nome + " (linha " + contadorLinhas + ")");

                } catch (NumberFormatException e) {
                    System.err.println("Erro: Conversão de número falhou na linha " + contadorLinhas + ". Linha ignorada.");
                }
            }
        } finally {
            if (leitorProcessos != null) {
                leitorProcessos.close();
            }
        }

        System.out.println("\nLeitura do arquivo finalizada. Total de processos criados: " + indice);
        return processos;
    }
}

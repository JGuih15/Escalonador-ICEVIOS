import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LeitordeDados {
        public static Processos[] leituraTXT (String arquivo) throws IOException {
            BufferedReader lendo = new BufferedReader(new FileReader(arquivo));//a inclusao do processo nao funciona.
            String linha;
            int size = 0;

            System.out.println("iniciando a leitura do arquivo");

            //primeira leitura do arquivo,conta e organiza os processos validos existentes.
            while ((linha = lendo.readLine()) != null) {
                linha = linha.trim();//elimina os espacos vazios na linha que esta sendo lida.

                if (linha.isEmpty()) {//ignora linahs vazias e passa para a proxima.
                    size++;
                }
            }
            lendo.close();

            if (size == 0) {
                System.out.println("nao existe texto aqui");
                return new Processos[0];
            }

            //funcao para ler e organizar as variaveis do objeto processo.
            Processos[] processo = new Processos[size];
            lendo = new BufferedReader(new FileReader(arquivo));
            int indice = 0;

            while ((linha = lendo.readLine()) != null) {
                linha = linha.trim();
                if (linha.isEmpty() || linha.startsWith("#")) {//ignora linhas com comentarios ou que estao vazinas.
                    continue;
                }

                try {
                    String[] dados = linha.split("\\s+");//separa as linhas de dados validos em espacos.

                    if (dados.length >= 4) {
                        String nome = dados[0];
                        int prioridade = Integer.parseInt(dados[1]);
                        int id = Integer.parseInt(dados[2]);
                        int ciclos = Integer.parseInt(dados[3]);

                        //recursos "opcionais".
                        String recurso = null;
                        if (dados.length > 4) {
                            recurso = dados[4];

                            if (recurso.equals("null")) {
                                recurso = null;
                            }


                        }
                        //validacao e sepracao por prioridade.
                        if (prioridade < 1 || prioridade > 3) {
                            System.out.println("prioridade analisada invalida,inseando na fila de medias");
                            prioridade = 2;//depois mudar para estado bloqueado
                        }
                        if (ciclos <= 0) {
                            System.out.println("processo nao possui ciclos,iniciando com 1");
                            ciclos = 1;
                        }

                        processo[indice] = new Processos(nome, prioridade, id, ciclos, recurso);//os dados devem ser inseridos aqui,mas ainda nao sei como.
                        indice++;

                    } else {
                        System.out.println("erro na leitura dos dados");
                        System.out.println("sao eseprados 4 parameros: nome,id,ciclos,prioridade");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Erro:leitura invalida na linha: " + size);
                    System.out.println("linha ignorada");
                }

            }
            lendo.close();
            System.out.println("processo lidos: " + size);
            return processo;

        }




 }


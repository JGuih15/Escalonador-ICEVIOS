import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class LeitordeDados{
    public static Processos[] leituraTXT(Processos processo) throws  IOException{
        BufferedReader lendo= new BufferedReader(new FileReader());//a inclusao do processo nao funciona.
        String linha;//variavel linha determina a linha em que o leitor esta.
        int size=0;//determina o tamanho da linha de arquivo lida.

        System.out.println("iniciando a leitura do arquivo");

        //primeira leitura do arquivo
        while((linha= lendo.readLine())!=null) {
            linha = linha.trim();//elimina os espacos vazios na linha que esta sendo lida.
        }


    }


}

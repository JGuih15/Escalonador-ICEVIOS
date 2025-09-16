import java.io.IOException;
import java.sql.SQLOutput;
public class scheduler{
    private Prioridade prioridade;

    public scheduler(){
        this.prioridade=new Prioridade();
    }

    //analisar os dados e separar por meio da casse prioridade.
    public void leitura(String arquivo) throws IOException{
        Processos[] processos= LeitordeDados.leituraTXT(arquivo);
        for(Processos p: processos){
           if(p==null) continue;

           switch (p.getPrioridade()){
               case 1:
                   prioridade.getAltaPrioridade().adicionarNO(p);
                   break;
               case 2:
                   prioridade.getMediaPrioridade().adicionarNO(p);
                   break;
               case 3:
                   prioridade.getBaixaPrioridade().adicionarNO(p);
                   break;
               default:
                   System.out.println("processo"+p.getNome()+"invalido");

           }

        }

    }

    public void executar(){
        System.out.println("alta prioridade: "+prioridade.getAltaPrioridade());
        System.out.println("meida prioridade: "+prioridade.getMediaPrioridade());
        System.out.println("Baixa prioridade: "+prioridade.getBaixaPrioridade());
    }

    private  void executarFila(String nomeFila, gerenciamento fila) {
        System.out.println("---- " + nomeFila + " ----");
        while (!fila.isEmpty()) {
            Processos p = fila.removerUltima();
            System.out.println("Executando: " + p.getNome() +
                    " | Prioridade: " + p.getPrioridade() +
                    " | Ciclos: " + p.getCiclos());

        }
    }



}
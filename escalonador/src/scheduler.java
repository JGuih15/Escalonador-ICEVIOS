import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class scheduler{
    private scheduler prioridade;
    public Listacircular altaPrioridade = new Listacircular();
    public Listacircular mediaPrioridade = new Listacircular();
    public Listacircular baixaPrioridade = new Listacircular();
    public Listacircular todos = new Listacircular();

    public scheduler(){
        this.prioridade=new scheduler();
    }

    public scheduler getAltaPrioridade() {return prioridade;}
    public void setAltaPrioridade(scheduler prioridade) {this.prioridade = prioridade;}

    public scheduler getMediaPrioridade() {return prioridade;}
    public void setMediaPrioridade(scheduler prioridade) {this.prioridade = prioridade;}

    public scheduler getBaixaPrioridade() {return prioridade;}
    public void setBaixaPrioridade(scheduler prioridade) {this.prioridade = prioridade;}

    //analisar os dados e separar por meio da casse prioridade.
    public void leitura(String arquivo) throws IOException{
        Processos[] processos= LeitordeDados.leituraTXT(arquivo);
        for(Processos p: processos){
           if(p==null) continue;
          else if (p==1){
              altaPrioridade.addProcessoLC(p);
              todos.addProcessoLC(p);
           }
           else if (p==2){
               mediaPrioridade.addProcessoLC(p);
               todos.addProcessoLC();
           }
           else if (p==3){
               baixaPrioridade.addProcessoLC(p);
               todos.addProcessoLC(p);
           }else return;
        }
    }
    public void executarCiclo(){
        while(true){
            int contadorAlta = 0;
            if(contadorAlta<5){
                System.out.println("processo de prioridade 1:");
                System.out.println(altaPrioridade.toString());
                altaPrioridade.proximoElemento();
                contadorAlta++;
            }else {
                System.out.println("processo de prioridade 2:");
                System.out.println(mediaPrioridade.toString());
                System.out.println("processo de prioridade 3:");
                System.out.println(baixaPrioridade.toString());

                contadorAlta = 0;
            }
            mediaPrioridade.proximoElemento();
            baixaPrioridade.proximoElemento();
        }
    }


    public void executar(){
        System.out.println("alta prioridade: "+prioridade.getAltaPrioridade());
        System.out.println("meida prioridade: "+prioridade.getMediaPrioridade());
        System.out.println("Baixa prioridade: "+prioridade.getBaixaPrioridade());
    }

    private void executarFila(String nomeFila, gerenciamento fila) {
        System.out.println("---- " + nomeFila + " ----");
        while (!fila.isEmpty()) {
            Processos p = fila.removerUltima();
            System.out.println("Executando: " + p.getNome() +
                    " | Prioridade: " + p.getPrioridade() +
                    " | Ciclos: " + p.getCiclos());

        }
    }

    public boolean pendentes(){
       return   !altaPrioridade.isEmpty();
                !mediaPrioridade.isEmpty();
                !baixaPrioridade.isEmpty();
                !bloqueados.isEmpty();

    }





}
public class prioridade {
    private gerenciamento altaPrioridade  = new gerenciamento();
    private gerenciamento mediaPrioridade = new gerenciamento();
    private gerenciamento baixaPrioridade = new gerenciamento();
    private gerenciamento bloqueados = new gerenciamento();

    private int contadorCiclos = 0;

    //add cada processo em sua respectiva prioridade:
    public void inserirNaLista(Processos proc){
        if(proc.getPrioridade() == 1){
            altaPrioridade.adUltimo();
        }else if(proc.getPrioridade() == 2){
            mediaPrioridade.adUltimo();
        }else {
            baixaPrioridade.adUltimo();
        }
    }
    //contador de ciclos da CPU, para que não seja executado apenas processos de prioridade 1
    public void executarCiclo(){
        Processos desbloqueados = bloqueados.removerPrimeiro();
        if(desbloqueados != null){
            System.out.println("Processo" + desbloqueados.getNome()+ "desbloqueado");

        }



    }

}

public class prioridade {
    private gerenciamento altaPrioridade = new gerenciamento();
    private gerenciamento mediaPrioridade = new gerenciamento();
    private gerenciamento baixaPrioridade = new gerenciamento();
    private gerenciamento bloqueados = new gerenciamento();
    private int contadorCiclos = 0;

    public void inserirNaLista(Processos proc){
        if(proc.getPrioridade() == 1){
            altaPrioridade.adUltimo(proc);
        } else if(proc.getPrioridade() == 2){
            mediaPrioridade.adUltimo(proc);
        } else {
            baixaPrioridade.adUltimo(proc);
        }
    }

    public void executarCiclo(){
        Processos desbloqueados = bloqueados.removerPrimeiro();
        if(desbloqueados != null){
            System.out.println("Processo " + desbloqueados.getNome() + " desbloqueado");
            inserirNaLista(desbloqueados);
        }

        Processos p = altaPrioridade.removerPrimeiro();
        if(p == null) p = mediaPrioridade.removerPrimeiro();
        if(p == null) p = baixaPrioridade.removerPrimeiro();

        if(p != null){
            System.out.println("Executando processo " + p.getNome());
            contadorCiclos++;
        } else {
            System.out.println("Nenhum processo para executar neste ciclo.");
        }
    }
}

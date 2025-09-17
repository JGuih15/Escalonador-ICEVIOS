import java.io.IOException;
public class scheduler{
    private ListaDupla AltaPrioridade;
    private ListaDupla MediaPrioridade;
    private ListaDupla BaixaPrioridade;
    private ListaDupla Bloqqueados;
    private Listacircular Execucao;
    private  int ciclosAlta;
    private int ciclos;

    public scheduler(){
        this.AltaPrioridade= new ListaDupla();
        this.MediaPrioridade= new ListaDupla();
        this.BaixaPrioridade=new ListaDupla();
        this.Execucao= new Listacircular();
        this.ciclosAlta=0;
        this.ciclos=0;
    }

    //metodo para adicionar processos na fila de prioridade.

    public void adicionar(Processos processo){
        switch (processo.getPrioridade()){
            case 1:
                AltaPrioridade.addInicioDC(processo);
                break;
            case 2:
                MediaPrioridade.addInicioDC(processo);
                break;
            case 3:
                BaixaPrioridade.addInicioDC(processo);
                break;
        }
    }

    //metodo para mover para lista de execucao.
    public void Executar(){
        if(ciclosAlta>=5){//previnir inanicao de processos
            if(MediaPrioridade.getTamanho()>0){//verifica a quantidade de processos adicionados na lista media.
               Processos processo= MediaPrioridade.removerInicioDC().processos;
               Execucao.addProcessoLC(processo);

            } else if (BaixaPrioridade.getTamanho()>0) {
                Processos processo=BaixaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);
            }
            ciclosAlta=0;

        }else{
            if (AltaPrioridade.getTamanho() > 0) {
                Processos processo = AltaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);
                ciclosAlta++;

            } else if (MediaPrioridade.getTamanho() > 0) {
                Processos processo = MediaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);

            } else if (BaixaPrioridade.getTamanho() > 0) {
                Processos processo = BaixaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);
            }
        }

    }

    public void Escalonar(){
        if(Execucao==null){
            System.out.println("sem processos para executar aqui");
            return;
        }
        Processos processo= Execucao


    }

}
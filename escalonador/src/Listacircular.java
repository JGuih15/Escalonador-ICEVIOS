public class Listacircular {
    private Node atual;
    private int tamanho;
    private Node cabeca;

    public ListaCircular(Processos processo) {
        this.atual=null;
        this.tamanho=0;
    }
    public void addProcessoLC(Processos processo) {
        Node novoNo = new Node();
        novoNo.criacao(processo);//chamando a função de criação,onde as informações do processo sao adicionadas.
        if (atual == null) {
            atual = novoNo;
            novoNo.next = atual;
        }
        else {
            Node temp = cabeca;
            while (temp.next != cabeca) {
                temp = temp.next;
            }
            temp.next = novoNo;
            novoNo.next = cabeca;
        }
        tamanho++;
    }
    public void removerProcessoLC(Processos processo) {

        if  (atual == null){
            return null;
        }//faltou os parenteses.

        else if (atual.next == cabeca) {
            processo = atual.processo;//como assim?
            return null;
        }else{
            Node temp = cabeca;
            while (temp.next != atual) {
                temp = temp.next;
            }
            temp.next = cabeca.next;
            cabeca = temp.next;
        }
        tamanho--;
    }
    public void removerUltimoProcessoLC(Processos processo) {
        if  (atual == null) return null;
        else  if (atual.next == cabeca) {}

    }

}

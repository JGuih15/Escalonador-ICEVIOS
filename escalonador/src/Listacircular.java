public class Listacircular {
    private Node atual;
    private int tamanho;
    private Node cabeca;

    public ListaCircular(Processos processo) {
        this.atual=null;
        this.tamanho=0;
    }
    public void addProcessoLC(Processos processo) {
        Node novoNo = new Node(processo);
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
        if  (atual == null) return null;

        else if (atual.next == cabeca) {
            processo = atual.processo;
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

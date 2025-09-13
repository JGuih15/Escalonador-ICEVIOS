public class Listacircular {
    private Node atual;
    private int tamanho;
    private Node cabeca;

    public Listacircular(Processos processo) {
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
        if  (atual == null) return;

        else if (atual.next == cabeca) {
            atual.next = atual.next.next;
            return;
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
        if  (atual == null) return;
        else  if (atual.next == cabeca) {}

    }

}

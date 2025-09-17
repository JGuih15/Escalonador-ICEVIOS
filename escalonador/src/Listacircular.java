public class Listacircular {
    private Node atual;
    private int tamanho;
    private Node cabeca;
    Processos processo;

    public Listacircular() {
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
    public Object removerProcessoLC(Processos processos) {
        if  (atual == null) return null;

        else if (atual.next == cabeca) {
            processos = atual.processos;
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
        return null;
    }
}

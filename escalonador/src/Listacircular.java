public class Listacircular {
    private Node atual;
    private int tamanho;
    private Node cabeca;
    Processos processo;

    public int getTamanho() {return tamanho;}

    public Listacircular() {
        this.atual=cabeca ;
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

    public String proximoElemento() {
        if (atual == null) return null;
        String valor = atual.processos.toString();
        atual = atual.next;
        return valor;
    }
    public void mostrar() {
        Node atual = cabeca;
        if (atual == null) {
            System.out.println("Não tem processos!");
            return;
        }

        System.out.print("Processos: ");
        while (atual != null && atual.next != cabeca) {
            System.out.print(atual.processos.toString() + " ");
            atual = atual.next;
        }
        System.out.println();
    }
}

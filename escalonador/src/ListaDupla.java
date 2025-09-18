public class ListaDupla {
    private Node head;
    private Node tail;
    private int tamanho;

    public ListaDupla() {
        head = null;
        tail = null;
        tamanho = 0;
    }

    public int getTamanho() { return tamanho; }
    public boolean estaVazia() { return head == null; }

    public void adicionarNoFinal(Processos p) {
        Node novo = new Node(p);
        if (estaVazia()) {
            head = tail = novo;
        } else {
            tail.next = novo;
            novo.anterior = tail;
            tail = novo;
        }
        tamanho++;
    }

    public Processos removerDoInicio() {
        if (estaVazia()) return null;
        Node removido = head;
        head = head.next;
        if (head != null) head.anterior = null;
        else tail = null;
        removido.next = null;
        removido.anterior = null;
        tamanho--;
        return removido.processo;
    }

    public void imprimirLista() {
        Node atual = head;
        if (atual == null) System.out.println("Lista vazia");
        while (atual != null) {
            System.out.println(atual.processo);
            atual = atual.next;
        }
    }
}

public class Listacircular {
    private Node cabeca;
    private Node atual;
    private int tamanho;

    public Listacircular() {
        cabeca = null;
        atual = null;
        tamanho = 0;
    }

    public boolean estaVazia() { return cabeca == null; }
    public int getTamanho() { return tamanho; }

    public void adicionarFim(Processos p) {
        Node novo = new Node(p);
        if (estaVazia()) {
            cabeca = novo;
            novo.next = cabeca;
            atual = cabeca;
        } else {
            Node temp = cabeca;
            while (temp.next != cabeca) temp = temp.next;
            temp.next = novo;
            novo.next = cabeca;
        }
        tamanho++;
    }

    public Processos getAtual() { return (atual != null) ? atual.processo : null; }

    public void removerAtual() {
        if (estaVazia()) return;

        if (atual == cabeca && atual.next == cabeca) {
            cabeca = atual = null;
        } else {
            Node prev = cabeca;
            while (prev.next != atual) prev = prev.next;
            prev.next = atual.next;
            if (atual == cabeca) cabeca = atual.next;
            atual = atual.next;
        }
        tamanho--;
    }

    public void avancar() { if (atual != null) atual = atual.next; }

    public void imprimirLista() {
        if (estaVazia()) {
            System.out.println("Lista circular vazia");
            return;
        }
        Node temp = cabeca;
        do {
            System.out.println(temp.processo);
            temp = temp.next;
        } while (temp != cabeca);
    }
}

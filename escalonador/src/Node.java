public class Node {
    Processos processo;
    Node next;
    Node anterior;

    public Node(Processos p) {
        this.processo = p;
        this.next = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        return processo.toString();
    }
}

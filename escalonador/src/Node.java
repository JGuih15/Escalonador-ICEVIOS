public class Node {
    Processos processos;
    Node next;
    Node anterior;

    public Node(Processos p) {
        super();
        this.processos = p;
        this.next = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        return processos.toString();
    }


}

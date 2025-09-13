public class Node {//No simples(apenas next
    Processos processo;
    Node next;

    public Node(Processos processo) {
        this.processo = processo;
        this.next = null;
    }

    public Node() {
    }

    @Override
    public String toString() {
        return next.toString();

    }
}

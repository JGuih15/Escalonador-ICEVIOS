public class Node {
    Node next;
    Node anterior;
    Processos processos;

    public void criacao(Processos processos) {
        this.processos = processos;
        this.next=null;
        this.anterior=null;
    }
}

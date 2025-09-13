public class ListaDupla {
    private Node  head;
    private Node tail;
    private int tamanho;

    public ListaDupla() {
        head = null;
        tail = null;
        tamanho = 0;
    }
    //DC = duplamente encadeada
    public void addFinalDC(int valor) {
        NoDuplo novoDC = new NoDuplo();
        if (head == null) { // Lista vazia
            head = novoDC;
            tail = novoDC;
        } else {
            tail.next = novoDC;
            novoDC.anterior = (NoDuplo) tail;
            tail = novoDC;
        }
        tamanho++;
    }

    //remove o No sem perder a referencia
    public NoDuplo removerInicioDC(NoDuplo atual) {
        if (head == null) return null;
        NoDuplo removido = (NoDuplo) head;

        head = head.next;
        if (head != null) {
            ((NoDuplo) head).anterior = null;
        } else {
            tail = null; // Lista ficou vazia
        }

        removido.next = null;
        removido.anterior = null;
        return removido;
    }
    public Processos removerERetornarRemovido (Processos processos) {
        NoDuplo atual = (NoDuplo) head;

        while (atual != null && !atual.processos.equals(processos)) {
            atual = atual.proximo;
        }

        if (atual == null) {
            return null; // Não encontrado
        }
        
        Processos dadoRemovido = atual.processos;
        
        removerInicioDC(atual);
        return dadoRemovido;
    }


}

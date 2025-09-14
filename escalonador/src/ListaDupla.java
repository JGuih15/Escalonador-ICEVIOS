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
    public void addFinalDC(Processos p) {
        NoDuplo novoDC = new NoDuplo(p);
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

    public Processos removerParaOutraLista(int id, gerenciamento listaDestino) {
        NoDuplo atual = (NoDuplo) head;
        while (atual != null) {
            if (atual.processos.getId() == id) {
                // Ajusta ponteiros para não quebrar a lista
                if (atual.anterior != null)
                    atual.anterior.proximo = atual.proximo;
                else
                    head = atual.proximo; // removendo o primeiro

                if (atual.proximo != null)
                    atual.proximo.anterior = atual.anterior;
                else
                    tail = atual.anterior; // removendo o último
                tamanho--;
                // Adiciona o processo removido na lista de destino(gerenciamento)
                listaDestino.adUltimo(atual.processos);

                return atual.processos; // retorna o processo removido
            }
            atual = atual.proximo;
        }
        return null; // não encontrado
    }
    public void listarDC() {
        NoDuplo atual = (NoDuplo) head;
        while (atual != null) {
            System.out.println(atual.processos);
            atual = atual.proximo;
            System.out.println("TAMANHO: " + tamanho);
        }
    }


}

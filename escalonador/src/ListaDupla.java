public class ListaDupla {
    private Node  head;
    private Node tail;
    private int tamanho;

    public int getTamanho() {return tamanho;}


    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }
    public ListaDupla() {
        head = null;
        tail = null;
        tamanho = 0;
    }
    //DC = duplamente encadeada
    //adicionar no inicio da lista
    public void addInicioDC(Processos p){
        Node atual=head;
        Node novoNo= new Node(p);
        if(isEmpty()){
            head=novoNo;
        }
        else{
           novoNo.next=head;
           head.anterior=novoNo;
           novoNo.anterior=null;

        }
    }
    //adiciona no final da lista.
    public void addFinalDC(Processos p) {
        Node novoDC = new Node(p);
        if (head == null) { // Lista vazia
            head = novoDC;
            tail = novoDC;
        } else {
            tail.next = novoDC;
            novoDC.anterior = (Node) tail;
            tail = novoDC;
        }
        tamanho++;
    }

    //remove o No sem perder a referencia
    public Node removerInicioDC() {
        Node atual;
        if (head == null) return null;
        Node removido = (Node) head;

        head = head.next;
        if (head != null) {
            ((Node) head).anterior = null;
        } else {
            tail = null; // Lista ficou vazia
        }

        removido.next = null;
        removido.anterior = null;
        tamanho--;
        return removido;
    }

    //remover ultimo.
    public void removerUltimoDC(Node atual){
        atual=head;
        if(isEmpty()){
            System.out.println("esssa lista esta vazia");
        }else{
            while(head.next.next!=null){
                head=atual.next;
            }
            atual.next=null;
            tamanho--;
        }
    }
    public void listarDC() {
        Node atual = (Node) head;
        while (atual != null) {
            System.out.println(atual.processos);
            atual = atual.next;
            System.out.println("TAMANHO: " + tamanho);
        }
    }




}

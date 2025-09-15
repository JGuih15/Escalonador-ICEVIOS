public class gerenciamento {
    private Processos processo;
    private Node cabeca = null;
    private Node tail = null;
    int size = 0;

    public boolean isEmpty(){
        return cabeca == null;
    }

    public void adicionarNO(Processos processos){
        Node novo = new Node();
        novo.criacao(processos);
        if(isEmpty()){
            cabeca = novo;
        } else {
            novo.next = cabeca;
            cabeca = novo;
        }
        size++;
    }

    public void adUltimo(Processos processos){
        Node novo = new Node();
        novo.criacao(processos);
        if(isEmpty()){
            cabeca = novo;
        } else {
            Node atual = cabeca;
            while(atual.next != null){
                atual = atual.next;
            }
            atual.next = novo;
        }
        size++;
    }

    public Processos removerPrimeiro(){
        if(isEmpty()){
            System.out.println("A lista está vazia");
            return null;
        } else {
            Processos removido = cabeca.processo;
            cabeca = cabeca.next;
            size--;
            return removido;
        }
    }

    public Processos removerUltima(){
        if(isEmpty()){
            System.out.println("A lista está vazia");
            return null;
        } else if(cabeca.next == null){
            Processos removido = cabeca.processo;
            cabeca = null;
            size--;
            return removido;
        } else {
            Node atual = cabeca;
            while(atual.next.next != null){
                atual = atual.next;
            }
            Processos removido = atual.next.processo;
            atual.next = null;
            size--;
            return removido;
        }
    }
}

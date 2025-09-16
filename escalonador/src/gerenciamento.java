public class gerenciamento {
    private Processos processo;
    private NoDuplo cabeca = null;
    int size = 0;

    public boolean isEmpty(){
        return cabeca == null;
    }

    public void adicionarNO(Processos processos){
        NoDuplo novo = new NoDuplo(processos);
        if(isEmpty()){
            cabeca = novo;
        } else {
            novo.next = cabeca;
            cabeca = novo;
        }
        size++;
    }

    public void adUltimo(Processos processos){
        NoDuplo novo = new NoDuplo(processos);
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
           cabeca= (NoDuplo) cabeca.next;
           size--;
            return null;
        }
    }

    public Processos removerUltima(){
        if(isEmpty()){
            System.out.println("A lista está vazia");
            return null;
        } else if(cabeca.next == null){
            cabeca=null;
            return null;
        } else {
            Node atual = cabeca;
            while(atual.next.next != null){
                atual = atual.next;
            }
            atual.next = null;
            size--;
            return null;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoDuplo atual = cabeca;

        while (atual != null) {
            sb.append(atual.getProcesso().toString()).append("\n");
            atual = atual.getProximo();
        }

        return sb.toString();
    }
}

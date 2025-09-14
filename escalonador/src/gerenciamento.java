public class gerenciamento {
    private Processos processo;
    private Node cabeca=null ;
    private Node tail=null;
    int size= 0;

    //funcao de verificacao de preenchimento das listas.
    public boolean isEmpty(){
        if(this.cabeca==null){
            return true;
        }
        return false;
    }

    //funcao para adicionar um no na primeira posicao.
    public  void  adicionarNO(){
        Node novo= new Node();
        Node atual=cabeca;
        novo.criacao(processo);
        if(isEmpty()){
            cabeca=novo;

        }
        else{
           novo.next=atual;
           cabeca=novo;
           size ++;//aumenta o tamnho da lista apos adicao.

        }
    }

    //funcao para adicionar na ultima posicao da lista
    public void adUltimo(Processos processos){
        Node novo= new Node();
        novo.criacao(processo);
        if(isEmpty()){
            novo=cabeca;
        }else{
            Node atual=cabeca;
            while(atual.next!=null){
                atual.next=cabeca;
            }
            atual.next=novo;
            size++;

        }

    }

    //funcao para remover um NO na primeira posicao.
    public boolean remover(){
        if(isEmpty()){
            System.out.println("a lista esta vazia");
            return false ;
        }else{
        cabeca=cabeca.next;
        size--;
        return true;
        }
    }

    //funcao para remover um no na ultima posicao.
    public Processos removerUltima(){
        if (isEmpty()) {

        }
        Node atual=cabeca;
        while(atual.next.next!=null){
            atual=atual.next;
        }
        atual.next=null;
        size--;

        return null;
    }

    //funcao para remover o primeiro Node
    public Processos removerPrimeiro(){
        if (isEmpty()) {
            System.out.println("a lista esta vazia");
            return null;
        }else{
            cabeca=cabeca.next;
            size--;//reduz o tamanho da lista apos a remocao do elemento.
            return null;
        }

    }





}

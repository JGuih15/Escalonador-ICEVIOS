public class gerenciamento {
    private Processos processo;
    private Node cabeca=null ;
    private Node tail=null;

    //funcao de verificacao de preenchimento das listas.
    public boolean isEmpty(){
        if(this.cabeca==null){
            return true;
        }
        return false;
    }

    //funcao para adicionar um no na primeira posicao.
    public void adicionarNO(){
        Node novo= new Node();
        Node atual=cabeca;
        novo.criacao(processo);
        if(isEmpty()){
            cabeca=novo;

        }
        else{
           novo.next=atual;
           cabeca=novo;

        }
    }

    //funcao para adicionar na ultima posicao da lista
    public void adUltimo(){
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

        }

    }

    //funcao para remover um NO na primeira posicao.
    public boolean remover(){
        if(isEmpty()){
            System.out.println("a lista esta vazia");
            return false ;
        }

        cabeca=cabeca.next;
        return true;
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

        return null;
    }
    //funcao para remover o primeiro Node
    public Processos removerPrimeiro(){
        if (isEmpty()) {
            System.out.println("a lista esta vazia");
            return null;
        }else{
            cabeca=cabeca.next;
            return null;
        }
    }





}

public class gerenciamento {
    private Processos processo;
    private Node cabeca=null ;

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
        novo.criacao(processo);
        if(isEmpty()){
            cabeca=novo;

        }
        else{
            novo.next=cabeca;
            cabeca=novo.next;
        }
    }
    //funcao para adicionar na ultima posicao da lista
    public void adUltimo(){
        Node novo= new Node();
        novo.criacao(processo);
        if(isEmpty()){
            novo=cabeca;
        }else{
            Node atual= cabeca;
            while(atual.next!=cabeca){
                atual=atual.next;
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
    public Processos removerPrimeiro(){
        if (isEmpty()) {
            System.out.println("a lista esta vazia");
            return null;
        }else cabeca=cabeca.next;
        return null;
    }

    public Node removerDCeRetornar(){

    }




}

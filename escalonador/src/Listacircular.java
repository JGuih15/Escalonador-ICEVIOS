public class Listacircular {
    private Node atual;
    private Node cabeca;
    private int tamanho=0;

        public boolean isEmpty(){
           if(this.cabeca==null){
               return true;
           }
           return false;
        }

    public void addProcessoLC(Processos processo) {
        Node novoNo = new Node();
        novoNo.criacao(processo);//chamando a função de criação,onde as informações do processo sao adicionadas.
        if (isEmpty()) {
            atual = novoNo;
            novoNo.next = atual;
        }
        else {
            Node temp = cabeca;
            while (temp.next != cabeca) {
                temp = temp.next;
            }
            temp.next = novoNo;
            novoNo.next = cabeca;
        }
        tamanho++;
    }
    public void removerProcessoLC(Processos processo) {
            if(isEmpty()){
           System.out.println("nao existe nenhum arquivo aqui");
           return;
            } else if (atual.next==null) {
                cabeca=null;
            }
            else{
                Node temp=cabeca;
                while(temp.next!=atual){
                    temp=temp.next;
                }
                temp.next=cabeca.next;
                cabeca=temp.next;
            }
            tamanho--;
    }

    public void removerUltimoProcessoLC(Processos processo) {
        if(isEmpty()){
            System.out.println("processo inexistente");
        }
        else if(atual.next==null){
            cabeca=null;
        }
        else{

            while(atual.next.next!=cabeca){
                atual=atual.next;
            }
            atual=atual.next.next;
        }
        tamanho--;

    }

}

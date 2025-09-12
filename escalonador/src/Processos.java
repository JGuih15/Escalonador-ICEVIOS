public class Processos {
    private String nome;
    private int id;
    private int prioridade;
    private int ciclos;
    private int recursos;
    private boolean bloqueado;


    public Processos(String nome,int prioridade,int id, int ciclos,int recursos){
        this.nome=nome;
        this.prioridade=prioridade;
        this.id=id;
        this.ciclos=ciclos;
        this.recursos=recursos;
        this.bloqueado=false;
    }
    //getters e setters
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public int getPrioridade() {return prioridade;}
    public void setPrioridade(int prioridade) {this.prioridade = prioridade;}

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public int getCiclos() { return ciclos;}
    public void setCiclos(int ciclos) {this.ciclos = ciclos;}

    public int getRecursos() {return recursos;}
    public void setRecursos(int recursos) {this.recursos = recursos;}

    public boolean isBloqueado() {return bloqueado;}
    public void setBloqueado(boolean bloqueados) {this.bloqueado = bloqueados;}
}


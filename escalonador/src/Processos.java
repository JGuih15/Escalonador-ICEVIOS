public class Processos {
    private String nome;
    private int id;
    private int prioridade;
    private int ciclos;
    private String recursos;
    private boolean bloqueado;

    public Processos(String nome, int prioridade, int id, int ciclos, String recursos){
        this.nome = nome;
        this.prioridade = prioridade;
        this.id = id;
        this.ciclos = ciclos;
        this.recursos = recursos;
        this.bloqueado = false;
    }

    public String getNome() { return nome; }
    public int getPrioridade() { return prioridade; }
    public int getId() { return id; }
    public int getCiclos() { return ciclos; }
    public String getRecursos() { return recursos; }
    public boolean isBloqueado() { return bloqueado; }

    public void setNome(String nome) { this.nome = nome; }
    public void setPrioridade(int prioridade) { this.prioridade = prioridade; }
    public void setId(int id) { this.id = id; }
    public void setCiclos(int ciclos) { this.ciclos = ciclos; }
    public void setRecursos(String recursos) { this.recursos = recursos; }
    public void setBloqueado(boolean bloqueado) { this.bloqueado = bloqueado; }

    @Override
    public String toString() {
        return "Processo{" +
                "nome='" + nome + '\'' +
                ", prioridade=" + prioridade +
                ", id=" + id +
                ", ciclos=" + ciclos +
                ", recursos=" + recursos +
                '}';
    }
}

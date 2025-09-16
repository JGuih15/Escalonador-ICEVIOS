public class NoDuplo extends Node {
    Processos processos;
    NoDuplo proximo;
    NoDuplo anterior;

    public NoDuplo(Processos p) {
        super();
        this.processos = p;
        this.proximo = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        return processos.toString();
    }

    public Boolean getProcesso() {

        this.processos=processos;
        return true;
    }

    public NoDuplo getProximo() {
        this.processos=processos;
        return null;
    }
}

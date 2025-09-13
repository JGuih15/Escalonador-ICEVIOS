public class NoDuplo extends Node {
    Processos processos;
    NoDuplo proximo;
    NoDuplo anterior;

    public NoDuplo() {
        super();
        this.processos = processos;
        this.proximo = null;
        this.anterior = null;
    }

    @Override
    public String toString() {
        return processos.toString();
    }
}

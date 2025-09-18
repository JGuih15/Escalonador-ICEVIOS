public class scheduler {
    ListaDupla altaPrioridade = new ListaDupla();
    ListaDupla mediaPrioridade = new ListaDupla();
    ListaDupla baixaPrioridade = new ListaDupla();
    ListaDupla bloqueados = new ListaDupla();
    Listacircular listaExecucao = new Listacircular();

    private int contadorAlta = 0;
    public int ciclos = 0;

    public void adicionar_Processo(Processos processo) {
        switch (processo.getPrioridade()) {
            case 1: altaPrioridade.adicionarNoFinal(processo); break;
            case 2: mediaPrioridade.adicionarNoFinal(processo); break;
            case 3: baixaPrioridade.adicionarNoFinal(processo); break;
            default: mediaPrioridade.adicionarNoFinal(processo); break;
        }
    }

    private void desbloquearProcesso() {
        if (bloqueados.getTamanho() > 0) {
            Processos p = bloqueados.removerDoInicio();
            adicionar_Processo(p);
        }
    }

    private void moverParaExecucao() {
        if (contadorAlta >= 5) {
            if (mediaPrioridade.getTamanho() > 0) listaExecucao.adicionarFim(mediaPrioridade.removerDoInicio());
            else if (baixaPrioridade.getTamanho() > 0) listaExecucao.adicionarFim(baixaPrioridade.removerDoInicio());
            contadorAlta = 0;
        } else {
            if (altaPrioridade.getTamanho() > 0) {
                listaExecucao.adicionarFim(altaPrioridade.removerDoInicio());
                contadorAlta++;
            } else if (mediaPrioridade.getTamanho() > 0) listaExecucao.adicionarFim(mediaPrioridade.removerDoInicio());
            else if (baixaPrioridade.getTamanho() > 0) listaExecucao.adicionarFim(baixaPrioridade.removerDoInicio());
        }
    }

    private void executarAtual() {
        if (listaExecucao.estaVazia()) return;
        Processos atualProc = listaExecucao.getAtual();
        if (atualProc.getRecursos() != null && !atualProc.isBloqueado()) {
            atualProc.setBloqueado(true);
            bloqueados.adicionarNoFinal(atualProc);
            listaExecucao.removerAtual();
            return;
        }
        atualProc.setCiclos(atualProc.getCiclos() - 1);
        if (atualProc.getCiclos() <= 0) listaExecucao.removerAtual();
        else listaExecucao.avancar();
    }

    private void imprimirEstado() {
        System.out.println("--- ESTADO DO SISTEMA ---");
        System.out.println("Alta prioridade:");
        altaPrioridade.imprimirLista();
        System.out.println("Media prioridade:");
        mediaPrioridade.imprimirLista();
        System.out.println("Baixa prioridade:");
        baixaPrioridade.imprimirLista();
        System.out.println("Bloqueados:");
        bloqueados.imprimirLista();
        System.out.println("Execução:");
        listaExecucao.imprimirLista();
        System.out.println("Ciclos executados: " + ciclos);
        System.out.println("----------------------------\n");
    }

    public boolean temProcesso() {
        return !altaPrioridade.estaVazia() || !mediaPrioridade.estaVazia() ||
                !baixaPrioridade.estaVazia() || !bloqueados.estaVazia() || !listaExecucao.estaVazia();
    }

    public void execucaoCompleta() {
        while (temProcesso()) {
            ciclos++;
            desbloquearProcesso();
            moverParaExecucao();
            if (!listaExecucao.estaVazia()) executarAtual();
            imprimirEstado();
        }
        System.out.println("Execução finalizada. Total de ciclos: " + ciclos);
    }
}

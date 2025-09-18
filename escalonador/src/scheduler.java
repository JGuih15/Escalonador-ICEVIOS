public class scheduler {
    ListaDupla AltaPrioridade = new ListaDupla();
    ListaDupla MediaPrioridade = new ListaDupla();
    ListaDupla baixaPrioridade = new ListaDupla();
    ListaDupla bloqueados = new ListaDupla();
    ListaCircular listaExecucao = new ListaCircular();

    public int ciclos;
    private int contadorAlta = 0;

    public void adicionar_Processo(Processos processo) {
        switch (processo.getPrioridade()) {
            case 1:
                AltaPrioridade.adicionarNoFinal(processo);
                break;
            case 2:
                MediaPrioridade.adicionarNoFinal(processo);
                break;
            case 3:
                baixaPrioridade.adicionarNoFinal(processo);
                break;
        }
    }

    private void desbloquearProcesso() {
        if (bloqueados.getTamanho() > 0) {
            Processos processoDesbloqueado = bloqueados.removerDoInicio();
            if (processoDesbloqueado.getPrioridade() == 1) {
                AltaPrioridade.adicionarNoFinal(processoDesbloqueado);
            } else if (processoDesbloqueado.getPrioridade() == 2) {
                MediaPrioridade.adicionarNoFinal(processoDesbloqueado);
            } else if (processoDesbloqueado.getPrioridade() == 3) {
                baixaPrioridade.adicionarNoFinal(processoDesbloqueado);
            }
        }
    }

    private void moverParaExecucao() {
        if (contadorAlta >= 5) {
            if (MediaPrioridade.getTamanho() > 0) {
                listaExecucao.adicionarFim(MediaPrioridade.removerDoInicio());
            } else if (baixaPrioridade.getTamanho() > 0) {
                listaExecucao.adicionarFim(baixaPrioridade.removerDoInicio());
            }
            contadorAlta = 0;
        } else {
            if (AltaPrioridade.getTamanho() > 0) {
                listaExecucao.adicionarFim(AltaPrioridade.removerDoInicio());
                contadorAlta++;
            } else if (MediaPrioridade.getTamanho() > 0) {
                listaExecucao.adicionarFim(MediaPrioridade.removerDoInicio());
            } else if (baixaPrioridade.getTamanho() > 0) {
                listaExecucao.adicionarFim(baixaPrioridade.removerDoInicio());
            }
        }
    }

    private void executarAtual() {
        if (listaExecucao.estaVazia()) return;
        Processos atual = listaExecucao.getAtual();
        if (atual.getRecursos() > 0 && atual.isBloqueado() == false) {
            atual.setBloqueado(true);
            bloqueados.adicionarNoFinal(atual);
            listaExecucao.removerAtual();
            return;
        }
        atual.setCiclos(atual.getCiclos() - 1);
        if (atual.getCiclos() <= 0) {
            listaExecucao.removerAtual();
        } else {
            listaExecucao.avancar();
        }
    }

    private void imprimirEstado() {
        System.out.println("--- ESTADO DO SISTEMA ---");
        System.out.println("Alta prioridade:");
        AltaPrioridade.imprimirLista();
        System.out.println("Media prioridade:");
        MediaPrioridade.imprimirLista();
        System.out.println("Baixa prioridade:");
        baixaPrioridade.imprimirLista();
        System.out.println("Bloqueados:");
        bloqueados.imprimirLista();
        System.out.println("Execução:");
        listaExecucao.imprimirLista();
        System.out.println("Ciclos executados: " + ciclos);
    }

    public boolean temProcesso() {
        return !AltaPrioridade.estaVazia() || 
               !MediaPrioridade.estaVazia() || 
               !baixaPrioridade.estaVazia() || 
               !bloqueados.estaVazia() || 
               !listaExecucao.estaVazia();
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

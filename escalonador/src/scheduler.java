import java.io.IOException;
public class scheduler{
    private ListaDupla AltaPrioridade;
    private ListaDupla MediaPrioridade;
    private ListaDupla BaixaPrioridade;
    private ListaDupla Bloqqueados;
    private Listacircular Execucao;
    private  int ciclosAlta;
    private int ciclos;

    public scheduler(){
        this.AltaPrioridade= new ListaDupla();
        this.MediaPrioridade= new ListaDupla();
        this.BaixaPrioridade=new ListaDupla();
        this.Execucao= new Listacircular();
        this.ciclosAlta=0;
        this.ciclos=0;
    }

    //metodo para adicionar processos na fila de prioridade.

    public void adicionar(Processos processo){
        switch (processo.getPrioridade()){
            case 1:
                AltaPrioridade.addInicioDC(processo);
                break;
            case 2:
                MediaPrioridade.addInicioDC(processo);
                break;
            case 3:
                BaixaPrioridade.addInicioDC(processo);
                break;
        }
    }

    //metodo para mover para lista de execucao.
    public void Executar(){
        if(ciclosAlta>=5){//previnir inanicao de processos
            if(MediaPrioridade.getTamanho()>0){//verifica a quantidade de processos adicionados na lista media.
               Processos processo= MediaPrioridade.removerInicioDC().processos;
               Execucao.addProcessoLC(processo);

            } else if (BaixaPrioridade.getTamanho()>0) {
                Processos processo=BaixaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);
            }
            ciclosAlta=0;

        }else{
            if (AltaPrioridade.getTamanho() > 0) {
                Processos processo = AltaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);
                ciclosAlta++;

            } else if (MediaPrioridade.getTamanho() > 0) {
                Processos processo = MediaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);

            } else if (BaixaPrioridade.getTamanho() > 0) {
                Processos processo = BaixaPrioridade.removerInicioDC().processos;
                Execucao.addProcessoLC(processo);
            }
        }

    }

    public void Escalonar(){
        if(Execucao == null){
            System.out.println("sem processos para executar aqui");
            return;
        }

        Processos processo = Execucao.processo;

        if(processo == null){
            System.out.println("Erro ao obter processo da fila");
            return;
        }

        System.out.println("Executando processo: " + processo.getNome() +
                " (ID: " + processo.getId() +
                ", Ciclos restantes: " + processo.getCiclos() + ")");

        // Quantum fixo de 3
        int quantum = 3;
        int ciclosParaExecutar = Math.min(quantum, processo.getCiclos());

        for(int i = 0; i < ciclosParaExecutar; i++){
            System.out.println("Tempo " + ciclos + ": Executando " + processo.getNome());
            ciclos++;
            processo.setCiclos(processo.getCiclos() - 1);

            // Simular bloqueio se tem recurso
            if(Math.random() < 0.2 && processo.getRecursos() != null && !processo.getRecursos().equals("null")){
                System.out.println("Processo " + processo.getNome() + " BLOQUEADO esperando recurso: " + processo.getRecursos());
                processo.setBloqueado(true);
                Execucao.removerProcessoLC(processo);
                Bloqqueados.addFinalDC(processo);
                return;
            }
        }

        if(processo.getCiclos() <= 0){
            System.out.println("Processo " + processo.getNome() + " TERMINADO no tempo " + ciclos);
            Execucao.removerProcessoLC(processo);
        }
    }

    public void desbloquearProcessos(){
        if(Bloqqueados.isEmpty()) return;

        if(Math.random() < 0.4){
            Node desbloqueado = Bloqqueados.removerInicioDC();
            if(desbloqueado != null){
                Processos processo = desbloqueado.processos;
                processo.setBloqueado(false);
                System.out.println("Processo " + processo.getNome() + " DESBLOQUEADO");
                adicionar(processo);
            }
        }
    }

    public void executarFila(){
        System.out.println("\n========== INICIANDO EXECUCAO DO ESCALONADOR ==========");

        int ciclosMaximos = 100;
        int ciclosExecutados = 0;

        while(ciclosExecutados < ciclosMaximos && existemProcessos()){
            System.out.println("\n--- CICLO " + (ciclosExecutados + 1) + " ---");

            desbloquearProcessos();

            if(Execucao.getTamanho() == 0){
                Executar();
            }

            if(Execucao.getTamanho() > 0){
                Escalonar();
            }

            if((ciclosExecutados + 1) % 5 == 0){
                exibirEstadoFilas();
            }

            ciclosExecutados++;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("\n========== EXECUCAO FINALIZADA ==========");
        System.out.println("Ciclos executados: " + ciclosExecutados);
        System.out.println("Tempo total: " + ciclos);

        exibirRelatorioFinal();
    }

    public boolean existemProcessos(){
        return !AltaPrioridade.isEmpty() ||
                !MediaPrioridade.isEmpty() ||
                !BaixaPrioridade.isEmpty() ||
                Execucao.getTamanho() > 0 ||
                !Bloqqueados.isEmpty();
    }

    public void exibirEstadoFilas(){
        System.out.println("\n=== ESTADO ATUAL DAS FILAS ===");
        System.out.println("Alta Prioridade: " + AltaPrioridade.getTamanho() + " processos");
        System.out.println("Media Prioridade: " + MediaPrioridade.getTamanho() + " processos");
        System.out.println("Baixa Prioridade: " + BaixaPrioridade.getTamanho() + " processos");
        System.out.println("Em Execucao: " + Execucao.getTamanho() + " processos");
        System.out.println("Bloqueados: " + Bloqqueados.getTamanho() + " processos");
        System.out.println("Ciclos de Alta Prioridade: " + ciclosAlta);
        System.out.println("Tempo Atual: " + ciclos);
    }

    public void exibirRelatorioFinal(){
        System.out.println("\n=== RELATORIO FINAL ===");

        if(!AltaPrioridade.isEmpty()){
            System.out.println("Processos nao executados (Alta Prioridade):");
            AltaPrioridade.listarDC();
        }

        if(!MediaPrioridade.isEmpty()){
            System.out.println("Processos nao executados (Media Prioridade):");
            MediaPrioridade.listarDC();
        }

        if(!BaixaPrioridade.isEmpty()){
            System.out.println("Processos nao executados (Baixa Prioridade):");
            BaixaPrioridade.listarDC();
        }

        if(!Bloqqueados.isEmpty()){
            System.out.println("Processos ainda bloqueados:");
            Bloqqueados.listarDC();
        }

        System.out.println("\nEstatisticas:");
        System.out.println("Total de ciclos: " + ciclos);
        System.out.println("Ciclos de alta prioridade: " + ciclosAlta);
    }

    public void leitura(String caminho) throws IOException {
        System.out.println("=== CARREGANDO PROCESSOS DO ARQUIVO ===");
        Processos[] processos = LeitordeDados.leituraTXT(caminho);

        for (Processos processo : processos) {
            if (processo != null) {
                adicionar(processo);
                System.out.println("Processo adicionado: " + processo);
            }
        }

        System.out.println("\n=== ESTADO INICIAL DAS FILAS ===");
        exibirEstadoFilas();
    }

    public void adicionarProcessoEmTempo(Processos processo){
        System.out.println("Adicionando processo em tempo real: " + processo.getNome());
        adicionar(processo);
    }

    public void resetarEscalonador(){
        AltaPrioridade = new ListaDupla();
        MediaPrioridade = new ListaDupla();
        BaixaPrioridade = new ListaDupla();
        Bloqqueados = new ListaDupla();
        Execucao = new Listacircular();

        ciclosAlta = 0;
        ciclos = 0;

        System.out.println("ESCALONADOR RESETADO");
    }

  }
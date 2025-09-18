# Escalonador-ICEVIOS

# Escalonador-ICEVIOS

# Escalonador-ICEVIOS

**Disciplina:** Sistemas Operacionais  
**Tipo:** Trabalho Prático  
**Instituição:** Instituto de Ciência, Educação e Vida (ICEV)  

## Objetivo

Implementar um simulador de escalonador de processos em Java que utiliza um sistema de filas multicamadas com prioridades e controle de recursos, aplicando os conceitos fundamentais de sistemas operacionais relacionados ao gerenciamento de processos.

## Descrição do Sistema

O Escalonador-ICEVIOS é um simulador que gerencia processos através de:
- Sistema de filas multicamadas por prioridade
- Controle de recursos (CPU, Disco, Impressora, Rede)
- Algoritmo Round-Robin com prevenção de starvation
- Bloqueio e desbloqueio automático de processos

## Estrutura do Projeto

```
escalonador/
├── src/
│   ├── Main.java              # Classe principal do sistema
│   ├── scheduler.java         # Implementação do escalonador
│   ├── Processos.java         # Modelo de dados dos processos
│   ├── ListaDupla.java        # Estrutura de dados - lista duplamente ligada
│   ├── Listacircular.java     # Estrutura de dados - lista circular
│   ├── Node.java              # Nó para as estruturas de dados
│   └── LeitordeDados.java     # Leitor de arquivo de processos (não utilizado)
└── processos.txt              # Arquivo de configuração dos processos
```

## Requisitos Técnicos

### Ambiente de Desenvolvimento
- Java JDK 8 ou superior
- Sistema operacional: Windows, Linux ou macOS
- Memória RAM: mínimo 512 MB disponível
- Espaço em disco: 50 MB

### Dependências
- Nenhuma dependência externa necessária
- Utiliza apenas bibliotecas padrão do Java

## Configuração e Execução

### 1. Preparação do Ambiente
```bash
# Navegue até o diretório do projeto
cd escalonador/src
```

### 2. Configuração dos Processos
Edite o arquivo `processos.txt` seguindo a estrutura:
```
Nome Prioridade ID Ciclos Recurso
```

**Especificação dos Parâmetros:**
- **Nome**: Identificador alfanumérico do processo (sem espaços)
- **Prioridade**: Valor numérico (1=alta, 2=média, 3=baixa)
- **ID**: Identificador numérico único do processo
- **Ciclos**: Quantidade de ciclos de execução necessários
- **Recurso**: Tipo de recurso (CPU, Disco, Impressora, Rede) ou 'null'

**Exemplo de configuração:**
```
ProcessoA 1 101 5 CPU
ProcessoB 2 102 8 Disco
ProcessoC 3 103 2 Impressora
ProcessoD 2 104 6 Rede
ProcessoE 1 105 10 null
```

### 3. Compilação
```bash
javac *.java
```

### 4. Execução
```bash
java Main
```

## Algoritmo de Escalonamento

### Características Principais
1. **Filas Multicamadas**: Três níveis de prioridade (alta, média, baixa)
2. **Round-Robin**: Execução circular dos processos na fila de execução
3. **Prevenção de Starvation**: Após 5 processos de alta prioridade, executa um de média/baixa
4. **Controle de Recursos**: Processos com recursos específicos são bloqueados temporariamente
5. **Desbloqueio Periódico**: Processos bloqueados retornam às filas de prioridade

### Fluxo de Execução
```
Processos Novos → Filas de Prioridade → Lista de Execução → Conclusão
                      ↓
                Fila de Bloqueados ←→ Desbloqueio Periódico
```

## Funcionalidades Implementadas

### Gerenciamento de Filas
- Fila de alta prioridade (ListaDupla)
- Fila de média prioridade (ListaDupla)  
- Fila de baixa prioridade (ListaDupla)
- Fila de processos bloqueados (ListaDupla)
- Lista de execução circular (Listacircular)

### Controle de Recursos
- **CPU**: Processamento computacional
- **Disco**: Operações de entrada/saída
- **Impressora**: Operações de impressão
- **Rede**: Comunicação de rede
- **null**: Sem recurso específico

### Monitoramento em Tempo Real
- Estado atual de todas as filas
- Processo em execução
- Contador de ciclos totais
- Estatísticas de finalização

## Saída do Sistema

O sistema exibe periodicamente:
```
--- ESTADO DO SISTEMA ---
Alta prioridade: [lista de processos]
Media prioridade: [lista de processos]
Baixa prioridade: [lista de processos]
Bloqueados: [lista de processos]
Execução: [processo atual]
Ciclos executados: [número]
----------------------------
```

## Personalização

### Modificar Quantum
Altere a constante no arquivo `scheduler.java`:
```java
if (contadorAlta >= 5) // Modificar valor do quantum
```

### Adicionar Recursos
1. Inclua o novo recurso no arquivo `processos.txt`
2. Ajuste a lógica de bloqueio se necessário

## Resolução de Problemas

### Erro: Arquivo não encontrado
- Verifique se `processos.txt` está no diretório correto
- Confirme a nomenclatura exata do arquivo

### Erro: Formato de dados inválido
- Verifique se todos os campos estão preenchidos corretamente
- Confirme se valores numéricos não contêm caracteres especiais

### Processo não executa
- Prioridade deve estar entre 1-3
- Ciclos devem ser maior que zero

## Exemplo de Uso Completo

```bash
# 1. Preparar arquivo de processos
echo "TesteA 1 001 3 CPU" > processos.txt
echo "TesteB 2 002 5 null" >> processos.txt

# 2. Compilar
javac *.java

# 3. Executar
java Main
```

## Desenvolvimento

### Contribuidores
- **Gustavo**
- **João Guilherme Ribeiro Rocha da Cunha**
- **Luis Gabriel**

### Estrutura de Classes
- `Main`: Ponto de entrada e carregamento de processos
- `scheduler`: Lógica principal do escalonamento
- `Processos`: Modelo de dados dos processos
- `ListaDupla`: Implementação de lista duplamente ligada
- `Listacircular`: Implementação de lista circular
- `Node`: Estrutura de nó para as listas

## Licença

Este projeto está sob licença ICEV.

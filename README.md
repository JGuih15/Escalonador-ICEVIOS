# Escalonador-ICEVIOS

# Escalonador-ICEVIOS

Um simulador de escalonador de processos implementado em Java que utiliza um sistema de filas multicamadas com prioridades e controle de recursos.

## 📋 Requisitos

### Requisitos de Sistema
- **Java JDK 8** ou superior
- Sistema operacional: Windows, Linux ou macOS
- Mínimo de **512 MB** de RAM disponível
- Espaço em disco: aproximadamente **50 MB**

### Estrutura de Arquivos Necessária
```
escalonador/
├── src/
│   ├── Main.java
│   ├── scheduler.java
│   ├── Processos.java
│   ├── ListaDupla.java
│   ├── Listacircular.java
│   ├── Node.java
│   └── LeitordeDados.java
└── processos.txt
```

## 🚀 Como Utilizar o Escalonador

### 1. Preparação do Ambiente
```bash
# Clone ou baixe o projeto
git clone [URL-DO-REPOSITORIO]
cd Escalonador-ICEVIOS/escalonador
```

### 2. Configuração do Arquivo de Processos
Edite o arquivo `processos.txt` seguindo o formato:
```
Nome Prioridade ID Ciclos Recurso
```

**Parâmetros:**
- **Nome**: Identificador do processo (sem espaços)
- **Prioridade**: 1 (alta), 2 (média), 3 (baixa)
- **ID**: Número de identificação único
- **Ciclos**: Quantidade de tempo de execução necessário
- **Recurso**: CPU, Disco, Impressora, Rede, ou 'null' se nenhum recurso for necessário

**Exemplo de arquivo `processos.txt`:**
```
ProcessoA 1 101 5 CPU
ProcessoB 2 102 8 Disco
ProcessoC 3 103 2 Impressora
ProcessoD 2 104 6 Rede
ProcessoE 1 105 10 null
```

### 3. Compilação
```bash
# Navegue até o diretório src
cd src

# Compile todos os arquivos Java
javac *.java
```

### 4. Execução
```bash
# Execute o programa principal
java Main
```

## 🔧 Funcionalidades

### Sistema de Prioridades
- **Alta Prioridade (1)**: Processos críticos executados primeiro
- **Média Prioridade (2)**: Processos padrão
- **Baixa Prioridade (3)**: Processos menos importantes

### Controle de Recursos
- **CPU**: Processamento geral
- **Disco**: Operações de I/O em disco
- **Impressora**: Operações de impressão
- **Rede**: Comunicação de rede
- **null**: Nenhum recurso específico necessário

### Algoritmo de Escalonamento
1. **Round-Robin** com quantum para lista de execução
2. **Controle de Starvation**: Após 5 processos de alta prioridade, um de média/baixa é executado
3. **Bloqueio por Recursos**: Processos que necessitam recursos específicos são temporariamente bloqueados
4. **Desbloqueio Automático**: Processos bloqueados são periodicamente movidos de volta às filas de prioridade

## 📊 Saída do Sistema

O escalonador exibe em tempo real:
- Estado de todas as filas (alta, média, baixa prioridade)
- Lista de processos bloqueados
- Lista de execução atual
- Número de ciclos executados
- Estatísticas finais de execução

## ⚙️ Personalização

### Modificar Quantum de Tempo
No arquivo `scheduler.java`, altere a constante na linha que controla o contador:
```java
if (contadorAlta >= 5) // Altere o valor 5 para o quantum desejado
```

### Adicionar Novos Tipos de Recursos
1. Modifique o arquivo `processos.txt` com o novo recurso
2. Ajuste a lógica de bloqueio em `scheduler.java` se necessário

## 🐛 Solução de Problemas

### Erro: "Arquivo não encontrado"
- Verifique se o arquivo `processos.txt` está no diretório correto
- Certifique-se de que o nome do arquivo está correto

### Erro: "NumberFormatException"
- Verifique se todos os valores numéricos no arquivo estão corretos
- Confirme se não há caracteres especiais nos campos numéricos

### Processo não executando
- Verifique se a prioridade está entre 1-3
- Confirme se o número de ciclos é maior que 0

## 📝 Exemplo de Uso Completo

```bash
# 1. Prepare o arquivo processos.txt
echo "ProcessoA 1 101 5 CPU" > processos.txt
echo "ProcessoB 2 102 3 null" >> processos.txt

# 2. Compile o projeto
cd src
javac *.java

# 3. Execute
java Main
```

## 👥 Contribuidores

Este projeto foi desenvolvido por:
- **Gustavo**
- **João Guilherme**
- **Luis Gabriel**

## 📄 Licença

Este projeto está sob licença ICEV. Veja o arquivo LICENSE para mais detalhes.


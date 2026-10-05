# 🏥 Lista de Exercícios Práticos: Sistema de Agendamento da UBS

Este documento consolida os exercícios práticos desenvolvidos para o sistema de informação de uma Unidade Básica de Saúde (UBS) do SUS.

---

## Exercício 1: Agendamento por Ordem de Chegada (Árvore BST)

### Contexto do Mundo Real
Você desenvolve um sistema de informação para uma UBS do SUS. A partir das 7 da manhã, os(as) pacientes devem chegar para aguardar atendimento para consulta. O atendimento será por ordem de chegada (sem priorização). Quando o(a) paciente chega, ele(a) fornece o seu CPF, o(a) atendente verifica se o(a) paciente está cadastrado naquela UBS e, se estiver, insere o cadastro do paciente na agenda de consultas do dia.

A agenda de consultas do dia é uma **Árvore Binária de Pesquisa (BST)**, mantendo a propriedade de ordenação pelo número do CPF (apenas dígitos numéricos) dos pacientes, mas que terão a ordem de atendimento de acordo com a ordem de inserção na BST de agenda de consultas do dia.

### Requisitos do Projeto

#### 1. Modelagem do Nó (`Paciente`)
Cada nó da árvore representa a ficha de um paciente:
* `cpf` (Inteiro de 64 bits / Long) — Chave de ordenação da BST (ex: `12345678900`).
* `nome_completo` (Texto)
* `cartao_sus` (Texto)
* `tipo_atendimento` (Texto — ex: "Triagem", "Vacinação", "Consulta Agendada")
* Ponteiros/referências para pai, esquerda e direita.

#### 2. Operações já existentes (Atividade anterior)
* `cadastrar_paciente(cpf, nome, cartao_sus, tipo_atendimento)` [Inserção]: Insere a ficha do paciente novo na UBS na BST mantendo a propriedade de ordenação pelo CPF (CPFs menores à esquerda, maiores à direita). Não insere CPFs repetidos e avisa ao usuário nesse caso.
* `buscar_paciente(cpf)` [Busca]: Procura o paciente pelo CPF.
  * Se encontrado: exibe os dados do paciente e o número de comparações/nós visitados até localizá-lo.
  * Se não encontrado: exibe a mensagem "Paciente não cadastrado na triagem do dia".

#### 3. Novas Operações
* `remover_paciente(raiz, cpf)` [Remoção]: Remove o paciente da BST de cadastro de pacientes da UBS por CPF (ex: o paciente mudou de bairro).
* `cadastrar_atendimento_dia(cpf, nome, cartao_sus, tipo_atendimento)` [Inserção]: Insere o paciente na árvore BST de atendimentos do dia onde quem chega na UBS é inserido na árvore para ser atendido na ordem de chegada.
* `imprimir_atendimentos_dia(raiz)` [Busca em Profundidade]: Imprime a agenda de atendimentos do dia usando o algoritmo de busca em profundidade pré-ordem (imprime por ordem de inserção, como numa fila). Imprimir nome e CPF.

### Roteiro de Testes
1. **Carga Inicial de Pacientes da UBS:** Cadastrar seis pacientes da UBS.
2. **Remoção de Paciente:** Um paciente pede para ser removido porque mudou de bairro (remover pelo CPF).
3. **Simulação de Atendimento na Recepção (para 5 pacientes):**
   * Ao chegar um paciente para atendimento, buscar o paciente pelo CPF no cadastro de pacientes da UBS.
   * Inserir o paciente encontrado na agenda de atendimentos do dia.
4. **Imprimir a agenda de atendimentos do dia:** Para que o(a) atendente chame os pacientes na ordem correta.

---

## Exercício 2: Agendamento de Pacientes Prioritários (Heap)

### Contexto do Mundo Real
Neste cenário, a partir das 7 da manhã, os(as) pacientes devem chegar para aguardar atendimento por ordem de prioridade. A priorização será por **idade**, onde o paciente de **maior idade** é atendido primeiro. Quando o(a) paciente chega, ele(a) fornece o seu CPF, o(a) atendente verifica se o(a) paciente está cadastrado naquela UBS e, se estiver, insere o cadastro do paciente na agenda de consultas do dia, incluindo a idade para fins de priorização.

A agenda de consultas do dia é um **Heap**, considerando o(a) paciente mais prioritário(a) aquele(a) de maior idade.

### Requisitos do Projeto
*Nota: Não reusar a estrutura e operações do exercício anterior, pois a estrutura de dados é outra.*

#### 1. Modelagem da estrutura (`Paciente`)
Cada paciente possui os seguintes atributos:
* `cpf` (Inteiro de 64 bits / Long) — Chave de ordenação (ex: `12345678900`).
* `nome_completo` (Texto)
* `cartao_sus` (Texto)
* `tipo_atendimento` (Texto — ex: "Triagem", "Vacinação", "Consulta Agendada")
* `idade` (Inteiro)

#### 2. Implementação das Operações
* `cadastrar_atendimento_dia(heap, cpf, nome, cartao_sus, tipo_atendimento, idade)` [Inserção]: Função de cadastro na agenda de atendimentos do dia (inserção em um Heap) ordenada por idade.
* `remover_paciente_prioritário(heap)` [Remoção]: Remove o(a) paciente prioritário da agenda de atendimentos do dia.
* `quem_eh_o_proximo(heap)` [Consulta ao elemento raiz]: Retorna o elemento prioritário do Heap.

### Roteiro de Testes
1. **Simulação de Atendimento na Recepção (para 5 pacientes):** Inserir pacientes na agenda de atendimentos do dia (sem necessidade de verificar cadastro prévio).
2. **Consultar o próximo paciente** da agenda de atendimentos do dia.
3. **Remover o paciente prioritário** que foi chamado para o consultório.

---

## ⚠️ Requisitos Gerais para a Gravação de Vídeo

* O vídeo deve ter **até 3 minutos**.
* Não precisa explicar o código (isso será feito somente na prova oral).
* Explicar o programa do **ponto de vista do usuário**, mostrando funcionalidades, dados de entrada e dados de saída (estilo teste de caixa preta).
* Não precisa se filmar; apenas a voz explicando é suficiente.
* Dizer **seu nome, disciplina e semestre letivo** no início do vídeo.

## 🗃️ Entregas
* Entregar o código e o vídeo como anexo da atividade.
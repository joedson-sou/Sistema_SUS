import java.util.ArrayList;

public class BST {

    private Paciente raiz;
    private AtendimendoDoDia atendimendoDoDia;
    private int contadorChegada;

    public BST(){
        raiz = null;
        atendimendoDoDia = null;
        this.contadorChegada = 0;

    }

    public void cadastrarPaciente(Long cpf, String nomeCompleto, String cartaoSus, tipos_atendimento tipoAtendimento){
        Paciente novoPaciente = new Paciente(cpf, nomeCompleto, cartaoSus, tipoAtendimento);

        if(raiz == null){
            raiz = novoPaciente;
            System.out.println("Paciente cadastrado com sucesso:" + nomeCompleto + "CPF:" + cpf);
            return;
        }

        Paciente atual = raiz;

        while (true){
            if(cpf == atual.getCpf()){
                System.out.println("Aviso: CPF " + cpf +  " já cadastrado na triagem do dia.");
                return;
            }
            else if(cpf < atual.getCpf()){
                if(atual.getEsquerda() == null){
                    atual.setEsquerda(novoPaciente);
                    System.out.println("Paciente cadastrado com sucesso:" + nomeCompleto + "CPF:" + cpf);
                    return;
                }
                atual = atual.getEsquerda();
            }
            else {
                if(atual.getDireita() == null){
                    atual.setDireita(novoPaciente);
                    System.out.println("Paciente cadastrado com sucesso:" + nomeCompleto + "CPF:" + cpf);
                    return;
                }
                atual = atual.getDireita();
            }
        }
    }

    public Paciente buscarPaciente(Long cpf){
        Paciente atual = raiz;
        int comparacoes = 0;

        while (atual != null){
            comparacoes++;

            if(cpf.equals(atual.getCpf())){
                StringBuilder paciente = new StringBuilder();
                paciente.append("----- Paciente encontrado -----\n");
                paciente.append("Nome: ").append(atual.getNomeCompleto());
                paciente.append("\nCPF: ").append(atual.getCpf()).append("\nCartão SUS: ").append(atual.getCartaoSus());
                paciente.append("\nTipo Atendimento: ").append(atual.getTipoAtendimento());
                paciente.append("\nComparações/nós visitados: ").append(comparacoes);
                System.out.println(paciente.toString());
                return atual;
            }
            else if (cpf < atual.getCpf()) {
                atual = atual.getEsquerda();
            }
            else {
                atual = atual.getDireita();
            }

        }

        System.out.println("Paciente não cadastrado na triagem do dia");
        System.out.println("Comparações/nós visitados: " + comparacoes);
        return null;
    }


    public void removerPaciente(Long cpf){
        this.raiz = removerRecursivo(this.raiz, cpf);
    }


    private Paciente removerRecursivo(Paciente raiz, Long cpf) {

        if(raiz == null){
            return null;
        }

        if (cpf < raiz.getCpf()){
            raiz.setEsquerda(removerRecursivo(raiz.getEsquerda(), cpf));
        }

        else if (cpf > raiz.getCpf()){
            raiz.setDireita(removerRecursivo(raiz.getDireita(), cpf));
        }

        // Caso 1: Nó folha(sem filhos)
        else if(raiz.getEsquerda() == null && raiz.getDireita() == null){
            return null;
        }


        // Caso 2: Possui apenas um filho (Grau 1)
        else if (raiz.getEsquerda() == null){
            return raiz.getDireita();
        }

        else if (raiz.getDireita() == null){
            return raiz.getEsquerda();
        }

        // Caso 3: Possui dois filhos (Grau 2)

        else{

            Paciente sucessor = menorElemento(raiz.getDireita());

            raiz.setCpf(sucessor.getCpf());
            raiz.setNomeCompleto(sucessor.getNomeCompleto());
            raiz.setCartaoSus(sucessor.getCartaoSus());
            raiz.setTipoAtendimento(sucessor.getTipoAtendimento());

            raiz.setDireita(removerRecursivo(raiz.getDireita(), sucessor.getCpf()));
        }
        return raiz;
    }

    public Paciente menorElemento(Paciente no){
        if (no.getEsquerda() == null){
            return no;
        }

        else{
            return menorElemento(no.getEsquerda());
        }
    }

    public void cadastrarAtendimentoDoDia(long cpf, String nomeCompleto, String cartaoSus, tipos_atendimento tipoAtendimento){

        Paciente atual = new Paciente(cpf, nomeCompleto, cartaoSus, tipoAtendimento);
        contadorChegada++;

        atendimendoDoDia = inserirRecursivamente(atendimendoDoDia, contadorChegada, atual);
        System.out.println("- Atedimento do paciente " + atual.getNomeCompleto() + " cadastrado com sucesso!\n");

    }

    private AtendimendoDoDia inserirRecursivamente(AtendimendoDoDia atendimendo, int ordemChegada, Paciente atual) {

        if(atendimendo == null){
            //Cadastra o primeiro atendimento do dia
            return new AtendimendoDoDia(atual,  ordemChegada);
        }

        // Novos atedimentos sempre vao para direita, ja que é em ordem crescente
        if(ordemChegada < atendimendo.getOrdemDeChegada()){
            atendimendo.setEsquerda(inserirRecursivamente(atendimendo.getEsquerda(), ordemChegada, atual));
        }
        else if (ordemChegada > atendimendo.getOrdemDeChegada()){
            atendimendo.setDireita(inserirRecursivamente(atendimendo.getDireita(), ordemChegada, atual));
        }
        return atendimendo;
    }

    public void imprimirAtendimentosDoDia(AtendimendoDoDia atendimendo){
        if(atendimendo != null){
            //Imprimi NOME e CPF em ordem de chegada
            System.out.println("- Nome: " + atendimendo.getPaciente().getNomeCompleto() + " | CPF: " + atendimendo.getPaciente().getCpf() + " [Ordem: " + atendimendo.getOrdemDeChegada() + "]");

            //Imprimi atendiementos da esquerda
            imprimirAtendimentosDoDia(atendimendo.getEsquerda());

            //Imprimi atendiementos da direita
            imprimirAtendimentosDoDia(atendimendo.getDireita());
        }

    }


    public Paciente getRaiz() {
        return raiz;
    }

    public AtendimendoDoDia getAtendimendo(){
        return atendimendoDoDia;
    }
}

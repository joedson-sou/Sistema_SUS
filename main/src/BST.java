import java.util.ArrayList;

public class BST {

    private Paciente raiz;

    public BST(){
        raiz = null;
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
                System.out.println("Aviso: CPF " + cpf +  "já cadastrado na triagem do dia.");
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

            if(cpf == atual.getCpf()){
                StringBuilder paciente = new StringBuilder();
                paciente.append("----- Paciente encontrado -----\n");
                paciente.append("Nome: " + atual.getNomeCompleto());
                paciente.append("\nCPF: " + atual.getCpf());
                paciente.append("\nCartão SUS: " + atual.getCartaoSus());
                paciente.append("\nTipo Atendimento: " + atual.getTipoAtendimento());
                paciente.append("\nComparações/nós visitados: " + comparacoes);
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


    public Paciente getRaiz() {
        return raiz;
    }
}

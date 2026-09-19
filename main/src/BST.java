import java.util.ArrayList;

public class BST {

    private Paciente raiz;

    public BST(){
        raiz = null;
    }

    public void cadastrarPaciente(long cpf, String nomeCompleto, String cartaoSus, tipos_atendimento tipoAtendimento){
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

    public Paciente buscarPaciente(long cpf){
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


    public Paciente getRaiz() {
        return raiz;
    }
}

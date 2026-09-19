/**
 * Classe principal para simular o Motor de Busca de Pacientes do SUS.
 *
 * Roteiro de testes:
 * 1) Carga inicial de pacientes do dia (cadastro de CPFs).
 * 2) Simulação de atendimento na recepção:
 *    - Busca de um paciente com CPF cadastrado.
 *    - Busca de um paciente com CPF não cadastrado.
 */

public class Main {

    public static void main(String[] args) {

        BST arvore = new BST();

        System.out.println("=========================================");
        System.out.println(" 1) CARGA INICIAL DE PACIENTES DO DIA");
        System.out.println("=========================================");

        arvore.cadastrarPaciente(52481936600L, "Maria Oliveira Souza", "898001234567890", tipos_atendimento.TRIAGEM);
        arvore.cadastrarPaciente(31029487700L, "João Pedro Almeida", "898009876543210", tipos_atendimento.VACINACAO);
        arvore.cadastrarPaciente(70185294300L, "Ana Beatriz Lima", "898004561237890", tipos_atendimento.CONSULTA);
        arvore.cadastrarPaciente(19384756200L, "Carlos Eduardo Santos", "898007894561230", tipos_atendimento.TRIAGEM);
        arvore.cadastrarPaciente(48573920100L, "Fernanda Costa Ribeiro", "898003216549870", tipos_atendimento.VACINACAO);
        arvore.cadastrarPaciente(85296374100L, "Pedro Henrique Souza", "898006543219870", tipos_atendimento.CONSULTA);
        arvore.cadastrarPaciente(63715928400L, "Juliana Martins Alves", "898002587413690", tipos_atendimento.TRIAGEM);

        // Teste de CPF duplicado: mesmo CPF do primeiro paciente cadastrado
        System.out.println();
        System.out.println("--- Tentativa de cadastro com CPF duplicado ---");
        arvore.cadastrarPaciente(52481936600L, "Maria Oliveira Souza (duplicado)", "898001234567890", tipos_atendimento.TRIAGEM);

        System.out.println();
        System.out.println("=========================================");
        System.out.println(" 2) SIMULAÇÃO DE ATENDIMENTO NA RECEPÇÃO");
        System.out.println("=========================================");

        System.out.println();
        System.out.println("--- Busca de paciente CADASTRADO (CPF: 63715928400) ---");
        arvore.buscarPaciente(63715928400L);

        System.out.println();
        System.out.println("--- Busca de paciente NÃO CADASTRADO (CPF: 11122233344) ---");
        arvore.buscarPaciente(11122233344L);
    }
}
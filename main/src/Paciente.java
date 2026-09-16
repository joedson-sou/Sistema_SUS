public class Paciente {

    private Long cpf;
    private String nome_completo;
    private String cartao_sus;
    private tipos_atendimento tipo;
    private Paciente esquerda;
    private Paciente direita;


    public Paciente(Long cpf, String nome_completo, String cartao_sus, tipos_atendimento tipo, Paciente esquerda, Paciente direita) {
        this.cpf = cpf;
        this.nome_completo = nome_completo;
        this.cartao_sus = cartao_sus;
        this.tipo = tipo;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNome_completo() {
        return nome_completo;
    }

    public String getCartao_sus() {
        return cartao_sus;
    }

    public tipos_atendimento getTipo() {
        return tipo;
    }

    public Paciente getEsquerda() {
        return esquerda;
    }

    public Paciente getDireita() {
        return direita;
    }
}





public class Paciente {

    private Long cpf;
    private String nomeCompleto;
    private String cartaoSus;
    private tipos_atendimento tipoAtendimento;
    private Paciente esquerda;
    private Paciente direita;


    public Paciente(Long cpf, String nomeCompleto, String cartaoSus, tipos_atendimento tipoAtendimento) {
        this.cpf = cpf;
        this.nomeCompleto = nomeCompleto;
        this.cartaoSus = cartaoSus;
        this.tipoAtendimento = tipoAtendimento;
        this.esquerda = null;
        this.direita = null;
    }

    public Long getCpf() {
        return cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCartaoSus() {
        return cartaoSus;
    }

    public tipos_atendimento getTipoAtendimento() {
        return tipoAtendimento;
    }

    public Paciente getEsquerda() {
        return esquerda;
    }

    public Paciente getDireita() {
        return direita;
    }

    public void setCartaoSus(String cartaoSus) {
        this.cartaoSus = cartaoSus;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setTipoAtendimento(tipos_atendimento tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public void setDireita(Paciente direita) {
        this.direita = direita;
    }

    public void setEsquerda(Paciente esquerda) {
        this.esquerda = esquerda;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "cartaoSus='" + cartaoSus + '\'' +
                ", cpf=" + cpf +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", tipoAtendimento=" + tipoAtendimento +
                '}';
    }
}





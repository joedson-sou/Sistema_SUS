public enum tipos_atendimento {

    TRIAGEM("Triagem"),
    VACINACAO("Vacinação"),
    CONSULTA("Consulta Agendada");

    private final String tipo;

    tipos_atendimento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}

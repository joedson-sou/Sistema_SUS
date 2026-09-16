public enum tipos_atendimento {

    TRIAGEM("Triagem"),
    VACINACAO("Vacinação"),
    CONSULTA("Consulta");

    private final String tipo;

    tipos_atendimento(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

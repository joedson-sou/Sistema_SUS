public class AtendimendoDoDia {

    private Paciente paciente;
    private AtendimendoDoDia esquerda;
    private AtendimendoDoDia direita;
    private int ordemDeChegada;

    public AtendimendoDoDia(Paciente paciente, int ordemDeChegada) {
        this.paciente = paciente;
        this.ordemDeChegada = ordemDeChegada;
        this.esquerda = null;
        this.direita = null;

    }

    public AtendimendoDoDia getDireita() {
        return direita;
    }

    public void setDireita(AtendimendoDoDia direita) {
        this.direita = direita;
    }

    public AtendimendoDoDia getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(AtendimendoDoDia esquerda) {
        this.esquerda = esquerda;
    }

    public int getOrdemDeChegada() {
        return ordemDeChegada;
    }

    public void setOrdemDeChegada(int ordemDeChegada) {
        this.ordemDeChegada = ordemDeChegada;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}

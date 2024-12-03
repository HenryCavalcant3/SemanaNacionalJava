package util;

public class CertificadoModelo {
    private String prontuario;
    private String nome;
    
    private String eventoTitulo;
    private String eventoCargaHoraria;
    
    private String semanaNome;
    
    private String organizador;

    public CertificadoModelo() {
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEventoTitulo() {
        return eventoTitulo;
    }

    public void setEventoTitulo(String eventoTitulo) {
        this.eventoTitulo = eventoTitulo;
    }

    public String getEventoCargaHoraria() {
        return eventoCargaHoraria;
    }

    public void setEventoCargaHoraria(String eventoCargaHoraria) {
        this.eventoCargaHoraria = eventoCargaHoraria;
    }

    public String getSemanaNome() {
        return semanaNome;
    }

    public void setSemanaNome(String semanaNome) {
        this.semanaNome = semanaNome;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    @Override
    public String toString() {
        return "CertificadoModelo{" + "prontuario=" + prontuario + ", nome=" + nome + ", eventoTitulo=" + eventoTitulo + ", eventoCargaHoraria=" + eventoCargaHoraria + ", semanaNome=" + semanaNome + ", organizador=" + organizador + '}';
    }
}

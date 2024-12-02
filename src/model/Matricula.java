package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="matricula")
@NamedQueries({
    @NamedQuery(name = "Matricula.getAll", query = "SELECT m FROM Matricula m"),
})
public class Matricula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "evento_id", nullable = false)
    private Evento evento;
    
    @ManyToOne
    @JoinColumn(name = "participante_id", nullable = false)
    private Participante participante;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name = "ativa")
    private boolean ativa;
    
    @OneToOne(mappedBy = "matricula", cascade = CascadeType.ALL, orphanRemoval = true)
    private Presenca presenca;

    public Matricula() {
        this.ativa = true;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Presenca getPresenca() {
        return presenca;
    }

    public void setPresenca(Presenca presenca) {
        this.presenca = presenca;
    }
    
    public void addPresenca(Presenca presenca) {
        presenca.setMatricula(this);
        this.presenca = presenca;
    }

    public void removerPresenca(Presenca presenca) {
        presenca.setMatricula(null);
        this.presenca = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matricula other = (Matricula) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Matricula{" + "id=" + id + ", evento=" + evento + ", participante=" + participante + ", data=" + data + ", ativa=" + ativa + ", presenca=" + presenca + '}';
    }
}

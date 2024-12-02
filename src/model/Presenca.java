package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="presenca")
@NamedQueries({
    @NamedQuery(name = "Presenca.getAll", query = "SELECT p FROM Presenca p"),
})
@IdClass(PresencaPK.class)
public class Presenca implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Id
    @OneToOne
    @JoinColumn(name = "matricula_id", nullable = false)
    private Matricula matricula;
    
    @Column(name = "data_evento")
    @Temporal(TemporalType.DATE)
    private Date data;
    
    @Column(name="qtd_hora")
    private int qtdHora;

    public Presenca() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQtdHora() {
        return qtdHora;
    }

    public void setQtdHora(int qtdHora) {
        this.qtdHora = qtdHora;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.matricula);
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
        final Presenca other = (Presenca) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public String toString() {
        return "Presenca{" + "id=" + id + ", matricula=" + matricula + ", data=" + data + ", qtdHora=" + qtdHora + '}';
    }
}

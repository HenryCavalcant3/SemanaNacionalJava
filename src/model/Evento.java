package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="evento")
@NamedQueries({
    @NamedQuery(name = "Evento.getAll", query = "SELECT e FROM Evento e"),
})
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "semana_id", nullable = false)
    private Semana semana;
    
    @Column(name="titulo", length = 85, nullable = false)
    private String titulo;
    
    @Column(name="carga_horaria", nullable = false)
    private int cargaHoraria;
    
    @Column(name="numero_vaga", nullable = false)
    private int numeroVaga;
    
    @Column(name="qtd_inscrito", nullable = false)
    private int qtdInscrito;
    
    @Column(name = "data_evento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEvento;
    
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas;
    
    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsavel> responsaveis;

    public Evento() {
        this.matriculas = new ArrayList<>();
        this.responsaveis = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getNumeroVaga() {
        return numeroVaga;
    }

    public void setNumeroVaga(int numeroVaga) {
        this.numeroVaga = numeroVaga;
    }

    public int getQtdInscrito() {
        return qtdInscrito;
    }

    public void setQtdInscrito(int qtdInscrito) {
        this.qtdInscrito = qtdInscrito;
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }
    
    public void addResponsavel(Responsavel responsavel) {
        responsavel.setEvento(this);
        this.responsaveis.add(responsavel);
    }
    
    public void removeResponsavel(Responsavel responsavel) {
        responsavel.setEvento(null);
        this.responsaveis.remove(responsavel);
    }
    
    public void addMatricula(Matricula matricula) {
        matricula.setEvento(this);
        this.matriculas.add(matricula);
    }
    
    public void removeMatricula(Matricula matricula) {
        matricula.setEvento(null);
        this.matriculas.remove(matricula);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Evento other = (Evento) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Evento{" + "id=" + id + ", semana=" + semana + ", titulo=" + titulo + ", cargaHoraria=" + cargaHoraria + ", numeroVaga=" + numeroVaga + ", qtdInscrito=" + qtdInscrito + ", dataEvento=" + dataEvento + ", matriculas=" + matriculas + ", responsaveis=" + responsaveis + '}';
    }
}

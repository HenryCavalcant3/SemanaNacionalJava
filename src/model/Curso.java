package model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="curso")
@NamedQueries({
    @NamedQuery(name = "Curso.getAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.getByNome", query = "SELECT c FROM Curso c WHERE c.nome LIKE :nome")
})
public class Curso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="sigla", length = 12, nullable = false)
    private String sigla;
    
    @Column(name="nome", length = 45, nullable = false)
    private String nome;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Organizador> organizadores;
    
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participante> participantes;

    public Curso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Organizador> getOrganizadores() {
        return organizadores;
    }

    public void setOrganizadores(List<Organizador> organizadores) {
        this.organizadores = organizadores;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Curso other = (Curso) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", organizadores=" + organizadores + ", participantes=" + participantes + '}';
    }
}

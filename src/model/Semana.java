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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="semana")
@NamedQueries({
    @NamedQuery(name = "Semana.getAll", query = "SELECT s FROM Semana s"),
    @NamedQuery(name = "Semana.getByNome", query = "SELECT s FROM Semana s WHERE s.nome LIKE :nome")
})
public class Semana implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="nome", length = 60, nullable = false)
    private String nome;
    
    @Column(name="local", length = 80, nullable = false)
    private String local;
    
    @Column(name = "inicio")
    @Temporal(TemporalType.DATE)
    private Date inicio;
    
    @Column(name = "fim")
    @Temporal(TemporalType.DATE)
    private Date fim;
    
    @Column(name="observacao", length = 255, nullable = false)
    private String observacao;
    
    @Column(name = "ativa")
    private boolean ativa;
    
    @OneToOne(mappedBy = "semana", cascade = CascadeType.ALL, orphanRemoval = true)
    private Organizador organizador;
    
    @OneToMany(mappedBy = "semana", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Evento> eventos;

    public Semana() {
        this.eventos = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
    
    public void addEvento(Evento evento) {
        evento.setSemana(this);
        this.eventos.add(evento);
    }
    
    public void removeEvento(Evento evento) {
        evento.setSemana(null);
        this.eventos.remove(evento);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
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
        final Semana other = (Semana) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Semana{" + "id=" + id + ", nome=" + nome + ", local=" + local + ", inicio=" + inicio + ", fim=" + fim + ", observacao=" + observacao + ", ativa=" + ativa + ", organizador=" + organizador + ", eventos=" + eventos + '}';
    }
}

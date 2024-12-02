package model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
@NamedQueries({
    @NamedQuery(name = "Administrador.getAll", query = "SELECT a FROM Administrador a"),
    @NamedQuery(name = "Administrador.getByLogin", query = "SELECT a FROM Administrador a WHERE a.login = :login AND a.senha = :senha")
})
public class Administrador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name="login", length = 15, nullable = false)
    private String login;
    
    @Column(name="senha", length = 15, nullable = false)
    private String senha;

    public Administrador() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Administrador other = (Administrador) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Administrador{" + "id=" + id + ", login=" + login + ", senha=" + senha + '}';
    }
}

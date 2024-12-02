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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="participante")
@NamedQueries({
    @NamedQuery(name = "Participante.getAll", query = "SELECT p FROM Participante p"),
    @NamedQuery(name = "Participante.getByLogin", query = "SELECT p FROM Participante p WHERE p.login = :login AND p.senha = :senha"),
    @NamedQuery(name = "Participante.getByNome", query = "SELECT p FROM Participante p WHERE p.nome LIKE :nome")
})
public class Participante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    
    @Column(name="prontuario", length = 9, nullable = false)
    private String prontuario;
    
    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;
    
    @Column(name="nome", length = 45, nullable = false)
    private String nome;
    
    @Column(name="endereco", length = 60, nullable = false)
    private String endereco;
    
    @Column(name="cidade", length = 45, nullable = false)
    private String cidade;
    
    @Column(name="uf", length = 2, nullable = false)
    private String uf;
    
    @Column(name="cep", length = 9, nullable = false)
    private String cep;
    
    @Column(name="email", length = 60, nullable = false)
    private String email;
    
    @Column(name="telefone", length = 25, nullable = false)
    private String telefone;
    
    @Column(name="cpf", length = 14, nullable = false)
    private String cpf;
    
    @Column(name="login", length = 15, nullable = false)
    private String login;
    
    @Column(name="senha", length = 15, nullable = false)
    private String senha;
    
    @OneToMany(mappedBy = "participante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Responsavel> responsaveis;
    
    @OneToMany(mappedBy = "participante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas;

    public Participante() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public List<Responsavel> getResponsaveis() {
        return responsaveis;
    }

    public void setResponsaveis(List<Responsavel> responsaveis) {
        this.responsaveis = responsaveis;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
        final Participante other = (Participante) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Participante{" + "id=" + id + ", prontuario=" + prontuario + ", curso=" + curso + ", nome=" + nome + ", endereco=" + endereco + ", cidade=" + cidade + ", uf=" + uf + ", cep=" + cep + ", email=" + email + ", telefone=" + telefone + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha + ", responsaveis=" + responsaveis + ", matriculas=" + matriculas + '}';
    }
}

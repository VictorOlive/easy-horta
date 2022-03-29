package br.com.easyhorta.model;

import com.sun.istack.NotNull;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @SequenceGenerator(name = "produto", sequenceName = "sq_tb_produto", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
    @Column(name = "id_produto")
    private Integer id;

    @Column(name = "nm_produto", nullable = false)
    private String nome;

    //Mapeamento bidirecional
    @ManyToMany(mappedBy = "produtos")
    private List<Produtor> produtores;

    // --- Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produtor> getProdutores() {
        return this.produtores;
    }

    public void setProdutores(List<Produtor> produtores) {
        this.produtores = produtores;
    }
}

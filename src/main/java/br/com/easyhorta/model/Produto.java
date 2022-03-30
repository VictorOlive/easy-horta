package br.com.easyhorta.model;

import com.sun.istack.NotNull;

import java.util.List;

import javax.persistence.*;

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

    @Column(name = "nr_valor", nullable = false)
    private Float valor;

    @Column(name = "nr_qtd_disponivel", nullable = false)
    private Integer qtdDisponivel;

    //Mapeamento bidirecional
    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor produtor;

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

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getQtdDisponivel() {
        return qtdDisponivel;
    }

    public void setQtdDisponivel(Integer qtdDisponivel) {
        this.qtdDisponivel = qtdDisponivel;
    }
}

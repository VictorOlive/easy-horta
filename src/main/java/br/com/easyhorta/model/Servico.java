package br.com.easyhorta.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name = "tb_servico")
public class Servico {

    @Id
    @SequenceGenerator(name = "servico", sequenceName = "sq_tb_servico", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "servico")
    @Column(name = "id_servico")
    private Integer id;

    @Column(name = "nm_servico", length = 100)
    private String nome;

    @Column(name = "ds_servico", length = 1000)
    private String descricao;

    @Column(name = "dt_hr_servico")
    private LocalDate dataHora;

    @Column(name = "vl_servico")
    private Float valor;

    //Relacionamento com produtor
    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor produtor;

    // --- Constructor
    /**
     * @param nome
     * @param descricao
     * @param dataHora
     * @param valor
     */
    public Servico(String nome, String descricao, LocalDate dataHora, Float valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.valor = valor;
    }

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

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Produtor getProdutor() {
        return this.produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}

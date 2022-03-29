package br.com.easyhorta.model;

import java.time.LocalDateTime;

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
@Table(name = "tb_pedido")
public class Pedido {

    @Id
    @SequenceGenerator(name = "pedido", sequenceName = "sq_tb_pedido" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
    @Column(name = "id_pedido")
    private Integer id;

    @Column(name = "vl_pedido")
    private Float valor;

    @Column(name = "qt_pedido")
    private Integer quantidade;

    @Column(name = "dt_hr_pedido")
    private LocalDateTime dataHora = LocalDateTime.now();

    @Column(name = "ds_pedido")
    private String descricao;

    //Relacionamento com Produtor
    @ManyToOne
    @JoinColumn(name = "id_produtor")
    private Produtor produtor;

    //Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    // --- Constructor
    /**
     * @param valor
     * @param quantidade
     * @param dataHora
     * @param descricao
     */
    public Pedido(Float valor, Integer quantidade, String descricao, Cliente cliente) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.cliente = cliente;
    }

    // --- Getters & Setters
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValor() {
        return this.valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataHora() {
        return this.dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produtor getProdutor() {
        return this.produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}

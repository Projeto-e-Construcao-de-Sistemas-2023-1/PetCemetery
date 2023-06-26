package com.petcemetery.petcemetery.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "Pagamento")
@Table(name = "Pagamento")
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Adicionado para permitir auto incremento do id
    @Column(name = "id_pagamento")
    private Long idPagamento;
    
    @ManyToOne
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
    private Cliente cliente; 

    @Column(name = "valor")
    private float valor;

    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Date dataPagamento;

    @Column(name = "data_vencimento")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;

    @Column(name = "isPago")
    private boolean pago;
    
    @OneToOne
    @JoinColumn(name = "id_servico")
    private HistoricoServicos historicoServicos;


    @Column(name = "metodo_pagamento")
    @Enumerated(EnumType.STRING)
    private MetodoEnum metodoPagamento;
    
    public enum MetodoEnum{
        CREDITO,
        DEBITO,
        PAYPAL
    }
    
    public Pagamento() {}

    public Pagamento(Cliente cliente, float valor, Date dataPagamento, Date dataVencimento, boolean pago, HistoricoServicos historicoServicos, MetodoEnum metodoPagamento) {
        this.cliente = cliente;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
        this.pago = pago;
        this.historicoServicos = historicoServicos;
        this.metodoPagamento = metodoPagamento;
    }
     public Cliente getCliente() {
         return cliente;
     }
     public void setCliente(Cliente cliente) {
         this.cliente = cliente;
     }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public Date getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public boolean isPago() {
        return pago;
    }
    public void setPago(boolean pago) {
        this.pago = pago;
    }
    public HistoricoServicos getServico() {
        return historicoServicos;
    }
    public void setServico(HistoricoServicos historicoServicos) {
        this.historicoServicos = historicoServicos;
    }
    public MetodoEnum getMetodoPagamento() {
        return metodoPagamento;
    }
    public void setMetodoPagamento(MetodoEnum metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }
    public Long getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }

    

}

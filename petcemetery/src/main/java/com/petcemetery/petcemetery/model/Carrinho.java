package com.petcemetery.petcemetery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;



@Entity(name = "carrinho")
@Table(name = "carrinho")
public class Carrinho {


    @Id
    @Column(name = "cpf_cliente")
    private String cpfCliente;

    @OneToMany
    @JoinColumn(name = "carrinho_cpf_cliente")
    private List<Servico> servicos;

    @Column(name = "total_carrinho")
    private double totalCarrinho;

    public Carrinho() {}

    // Construtor de carrinho que deve ser chamado na criação de um cliente.
    public Carrinho(String cpfCliente) {
        this.cpfCliente = cpfCliente;
        this.servicos = new ArrayList<>();
        this.totalCarrinho = 0.0;
    }

    public void adicionarServico(Servico servico) {
        this.servicos.add(servico);
        this.totalCarrinho += servico.getValor();
    }

    public void removerServico(Servico servico) {
        this.servicos.remove(servico);
        this.totalCarrinho -= servico.getValor();
    }

    public void limparCarrinho() {
        this.servicos.clear();
        this.totalCarrinho -= this.totalCarrinho; 
        assert totalCarrinho >= 0;
    }

    public double getTotalCarrinho() {
        return totalCarrinho;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public List<Servico> getServicos() {
        return servicos;
    }

    public void setTotalCarrinho(double valor) {
        this.totalCarrinho = valor;
    }
}

package com.menezesdev.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private Double preco;

    @ManyToMany //Configura uma relação muitos-para-muitos entre PRODUTOS e CATEGORIAS
    @JoinTable(name = "PRODUTO_CATEGORIA", // tabela intermediária "PRODUTO_CATEGORIA" é criada para armazenar essa relação
            joinColumns = @JoinColumn(name = "produto_id"), // chave estrangeira para entidade "Produto"
            inverseJoinColumns = @JoinColumn(name = "categoria_id")) //chave estrangeira para entidade "Categoria"
    //configuração que permite o fácil acesso e manipulação da relação entre produtos e categorias
    private List<Categoria> categorias = new ArrayList<>();

    public Produto()
    {

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategoria() {
        return categorias;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categorias = categoria;
    }

    public Produto(Integer id, String nome, Double preco)
    {
        super();
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id.equals(produto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

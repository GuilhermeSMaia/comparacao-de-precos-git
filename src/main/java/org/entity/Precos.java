package org.entity;

import java.math.BigDecimal;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "precos")
public class Precos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public BigDecimal preco;
 
    @ManyToOne
    @JoinColumn(name = "mercados_id")
    public Mercados mercados;
    
    @ManyToOne
    @JoinColumn(name = "produtos_id")
    public Produtos produtos;
   
    public Precos() {}

    public Precos(BigDecimal preco, Mercados mercados, Produtos produtos) {
        this.preco = preco;
        this.mercados = mercados;
        this.produtos = produtos;
    }


    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    public BigDecimal getPreco() {
        return preco;
    }

    public Mercados getMercados() {
        return mercados;
    }

    public Produtos getProdutos() {
        return produtos;
    }
}

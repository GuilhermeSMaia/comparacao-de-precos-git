package org.entity;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produtos extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public float medida; 
    
    @OneToMany(mappedBy = "produtos")
    public List<Precos> precos;

    public Produtos() {}

    public Produtos( String nome) {
        this.nome = nome;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setPrecos(List<Precos> precos) {
        this.precos = precos;
    }
    public float getMedida() {
        return medida;
    }
    public String getNome() {
        return nome;
    }
    public List<Precos> getPrecos() {
        return precos;
    }
}

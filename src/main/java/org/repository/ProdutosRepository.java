package org.repository;

import java.util.List;

import org.entity.Produtos;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProdutosRepository implements PanacheRepositoryBase<Produtos, Long> {

   
    public Produtos findByNome(String Nome) {
        return find("nome", Nome).firstResult();
    }
    
}

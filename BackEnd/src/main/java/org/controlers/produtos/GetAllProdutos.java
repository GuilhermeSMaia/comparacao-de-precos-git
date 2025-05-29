package org.controlers.produtos;

import java.util.List;
import java.util.stream.Collectors;

import org.entity.Produtos;
import org.repository.ProdutosRepository;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/produtos")
public class GetAllProdutos {

    @Inject
    ProdutosRepository produtosRepository;

    @GET
    @Path("/getAllNames")
    public Response getAllProdutos( ) {
        List<Produtos> produtos = produtosRepository.listAll();

     
        List<String> nomes = produtos.stream()
            .map(Produtos::getNome)
            .collect(Collectors.toList());

        return Response.ok(nomes).build();
    }
       
    
}

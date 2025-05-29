package org.controlers.produtos;

import org.controlers.DTO.CreateProdutoDTO;
import org.entity.Produtos;
import org.repository.ProdutosRepository;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;


@Path("/produtos")
public class CreateProduto {
    @Inject
    ProdutosRepository produtoRepository;
    
    @POST
    @Transactional
    @Path("/create")
    public Response createProdutos(CreateProdutoDTO dto) {
        if (dto.produtoId == null) {
            Produtos produtoExistente = produtoRepository.findByNome(dto.nome);
            if (produtoExistente != null) {
                return Response.status(Response.Status.CONFLICT).entity("Produto já cadastrado").build();
            }

            Produtos produto = new Produtos(dto.nome);
            produtoRepository.persist(produto);
            return Response.ok("Produto criado com sucesso").build();
        }

        Produtos produto = produtoRepository.findById(dto.produtoId);  
        produto.setNome(dto.nome);
        produto.persist();
        return Response.ok("Produto atualizado com sucesso").build();

    }

    
}

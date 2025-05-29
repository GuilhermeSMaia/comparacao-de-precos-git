package org.controlers.produtos;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/produto")
public class GetByMercado {

    @Path("/getByMercado/{mercadoId}")
    @GET
    public Response getByMercado(@PathParam("mercadoId") Long mercadoId) {

        return Response.ok().build();
    }
    
}

package br.com.supermercado.api.recursos;


import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Venda;
import br.com.supermercado.api.services.VendasService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/vendas")
@Produces(MediaType.APPLICATION_JSON)
public class VendasResource {

    @Inject
    VendasService vendasService;


    @POST
    @Path("/comprador/{idDoComprador}")
    public Venda criandoUmaVenda(@PathParam("idDoComprador")Long idDoComprador, Venda venda) {
        vendasService.criandoUmaVenda(venda, idDoComprador);
        return venda;
    }



}

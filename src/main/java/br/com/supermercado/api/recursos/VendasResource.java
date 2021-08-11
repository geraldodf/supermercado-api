package br.com.supermercado.api.recursos;


import br.com.supermercado.api.dtos.CriacaoVendaDTO;
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
    @Path
    public void criandoUmaVenda(CriacaoVendaDTO criacaoVendaDTO) {
        vendasService.criandoUmaVenda(criacaoVendaDTO);

    }



}

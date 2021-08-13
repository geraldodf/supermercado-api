package br.com.supermercado.api.recursos;


import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.dtos.RelacaoVendaPagamentoDTO;
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
    public void criandoUmaVenda(CriacaoVendaDTO criacaoVendaDTO) {
        vendasService.criandoUmaVenda(criacaoVendaDTO);

    }

    @GET
    @Path("/{id}")
    public void pegarUmaVenda(@PathParam("id")Long id){
        vendasService.pegarUmaVenda(id);
    }


    @PUT
    public void inserirUmPagamento(RelacaoVendaPagamentoDTO relacaoVendaPagamentoDTO){
        vendasService.inserirUmPagamento(relacaoVendaPagamentoDTO);
    }





}

package br.com.supermercado.api.recursos;


import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.dtos.RelacaoVendaPagamentoDTO;
import br.com.supermercado.api.models.Venda;
import br.com.supermercado.api.services.VendasService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

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
    public List<Venda> pegarTodasVendas(){
        return vendasService.pegarTodasVendas();
    }

    @GET
    @Path("/{id}")
    public Venda pegarUmaVenda(@PathParam("id")Long id){
        return vendasService.pegarUmaVenda(id);
    }


    @PUT
    public void inserirUmPagamento(RelacaoVendaPagamentoDTO relacaoVendaPagamentoDTO){
        vendasService.inserirUmPagamento(relacaoVendaPagamentoDTO);
    }





}

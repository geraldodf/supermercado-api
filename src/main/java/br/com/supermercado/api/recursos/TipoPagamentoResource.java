package br.com.supermercado.api.recursos;

import br.com.supermercado.api.models.TipoPagamento;
import br.com.supermercado.api.services.TipoPagamentosService;
import lombok.Getter;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tipo-pagamentos")
@Produces(MediaType.APPLICATION_JSON)
public class TipoPagamentoResource {

    @Inject
    private TipoPagamentosService tipoPagamentosService;

    @POST
    public void criarUmTipoDePagamento(TipoPagamento tipoPagamento){
        tipoPagamentosService.criarUmTipoDePagamento(tipoPagamento);
    }

    @GET
    public List<TipoPagamento> pegarTodosTiposDePagamentos(){
        return tipoPagamentosService.pegarTodosTiposDePagamentos();
    }

    @GET
    @Path("/{id}")
    public TipoPagamento pegarUmTipoDePagamento(@PathParam("id") Long id){
        return tipoPagamentosService.pegarUmTipoDePagamento(id);
    }

    @PUT
    @Path("/{id}")
    public void atualizarUmTipoPagamento(@PathParam("id") Long id ,TipoPagamento tipoPagamento){
        tipoPagamentosService.atualizarUmTipoPagamento(id, tipoPagamento);
    }

    @DELETE
    @Path("/{id}")
    public void excluirUmTipoPagamento(@PathParam("id") Long id){
        tipoPagamentosService.excluirUmTipoPagamento(id);
    }


}

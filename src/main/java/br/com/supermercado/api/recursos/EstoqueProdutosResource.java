package br.com.supermercado.api.recursos;

import br.com.supermercado.api.dtos.AtualizarEstoqueProdutoDTO;
import br.com.supermercado.api.dtos.CriacaoProdutoEstoqueDTO;
import br.com.supermercado.api.models.EstoqueDeProdutos;
import br.com.supermercado.api.services.EstoqueProdutosService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/estoque")
@Produces(MediaType.APPLICATION_JSON)
public class EstoqueProdutosResource {

    @Inject
    private EstoqueProdutosService estoqueProdutosService;

    @GET
    public List<EstoqueDeProdutos> pegarTodosEstoques(){
        return estoqueProdutosService.pegarTodosEstoques();
    }

    @GET
    @Path("/{id}")
    public EstoqueDeProdutos pegarUmEstoque(@PathParam("id") Long id){
        return estoqueProdutosService.pegarUmEstoque(id);
    }

    @POST
    public void adicionarProdutoNoEstoque(CriacaoProdutoEstoqueDTO criacaoProdutoEstoqueDTO){
        estoqueProdutosService.adicionarProdutoNoEstoque(criacaoProdutoEstoqueDTO);
    }

    @PUT
    @Path("/{id}")
    public void atualizarProdutoEstoque(@PathParam("id") Long id, AtualizarEstoqueProdutoDTO atualizarEstoqueProdutoDTO){
        estoqueProdutosService.atualizarProdutoEstoque(id, atualizarEstoqueProdutoDTO);
    }

}

package br.com.supermercado.api.recursos;

import br.com.supermercado.api.daos.EstoqueProdutosDAO;
import br.com.supermercado.api.dtos.EstoqueDeProdutosDTO;
import br.com.supermercado.api.models.EstoqueDeProdutos;
import br.com.supermercado.api.services.EstoqueProdutosService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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

    @POST
    public void adicionarEstoque(EstoqueDeProdutosDTO estoqueDeProdutosDTO){
        estoqueProdutosService.adicionarEstoque(estoqueDeProdutosDTO);
    }

}

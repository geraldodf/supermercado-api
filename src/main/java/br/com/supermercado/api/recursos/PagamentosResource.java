package br.com.supermercado.api.recursos;

import br.com.supermercado.api.dtos.CriacaoPagamentoDTO;
import br.com.supermercado.api.models.Pagamento;
import br.com.supermercado.api.services.PagamentosService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/pagamentos")
@Produces(MediaType.APPLICATION_JSON)
public class PagamentosResource {

    @Inject
    private PagamentosService pagamentosService;

    @GET
    public List<Pagamento> pegarTodosPagamentos() {
        return pagamentosService.pegarTodosPagamentos();
    }

    @POST
    public void criarUmPagamento(CriacaoPagamentoDTO criacaoPagamentoDTO){
        pagamentosService.criarUmPagamento(criacaoPagamentoDTO);
    }
}

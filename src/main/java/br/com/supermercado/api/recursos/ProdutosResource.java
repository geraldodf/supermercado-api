package br.com.supermercado.api.recursos;

import br.com.supermercado.api.daos.ProdutosDAO;
import br.com.supermercado.api.models.Produto;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/produtos")
@Produces(MediaType.APPLICATION_JSON)
public class ProdutosResource {

    @Inject
    ProdutosDAO produtosDAO;

    @GET
    public ArrayList<Produto> pegarTodosProdutos() {
        return produtosDAO.pegarTodosOsProdutos();
    }

    @GET
    @Path("/{idDoProduto}")
    public Produto pegarUmProduto(@PathParam("idDoProduto") Long idDoProduto) {
        return produtosDAO.pegarUmProduto(idDoProduto);
    }

    @POST
    public Produto criarUmProduto(Produto produto) throws Exception {
        return produtosDAO.criarUmProduto(produto);
    }

    @PUT
    @Path("/{idDoProduto}")
    public Produto atualizarUmProduto(@PathParam("idDoProduto") Long idDoProduto, Produto produto) {
        return produtosDAO.atualizarUmProduto(idDoProduto, produto);
    }

    @DELETE
    @Path("/{idDoProduto}")
    public void excluirUmProduto(@PathParam("idDoProduto") Long idDoProduto) throws Exception {
            produtosDAO.excluirUmProduto(idDoProduto);
    }
}

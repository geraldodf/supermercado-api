package br.com.supermercado.api.recursos;

import br.com.supermercado.api.models.Produto;

import javax.ws.rs.*;

@Path("/produtos")
public class ProdutosResource {

    @GET
    public String pegarTodosProdutos() {
        return "Pegar todos os produtos";
    }

    @GET
    @Path("/{idDoProduto}")
    public String pegarUmProduto(@PathParam("idDoProduto") Long idDoProduto) {
        return "Pegar produto, id do produto: " + idDoProduto;
    }

    @POST
    public String criarUmProduto(Produto produto){
        return "Produto criado, ID: " + produto.getNome();
    }

    @PUT
    @Path("/{idDoProduto}")
    public String atualizarUmProduto( @PathParam("idDoProduto") Long idDoProduto ,Produto produto){
        return "Produto atualizado, ID: " + idDoProduto + " Nome do produto " + produto.getNome() + " com o valor de: R$" + produto.getPreco();
    }

    @DELETE
    @Path("/{idDoProduto}")
    public  String excluirUmProduto(@PathParam("idDoProduto") Long idDoProduto){
        return "Produto excluido! ID: " + idDoProduto;
    }

}

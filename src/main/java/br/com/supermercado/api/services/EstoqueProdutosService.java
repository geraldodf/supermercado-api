package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.EstoqueProdutosDAO;
import br.com.supermercado.api.dtos.EstoqueDeProdutosDTO;
import br.com.supermercado.api.models.EstoqueDeProdutos;
import br.com.supermercado.api.models.Produto;
import br.com.supermercado.api.recursos.ProdutosResource;

import javax.inject.Inject;
import java.util.List;

public class EstoqueProdutosService {

    @Inject
    private EstoqueProdutosDAO estoqueProdutosDAO;
    @Inject
    private ProdutosResource produtosResource;

    public List<EstoqueDeProdutos> pegarTodosEstoques() {
        return (List<EstoqueDeProdutos>) estoqueProdutosDAO.pegarTodosEstoques();
    }

    public void adicionarEstoque(EstoqueDeProdutosDTO estoqueDeProdutosDTO) {
        EstoqueDeProdutos estoqueDeProdutos = new EstoqueDeProdutos();

        Long idDoProduto =  estoqueDeProdutosDTO.getIdDoProduto();

        Produto produto = new Produto();
        produto = produtosResource.pegarUmProduto(idDoProduto);
        estoqueDeProdutos.setProduto(produto);

        Long quantidade = estoqueDeProdutosDTO.getQuantidade();
        estoqueDeProdutos.setQuantidade(quantidade);

        estoqueProdutosDAO.adicionarEstoque(estoqueDeProdutos);
    }
}

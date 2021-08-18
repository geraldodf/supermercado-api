package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.EstoqueProdutosDAO;
import br.com.supermercado.api.dtos.AtualizarEstoqueProdutoDTO;
import br.com.supermercado.api.dtos.CriacaoProdutoEstoqueDTO;
import br.com.supermercado.api.models.EstoqueDeProdutos;
import br.com.supermercado.api.models.Produto;
import br.com.supermercado.api.recursos.EstoqueProdutosResource;
import br.com.supermercado.api.recursos.ProdutosResource;

import javax.inject.Inject;
import java.util.List;

public class EstoqueProdutosService {

    @Inject
    private EstoqueProdutosDAO estoqueProdutosDAO;
    @Inject
    private ProdutosResource produtosResource;
    @Inject
    private EstoqueProdutosResource estoqueProdutosResource;

    public List<EstoqueDeProdutos> pegarTodosEstoques() {
        return (List<EstoqueDeProdutos>) estoqueProdutosDAO.pegarTodosEstoques();
    }

    public void adicionarProdutoNoEstoque(CriacaoProdutoEstoqueDTO criacaoProdutoEstoqueDTO) {
        EstoqueDeProdutos estoqueDeProdutos = new EstoqueDeProdutos();

        estoqueDeProdutos.setProduto(produtosResource.pegarUmProduto(criacaoProdutoEstoqueDTO.getIdDoProduto()));

        estoqueDeProdutos.setQuantidade(criacaoProdutoEstoqueDTO.getQuantidade());

        estoqueProdutosDAO.adicionarProdutoNoEstoque(estoqueDeProdutos);
    }

    public void atualizarProdutoEstoque(Long id, AtualizarEstoqueProdutoDTO atualizarEstoqueProdutoDTO) {
        EstoqueDeProdutos estoqueDeProdutos = estoqueProdutosDAO.pegarUmEstoque(id);
        estoqueDeProdutos.setQuantidade(atualizarEstoqueProdutoDTO.getNovaQuantidade());


        estoqueProdutosDAO.atualizarUmProduto(estoqueDeProdutos);
    }

    public EstoqueDeProdutos pegarUmEstoque(Long id) {
        return estoqueProdutosDAO.pegarUmEstoque(id);
    }
}

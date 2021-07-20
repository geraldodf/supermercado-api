package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.ProdutosDAO;
import br.com.supermercado.api.models.Produto;

import javax.inject.Inject;
import java.util.ArrayList;

public class ProdutosService {

    @Inject
    ProdutosDAO produtosDAO;


    public ArrayList<Produto> pegarTodosOsProdutos() {
        return produtosDAO.pegarTodosOsProdutos();
    }


    public Produto pegarUmProduto(Long idDoProduto) {
        return produtosDAO.pegarUmProduto(idDoProduto);
    }

    public Produto criarUmProduto(Produto produto) throws Exception {
        return produtosDAO.criarUmProduto(produto);
    }


    public Produto atualizarUmProduto(Long idDoProduto, Produto produto) throws Exception {
        Produto produtoEncontrado = produtosDAO.pegarUmProduto(idDoProduto);

        if (produtoEncontrado == null) {
            throw new Exception();
        }
        if (produto.getNome() != null) {
            produtoEncontrado.setNome(produto.getNome());
        }
        try {
            if (produto.getPreco() != null || produto.getPreco() < 10000) {
                produtoEncontrado.setPreco(produto.getPreco());
            } else {
                throw new Exception();
            }

        } catch (Exception e) {
            throw new Exception("Valor invalido, o preco deve ser maior que 0 e menor que 10.000");
        }

        try {
            return produtosDAO.atualizarUmProduto(idDoProduto, produto);
        } catch (Exception e) {
            throw new Exception("Produto nao existente");
        }
    }


        public void excluirUmProduto (Long idDoProduto) throws Exception{
            try {
                produtosDAO.excluirUmProduto(idDoProduto);
            } catch (Exception e) {
                throw new Exception("Produto invalido.");
            }

        }



}

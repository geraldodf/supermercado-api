package br.com.supermercado.api.daos;


import br.com.supermercado.api.models.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class ProdutosDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public ArrayList<Produto> pegarTodosOsProdutos() {
        ArrayList<Produto> listaDeProdutos = (ArrayList<Produto>) entityManager.createQuery("from Produto").getResultList();
        return listaDeProdutos;
    }

    public Produto pegarUmProduto(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public Produto criarUmProduto(Produto produto) throws Exception {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(produto);
            if (produto.getNome() == null) throw new Exception();
            entityManager.getTransaction().commit();
            return produto;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception(e.getMessage());
        }

    }

    public Produto atualizarUmProduto(Long idDoProduto, Produto produto) throws Exception {
        Produto produtoEncontrado = entityManager.find(Produto.class, idDoProduto);
        if (produtoEncontrado == null){
            throw new Exception();
        }
        entityManager.getTransaction().begin();
        if (produto.getNome() != null) {
            produtoEncontrado.setNome(produto.getNome());
        }
        if (produto.getPreco() != null) {
            produtoEncontrado.setPreco(produto.getPreco());
        }
        entityManager.merge(produtoEncontrado);
        entityManager.getTransaction().commit();
        return produtoEncontrado;
    }

    public void excluirUmProduto(Long idDoProduto) throws Exception {
            Produto produtoParaExcluido = entityManager.find(Produto.class, idDoProduto);
            if (produtoParaExcluido == null){
                throw new Exception();
            }
            entityManager.getTransaction().begin();
            entityManager.remove(produtoParaExcluido);
            entityManager.getTransaction().commit();
    }

}

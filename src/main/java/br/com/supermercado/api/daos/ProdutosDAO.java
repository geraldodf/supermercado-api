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
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("O produto não pode ser cadastrado sem um nome.");
        }

    }

}

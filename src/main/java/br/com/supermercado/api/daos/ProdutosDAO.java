package br.com.supermercado.api.daos;


import br.com.supermercado.api.models.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

public class ProdutosDAO {

    public ArrayList<Produto> pegarTodosOsProdutos() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        ArrayList<Produto> listaDeProdutos = (ArrayList<Produto>) entityManager.createQuery("from Produto").getResultList();
        return listaDeProdutos;
    }

    public Produto pegarUmProduto(Long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.find(Produto.class, id);
    }

}

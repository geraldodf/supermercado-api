package br.com.supermercado.api.daos;

import br.com.supermercado.api.dtos.EstoqueDeProdutosDTO;
import br.com.supermercado.api.models.EstoqueDeProdutos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EstoqueProdutosDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<EstoqueDeProdutos> pegarTodosEstoques() {
       List<EstoqueDeProdutos> retorno =  (List<EstoqueDeProdutos>) entityManager.createQuery("from EstoqueDeProdutos").getResultList();
        return retorno;

    }


    public void adicionarEstoque(EstoqueDeProdutos estoqueDeProdutos) {
        entityManager.getTransaction().begin();
        entityManager.persist(estoqueDeProdutos);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}

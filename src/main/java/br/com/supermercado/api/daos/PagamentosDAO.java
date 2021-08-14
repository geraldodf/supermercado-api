package br.com.supermercado.api.daos;

import br.com.supermercado.api.models.Pagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class PagamentosDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public List<Pagamento> pegarTodosPagamentos() {
        return (ArrayList<Pagamento>) entityManager.createQuery("From Pagamento").getResultList();
    }

    public void criarUmPagamento(Pagamento pagamento) {
        entityManager.getTransaction().begin();
        entityManager.persist(pagamento);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public Pagamento pegarUmPagamento(Long id) {
        return entityManager.find(Pagamento.class, id);
    }

    public void excluirUmPagamento(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(Pagamento.class, id));
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}

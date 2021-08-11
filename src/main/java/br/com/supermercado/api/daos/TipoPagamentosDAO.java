package br.com.supermercado.api.daos;

import br.com.supermercado.api.models.Pagamento;
import br.com.supermercado.api.models.TipoPagamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class TipoPagamentosDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void criarUmTipoDePagamento(TipoPagamento tipoPagamento) {
        entityManager.getTransaction().begin();
        entityManager.persist(tipoPagamento);
        entityManager.getTransaction().commit();
    }

    public List<TipoPagamento> pegarTodosTiposDePagamentos() {
        return (ArrayList<TipoPagamento>) entityManager.createQuery("From TipoPagamento").getResultList();
    }

    public TipoPagamento pegarUmTipoDePagamento(Long id) {
        return entityManager.find(TipoPagamento.class, id);
    }

    public void atualizarUmTipoPagamento(Long id, TipoPagamento tipoPagamento) {
        TipoPagamento retorno = entityManager.find(TipoPagamento.class, id);
        retorno.setNomeTipoPagamento(tipoPagamento.getNomeTipoPagamento());
        entityManager.getTransaction().begin();
        entityManager.merge(retorno);
        entityManager.getTransaction().commit();
    }

    public void excluirUmTipoPagamento(Long id) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(TipoPagamento.class, id));
        entityManager.getTransaction().commit();
    }
}

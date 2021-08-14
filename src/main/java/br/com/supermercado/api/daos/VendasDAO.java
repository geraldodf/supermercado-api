package br.com.supermercado.api.daos;

import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.models.Pagamento;
import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Produto;
import br.com.supermercado.api.models.Venda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class VendasDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public void criarUmaVenda(Venda venda){
        entityManager.getTransaction().begin();
        entityManager.persist(venda);
        entityManager.getTransaction().commit();
    }

    public Pessoa atualizarComprador (Pessoa pessoa, Long id){
        Pessoa compradorEncontrado = entityManager.find(Pessoa.class, id);
        entityManager.getTransaction().begin();
        entityManager.merge(compradorEncontrado);
        entityManager.getTransaction().commit();
        return pessoa;
    }

    public void inserirUmPagamento(Pagamento pagamento) {
        entityManager.getTransaction().begin();
        entityManager.merge(pagamento);
        entityManager.getTransaction().commit();
    }

    public Venda pegarUmaVenda(Long id) {
        return entityManager.find(Venda.class, id);
    }

    public List<Venda> pegarTodasVendas() {
        return (List<Venda>) entityManager.createQuery("From Venda").getResultList();
    }
}

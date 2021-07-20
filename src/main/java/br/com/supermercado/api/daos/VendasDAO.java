package br.com.supermercado.api.daos;

import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Venda;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class VendasDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public Venda criarUmaVenda(Venda venda, Long idDoComprador){
        Pessoa comprador = entityManager.find(Pessoa.class, idDoComprador);
        entityManager.getTransaction().begin();
        venda.setPessoa(comprador);
        entityManager.persist(venda);
        entityManager.getTransaction().commit();
        return venda;
    }

    public Pessoa atualizarComprador (Pessoa pessoa, Long id){
        Pessoa compradorEncontrado = entityManager.find(Pessoa.class, id);
        entityManager.getTransaction().begin();
        entityManager.merge(compradorEncontrado);
        entityManager.getTransaction().commit();
        return pessoa;
    }
}

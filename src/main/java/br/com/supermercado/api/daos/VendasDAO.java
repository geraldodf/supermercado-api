package br.com.supermercado.api.daos;

import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Produto;
import br.com.supermercado.api.models.Venda;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;

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
}

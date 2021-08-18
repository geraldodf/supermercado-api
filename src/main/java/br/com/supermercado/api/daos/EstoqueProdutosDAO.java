package br.com.supermercado.api.daos;

import br.com.supermercado.api.models.EstoqueDeProdutos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EstoqueProdutosDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<EstoqueDeProdutos> pegarTodosEstoques() {
       List<EstoqueDeProdutos> retorno =  (List<EstoqueDeProdutos>) entityManager.createQuery("from EstoqueDeProdutos").getResultList();
        return retorno;

    }


    public void adicionarProdutoNoEstoque(EstoqueDeProdutos estoqueDeProdutos) {
        entityManager.getTransaction().begin();
        entityManager.persist(estoqueDeProdutos);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    public EstoqueDeProdutos pegarUmEstoque(Long id) {
        return entityManager.find(EstoqueDeProdutos.class, id);
    }

    public EstoqueDeProdutos atualizarUmProduto(EstoqueDeProdutos estoqueDeProdutos) {
        entityManager.getTransaction().begin();
        entityManager.merge(estoqueDeProdutos);
        entityManager.getTransaction().commit();
        entityManager.close();
        return estoqueDeProdutos;
    }

    public EstoqueDeProdutos pegarUmEstoquePeloIdDoProduto(Long id){
        Query query = entityManager.createQuery("select e from EstoqueDeProdutos e where e.produto.id = : id ", EstoqueDeProdutos.class);
        query.setParameter("id", id);
        return (EstoqueDeProdutos) query.getSingleResult();
    }

}

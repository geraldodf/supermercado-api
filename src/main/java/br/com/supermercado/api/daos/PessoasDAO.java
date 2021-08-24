package br.com.supermercado.api.daos;

import br.com.supermercado.api.models.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PessoasDAO {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("supermercadoPU");
    EntityManager entityManager = entityManagerFactory.createEntityManager();


    public ArrayList<Pessoa> pegarTodasPessoas() {
        ArrayList<Pessoa> listaDePessoas = (ArrayList<Pessoa>) entityManager.createQuery("From Pessoa").getResultList();
        return listaDePessoas;

    }

    public Pessoa pegarUmaPessoa(Long id) {
        return entityManager.find(Pessoa.class, id);

    }

    public Pessoa adicionarUmaPessoa(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pessoa;

    }

    public Pessoa criarUmapessoa(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
        return pessoa;
    }

    public void atualizarUmaPessoa(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.merge(pessoa);
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    public void excluirUmaPessoa(Long id) {
        Pessoa pessoaExcluir = entityManager.find(Pessoa.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(pessoaExcluir);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Pessoa> pesquisarPessoaPeloNome(String nome) {
        Query query = entityManager.createQuery("select p from Pessoa p where p.nome like: nome");
        return (ArrayList<Pessoa>) query.setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Pessoa> pesquisarPessoaPeloCpf(Long cpf) {
        Query query = entityManager.createQuery("select p from Pessoa p where CAST (p.cpf AS string) like: cpf");
        return (ArrayList<Pessoa>) query.setParameter("cpf", cpf.toString()).getResultList();
    }
}

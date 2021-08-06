package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.PessoasDAO;
import br.com.supermercado.api.models.Pessoa;

import javax.inject.Inject;
import java.util.ArrayList;

public class PessoasService {

    @Inject
    PessoasDAO pessoasDAO;

    public Pessoa adicionarUmaPessoa(Pessoa pessoa){
        return pessoasDAO.adicionarUmaPessoa(pessoa);
    }

    public ArrayList<Pessoa> pegarTodasPessoas() {
       return pessoasDAO.pegarTodasPessoas();
    }

    public Pessoa pegarUmaPessoa(Long id) {
        return pessoasDAO.pegarUmaPessoa(id);
    }

    public void atualizarUmaPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaExistente = pessoasDAO.pegarUmaPessoa(id);
        pessoaExistente.setCpf(pessoa.getCpf());
        pessoaExistente.setNome(pessoa.getNome());
        pessoasDAO.atualizarUmaPessoa(pessoaExistente);
    }

    public void excluirUmaPessoa(Long id) {
        pessoasDAO.excluirUmaPessoa(id);
    }
}

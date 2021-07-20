package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.PessoasDAO;
import br.com.supermercado.api.models.Pessoa;

import javax.inject.Inject;

public class PessoasService {

    @Inject
    PessoasDAO pessoasDAO;

    public Pessoa adicionarUmaPessoa(Pessoa pessoa){
        return pessoasDAO.adicionarUmaPessoa(pessoa);
    }

}

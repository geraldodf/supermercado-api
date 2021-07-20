package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.VendasDAO;
import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Venda;

import javax.inject.Inject;

public class VendasService {

    @Inject
    VendasDAO vendasDAO;

    public Venda criandoUmaVenda(Venda venda,Long idDoComprador){
        vendasDAO.criarUmaVenda(venda, idDoComprador);
        return venda;
    }

    public Pessoa atualizandoComprador(Pessoa pessoa, Long id){
        return vendasDAO.atualizarComprador(pessoa, id);
    }
}

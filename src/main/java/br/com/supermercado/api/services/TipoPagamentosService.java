package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.TipoPagamentosDAO;
import br.com.supermercado.api.models.TipoPagamento;

import javax.inject.Inject;
import java.util.List;

public class TipoPagamentosService {

    @Inject
    private TipoPagamentosDAO tipoPagamentosDAO;

    public void criarUmTipoDePagamento(TipoPagamento tipoPagamento) {
        tipoPagamentosDAO.criarUmTipoDePagamento(tipoPagamento);
    }

    public List<TipoPagamento> pegarTodosTiposDePagamentos() {
        return tipoPagamentosDAO.pegarTodosTiposDePagamentos();
    }

    public TipoPagamento pegarUmTipoDePagamento(Long id) {
       return tipoPagamentosDAO.pegarUmTipoDePagamento(id);
    }

    public void atualizarUmTipoPagamento(Long id, TipoPagamento tipoPagamento) {
        tipoPagamentosDAO.atualizarUmTipoPagamento(id, tipoPagamento);
    }

    public void excluirUmTipoPagamento(Long id) {
        tipoPagamentosDAO.excluirUmTipoPagamento(id);
    }
}

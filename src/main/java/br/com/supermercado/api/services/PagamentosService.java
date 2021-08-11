package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.PagamentosDAO;
import br.com.supermercado.api.daos.TipoPagamentosDAO;
import br.com.supermercado.api.dtos.CriacaoPagamentoDTO;
import br.com.supermercado.api.models.Pagamento;
import br.com.supermercado.api.models.TipoPagamento;

import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class PagamentosService {

    @Inject
    private PagamentosDAO pagamentosDAO;
    @Inject
    private TipoPagamentosDAO tipoPagamentosDAO;

    public List<Pagamento> pegarTodosPagamentos() {
        return pagamentosDAO.pegarTodosPagamentos();
    }

    public void criarUmPagamento(CriacaoPagamentoDTO criacaoPagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        pagamento.setDataPagamento(criacaoPagamentoDTO.getDataPagamento());
        pagamento.setPrecoAPagar(criacaoPagamentoDTO.getPrecoAPagar());

        ArrayList<TipoPagamento> tipoPagamentos = new ArrayList<>();
        for (int i = 0; i < criacaoPagamentoDTO.getListaIdTipoPagamento().size(); i++) {
            tipoPagamentos.add(tipoPagamentosDAO.pegarUmTipoDePagamento(criacaoPagamentoDTO.getListaIdTipoPagamento().get(i)));
        }
        pagamento.setTipoPagamento(tipoPagamentos);
        pagamentosDAO.criarUmPagamento(pagamento);
    }

    public Pagamento pegarUmPagamento(Long id) {
        return pagamentosDAO.pegarUmPagamento(id);
    }

    public void excluirUmPagamento(Long id) {
        pagamentosDAO.excluirUmPagamento(id);
    }
}

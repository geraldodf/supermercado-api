package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.PagamentosDAO;
import br.com.supermercado.api.daos.PessoasDAO;
import br.com.supermercado.api.daos.ProdutosDAO;
import br.com.supermercado.api.daos.VendasDAO;
import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.dtos.RelacaoVendaPagamentoDTO;
import br.com.supermercado.api.models.Pagamento;
import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Produto;
import br.com.supermercado.api.models.Venda;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class VendasService {

    @Inject
    private VendasDAO vendasDAO;
    @Inject
    private ProdutosDAO produtosDAO;
    @Inject
    private PessoasDAO pessoasDAO;
    @Inject
    private PagamentosDAO pagamentosDAO;

    public void criandoUmaVenda(CriacaoVendaDTO criacaoVendaDTO) {
        Venda venda = new Venda();
        venda.setData(criacaoVendaDTO.getDataVenda());

        List<Produto> listaProdutos = new ArrayList<>();

        criacaoVendaDTO.getIdListaProdutoVenda().forEach(id -> {
            listaProdutos.add(produtosDAO.pegarUmProduto(id));
        });
        venda.setProduto(listaProdutos);
        venda.setPessoa(pessoasDAO.pegarUmaPessoa(criacaoVendaDTO.getIdPessoaVenda()));

        vendasDAO.criarUmaVenda(venda);
    }

    public Pessoa atualizandoComprador(Pessoa pessoa, Long id) {
        return vendasDAO.atualizarComprador(pessoa, id);
    }


    public void inserirUmPagamento(RelacaoVendaPagamentoDTO relacaoVendaPagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        Venda venda = new Venda();
        pagamento = pagamentosDAO.pegarUmPagamento(relacaoVendaPagamentoDTO.getIdDoPagamento());
        venda = vendasDAO.pegarUmaVenda(relacaoVendaPagamentoDTO.getIdDaVenda());
        venda.setPagamento(pagamento);
        vendasDAO.inserirUmPagamento(pagamento);
    }

    public Venda pegarUmaVenda(Long id) {
        return vendasDAO.pegarUmaVenda(id);
    }

    public List<Venda> pegarTodasVendas() {
        return vendasDAO.pegarTodasVendas();
    }
}

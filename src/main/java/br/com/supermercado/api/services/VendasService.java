package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.*;
import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.dtos.ProdutoASerVendidoDTO;
import br.com.supermercado.api.dtos.RelacaoVendaPagamentoDTO;
import br.com.supermercado.api.models.*;

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
    @Inject
    private EstoqueProdutosDAO estoqueProdutosDAO;

    public void criandoUmaVenda(CriacaoVendaDTO criacaoVendaDTO) {
        criacaoVendaDTO.getDataVenda();
        Venda venda = new Venda();
        Long idPessoaVenda = criacaoVendaDTO.getIdPessoaVenda();
        List<ProdutoASerVendidoDTO> listaDeProdutoASerVendido = criacaoVendaDTO.getListaDeProdutosASerVendido();
        List<RelacaoVendaProduto> relacaoVendaProdutos = new ArrayList<>();

        venda.setData(criacaoVendaDTO.getDataVenda());
        venda.setPessoa(pessoasDAO.pegarUmaPessoa(criacaoVendaDTO.getIdPessoaVenda()));

        venda = vendasDAO.criarVendaComTransacaoAberta(venda);

        Venda finalVenda = venda;
        listaDeProdutoASerVendido.forEach(produto -> {
            Long idProduto = produto.getIdDoProduto();
            Long quantidade = produto.getQuantidadeProdutoASerVendido();
            Produto produtoRetorno = produtosDAO.pegarUmProduto(idProduto);

            RelacaoVendaProduto relacaoVendaProduto = new RelacaoVendaProduto();
            relacaoVendaProduto.setVenda(finalVenda);
            relacaoVendaProduto.setProduto(produtoRetorno);
            relacaoVendaProduto.setQuantidade(quantidade);

            relacaoVendaProdutos.add(relacaoVendaProduto);
        });
        venda.setRelacaoVendaProdutos(relacaoVendaProdutos);
        vendasDAO.atualizarAVendaSemAbrirTransacao(venda);

    }

    public Pessoa atualizandoComprador(Pessoa pessoa, Long id) {
        return vendasDAO.atualizarComprador(pessoa, id);
    }

    public void atualizarProdutosASerVendidoEEstoqueDaVenda(ProdutoASerVendidoDTO produtoASerVendidoDTO){

    }

    public void inserirUmPagamento(RelacaoVendaPagamentoDTO relacaoVendaPagamentoDTO) {
        Pagamento pagamento = new Pagamento();
        Venda venda = new Venda();
        pagamento = pagamentosDAO.pegarUmPagamento(relacaoVendaPagamentoDTO.getIdDoPagamento());
        venda = vendasDAO.pegarUmaVenda(relacaoVendaPagamentoDTO.getIdDaVenda());
        venda.setPagamento(pagamento);

        List<Produto> produtos = null;
        int i = 0;
        Produto retorno = produtos.get(i);
        EstoqueDeProdutos estoqueDeProdutos = estoqueProdutosDAO.pegarUmEstoquePeloIdDoProduto(retorno.getId());

        Long quantidade = estoqueDeProdutos.getQuantidade();
        quantidade = (quantidade - 1);

        vendasDAO.inserirUmPagamento(pagamento);
    }

    public Venda pegarUmaVenda(Long id) {
        return vendasDAO.pegarUmaVenda(id);
    }

    public List<Venda> pegarTodasVendas() {
        return vendasDAO.pegarTodasVendas();
    }
}

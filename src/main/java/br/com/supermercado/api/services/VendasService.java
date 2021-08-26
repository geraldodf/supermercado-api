package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.*;
import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.dtos.ProdutoASerVendidoDTO;
import br.com.supermercado.api.dtos.RelacaoVendaPagamentoDTO;
import br.com.supermercado.api.models.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

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
            produtoRetorno.getPreco();
            RelacaoVendaProduto relacaoVendaProduto = new RelacaoVendaProduto();
            relacaoVendaProduto.setVenda(finalVenda);
            relacaoVendaProduto.setProduto(produtoRetorno);
            relacaoVendaProduto.setQuantidade(quantidade);

            relacaoVendaProdutos.add(relacaoVendaProduto);
        });


        Double precoTotal = relacaoVendaProdutos.parallelStream().map(p -> p.getProduto().getPreco()).reduce(0.0, Double::sum);

        venda.setRelacaoVendaProdutos(relacaoVendaProdutos);
        venda.setValorAPagar(precoTotal);
        vendasDAO.atualizarAVendaSemAbrirTransacao(venda);

    }

    public Pessoa atualizandoComprador(Pessoa pessoa, Long id) {
        return vendasDAO.atualizarComprador(pessoa, id);
    }

    public void atualizarProdutosASerVendidoEEstoqueDaVenda(ProdutoASerVendidoDTO produtoASerVendidoDTO) {

    }


    public void inserirUmPagamento(RelacaoVendaPagamentoDTO relacaoVendaPagamentoDTO) throws Exception {
        Pagamento pagamento = new Pagamento();
        Venda venda = new Venda();
        pagamento = pagamentosDAO.pegarUmPagamento(relacaoVendaPagamentoDTO.getIdDoPagamento());
        venda = vendasDAO.pegarUmaVenda(relacaoVendaPagamentoDTO.getIdDaVenda());
        venda.setPagamento(pagamento);

        List<RelacaoVendaProduto> listaRelacaoVendaProduto = venda.getRelacaoVendaProdutos();

        Double precoTotal = listaRelacaoVendaProduto.parallelStream().map(p -> p.getProduto().getPreco()).reduce(0.0, Double::sum);
        Double valorPago = pagamento.getPrecoAPagar();

        if (valorPago >= precoTotal) {
            vendasDAO.inserirUmPagamento(pagamento);
        } else {
            throw new Exception("Pagamento inferior ao valor total.");
        }

    }

    public Venda pegarUmaVenda(Long id) {
        return vendasDAO.pegarUmaVenda(id);
    }

    public List<Venda> pegarTodasVendas() {
        return vendasDAO.pegarTodasVendas();
    }
}

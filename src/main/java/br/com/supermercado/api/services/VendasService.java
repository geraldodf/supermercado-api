package br.com.supermercado.api.services;

import br.com.supermercado.api.daos.*;
import br.com.supermercado.api.dtos.CriacaoVendaDTO;
import br.com.supermercado.api.dtos.ProdutoASerVendidoDTO;
import br.com.supermercado.api.dtos.RelacaoVendaPagamentoDTO;
import br.com.supermercado.api.models.*;
import br.com.supermercado.api.utilitarios.NotificadorDeVenda;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Singleton
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
    private NotificadorDeVenda notificadorDeVenda;



    public void criandoUmaVenda(CriacaoVendaDTO criacaoVendaDTO) {
        Venda venda = new Venda();
        List<ProdutoASerVendidoDTO> listaDeProdutoASerVendido = criacaoVendaDTO.getListaDeProdutosASerVendido();
        List<RelacaoVendaProduto> relacaoVendaProdutos = new ArrayList<>();
        venda.setData(criacaoVendaDTO.getDataVenda());
        venda.setPessoa(pessoasDAO.pegarUmaPessoa(criacaoVendaDTO.getIdPessoaVenda()));
        venda = vendasDAO.criarVendaComTransacaoAberta(venda);

        Venda finalVenda = venda;
        listaDeProdutoASerVendido.forEach(produto -> {
            RelacaoVendaProduto relacaoVendaProduto = new RelacaoVendaProduto();
            relacaoVendaProduto.setVenda(finalVenda);
            relacaoVendaProduto.setProduto(produtosDAO.pegarUmProduto(produto.getIdDoProduto()));
            relacaoVendaProduto.setQuantidade(produto.getQuantidadeProdutoASerVendido());
            relacaoVendaProdutos.add(relacaoVendaProduto);
        });
        Double valorTotal = relacaoVendaProdutos.parallelStream().map(p -> p.getProduto().getPreco()).reduce(0.0, Double::sum);
        venda.setRelacaoVendaProdutos(relacaoVendaProdutos);
        venda.setValorAPagar(valorTotal);
        vendasDAO.atualizarAVendaSemAbrirTransacao(venda);

    }

    public Pessoa atualizandoComprador(Pessoa pessoa, Long id) {
        return vendasDAO.atualizarComprador(pessoa, id);
    }

    public void atualizarProdutosASerVendidoEEstoqueDaVenda(ProdutoASerVendidoDTO produtoASerVendidoDTO) {

    }


    public void inserirUmPagamento(RelacaoVendaPagamentoDTO relacaoVendaPagamentoDTO) throws Exception {
        Pagamento pagamento = pagamentosDAO.pegarUmPagamento(relacaoVendaPagamentoDTO.getIdDoPagamento());
        Venda venda = vendasDAO.pegarUmaVenda(relacaoVendaPagamentoDTO.getIdDaVenda());
        venda.setPagamento(pagamento);
        List<RelacaoVendaProduto> listaRelacaoVendaProduto = venda.getRelacaoVendaProdutos();

        if (pagamento.getPrecoAPagar() >= listaRelacaoVendaProduto.parallelStream().map(p -> p.getProduto().getPreco()).reduce(0.0, Double::sum)) {
            vendasDAO.inserirUmPagamento(pagamento);
            notificadorDeVenda.enviarSms();
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

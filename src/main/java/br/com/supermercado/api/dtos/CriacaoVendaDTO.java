package br.com.supermercado.api.dtos;

import br.com.supermercado.api.models.Pagamento;
import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.models.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CriacaoVendaDTO {

    private String dataVenda;
    private Long idPessoaVenda;
    private List<Long> idListaProdutoVenda;

}

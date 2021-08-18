package br.com.supermercado.api.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CriacaoVendaDTO {

    private String dataVenda;
    private Long idPessoaVenda;
    private List<ProdutoASerVendidoDTO> listaDeProdutosASerVendido;

}

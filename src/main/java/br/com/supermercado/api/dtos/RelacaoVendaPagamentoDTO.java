package br.com.supermercado.api.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RelacaoVendaPagamentoDTO {

    private Long idDoPagamento;
    private Long idDaVenda;

}

package br.com.supermercado.api.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class CriacaoPagamentoDTO {

    private String dataPagamento;
    private Double precoAPagar;
    private ArrayList<Long> listaIdTipoPagamento;

}

package br.com.supermercado.api.models;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class RelacaoVendaProdutoId implements Serializable {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelacaoVendaProdutoId that = (RelacaoVendaProdutoId) o;
        return Objects.equals(venda, that.venda) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(venda, produto);
    }



    private Long venda;
    private Long produto;

}

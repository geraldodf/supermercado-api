package br.com.supermercado.api.recursos;


import br.com.supermercado.api.daos.PessoasDAO;
import br.com.supermercado.api.models.Pessoa;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
public class PessoasResourse {

    @Inject
    PessoasDAO pessoasDAO;

    @POST
    public Pessoa criarUmaPessoa(Pessoa pessoa){
        return pessoasDAO.adicionarUmaPessoa(pessoa);
    }

}

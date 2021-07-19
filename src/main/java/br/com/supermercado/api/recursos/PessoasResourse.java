package br.com.supermercado.api.recursos;


import br.com.supermercado.api.daos.PessoasDAO;
import br.com.supermercado.api.models.Pessoa;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
public class PessoasResourse {

    @Inject
    PessoasDAO pessoasDAO;

    @POST
    public Pessoa criarUmaPessoa(Pessoa pessoa){
        return pessoasDAO.adicionarUmaPessoa(pessoa);
    }

    @GET
    public ArrayList<Pessoa> pegarTodasPessoas(){
        return pessoasDAO.pegarTodasPessoas();
    }

    @GET
    public Pessoa pegarUmaPessoa(Long id){
        return pessoasDAO.pegarUmaPessoa(id);
    }
}

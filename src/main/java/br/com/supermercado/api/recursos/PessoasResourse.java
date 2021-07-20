package br.com.supermercado.api.recursos;


import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.services.PessoasService;
import br.com.supermercado.api.services.ProdutosService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
public class PessoasResourse {

    @Inject
    PessoasService pessoasServices;

    @POST
    public Pessoa criarUmaPessoa(Pessoa pessoa){
        return pessoasServices.adicionarUmaPessoa(pessoa);
    }
//
//    @GET
//    public ArrayList<Pessoa> pegarTodasPessoas(){
//        return pessoasDAO.pegarTodasPessoas();
//    }
//
//    @GET
//    public Pessoa pegarUmaPessoa(Long id){
//        return pessoasDAO.pegarUmaPessoa(id);
//    }

//    @PUT
    //public Pessoa AtualizarUmaPessoa (Long id){ return pessoasServices.}

    //@DELETE Pessoa excluirUmaPessoa (Long id){return pessoasServices.}
}

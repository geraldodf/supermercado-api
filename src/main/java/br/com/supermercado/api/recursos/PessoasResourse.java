package br.com.supermercado.api.recursos;


import br.com.supermercado.api.models.Pessoa;
import br.com.supermercado.api.services.PessoasService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
public class PessoasResourse {

    @Inject
    private PessoasService pessoasServices;

    @POST
    public Pessoa criarUmaPessoa(Pessoa pessoa) {
        return pessoasServices.adicionarUmaPessoa(pessoa);
    }

    @GET
    @Path("/query/nome-pessoa")
    public List<Pessoa> pesquisarPessoaPeloNome(@QueryParam("nome")String nome){
        return pessoasServices.pesquisarPessoaPeloNome(nome);
    }

    @GET
    @Path("/query/cpf-pessoa")
    public List<Pessoa> pesquisarPessoaPeloCpf(@QueryParam("cpf")Long cpf){
        return pessoasServices.pesquisarPessoaPeloCpf(cpf);
    }

    @GET
    public ArrayList<Pessoa> pegarTodasPessoas() {
        return pessoasServices.pegarTodasPessoas();
    }

    @GET
    @Path("/{id}")
    public Pessoa pegarUmaPessoa(@PathParam("id") Long id) {
        return  pessoasServices.pegarUmaPessoa(id);
    }

    @PUT
    @Path("/{id}")
    public void atualizarUmaPessoa(@PathParam("id") Long id, Pessoa pessoa) {
         pessoasServices.atualizarUmaPessoa(id, pessoa);
    }

    @DELETE
    @Path("/{id}")
    public void excluirUmaPessoa(@PathParam("id") Long id) {
         pessoasServices.excluirUmaPessoa(id);
    }
}

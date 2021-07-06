package br.com.supermercado.api.recursos;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/produtos")
public class ProdutosResource {
    @GET
    public String HelloWorld(){
        return "Hello World, Supermercado";
    }

}

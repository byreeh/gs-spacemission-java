package br.com.fiap.resource;

import br.com.fiap.entity.Veiculo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/veiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeiculoResoure {
    private static List<Veiculo> lista = new ArrayList<>();
    private static int contador = 1;

    @GET
    public List<Veiculo> listar() {
        return lista;
    }

    @POST
    public Response cadastrar(Veiculo veiculo) {
        veiculo.setId((long)contador++);
        lista.add(veiculo);
        return Response.status(201).entity(veiculo).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Veiculo veiculo) {
        for (Veiculo v : lista) {
            if (v.getId() == id) {
                v.setNome(veiculo.getNome());
                v.setTipo(veiculo.getTipo());
                v.setCapacidade(veiculo.getCapacidade());
                v.setStatus(veiculo.getStatus());
                return Response.ok(v).build();
            }
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        for (Veiculo v : lista) {
            if (v.getId() == id) {
                lista.remove(v);
                return Response.noContent().build();
            }
        }
        return Response.status(404).build();
    }
}

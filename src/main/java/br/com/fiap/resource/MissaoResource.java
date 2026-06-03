package br.com.fiap.resource;

import br.com.fiap.entity.Missao;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/missoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MissaoResource {

    static List<Missao> lista = new ArrayList<>();
    private static int contador = 1;

    @GET
    public List<Missao> listar() {
        return lista;
    }

    @POST
    public Response cadastrar(Missao missao) {
        missao.setId((long)contador++);
        lista.add(missao);
        return Response.status(201).entity(missao).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Missao missao) {
        for (Missao m : lista) {
            if (m.getId().equals(id)) {
                m.setNome(missao.getNome());
                m.setDestino(missao.getDestino());
                m.setDataLancamento(missao.getDataLancamento());
                m.setStatus(missao.getStatus());
                m.setOrcamento(missao.getOrcamento());

                return Response.ok(m).build();
            }
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        for (Missao m : lista) {
            if (m.getId() == id) {
                lista.remove(m);
                return Response.noContent().build();
            }
        }
        return Response.status(404).build();
    }
}

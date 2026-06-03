package br.com.fiap.resource;

import br.com.fiap.entity.Astronauta;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/astronautas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AstronautaResource {
    private static List<Astronauta> lista = new ArrayList<>();
    private static int contador = 1;

    @GET
    public List<Astronauta> listar() {
        return lista;
    }

    @POST
    public Response cadastrar(Astronauta astronauta) {
        astronauta.setId((long)contador++);
        lista.add(astronauta);
        return Response.status(201).entity(astronauta).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Astronauta astronauta) {
        for (Astronauta a : lista) {
            if (a.getId() == id) {
                a.setNome(astronauta.getNome());
                a.setNacionalidade(astronauta.getNacionalidade());
                a.setEspecialidade(astronauta.getEspecialidade());
                a.setStatus(astronauta.getStatus());
                return Response.ok(a).build();
            }
        }
        return Response.status(404).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        for (Astronauta a : lista) {
            if (a.getId() == id) {
                lista.remove(a);
                return Response.noContent().build();
            }
        }
        return Response.status(404).build();
    }
}

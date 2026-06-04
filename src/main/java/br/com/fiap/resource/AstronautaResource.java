package br.com.fiap.resource;

import br.com.fiap.BO.AstronautaBO;
import br.com.fiap.entity.Astronauta;
import br.com.fiap.excecoes.AstronautaException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/astronautas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AstronautaResource {

    @GET
    public Response listar() {
        try {
            AstronautaBO bo = new AstronautaBO();
            List<Astronauta> astronautas = bo.listar();
            return Response.ok(astronautas).build();
        } catch (AstronautaException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        try {
            AstronautaBO bo = new AstronautaBO();
            Astronauta astronauta = bo.buscarPorId(id);
            return Response.ok(astronauta).build();
        } catch (AstronautaException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Astronauta astronauta) {
        try {
            AstronautaBO bo = new AstronautaBO();
            bo.cadastrar(astronauta);
            return Response.status(201).entity(astronauta).build();
        } catch (AstronautaException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Astronauta astronauta) {
        try {
            astronauta.setId(id);
            AstronautaBO bo = new AstronautaBO();
            bo.atualizar(astronauta);
            return Response.ok(astronauta).build();
        } catch (AstronautaException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        try {
            AstronautaBO bo = new AstronautaBO();
            bo.deletar(id);
            return Response.noContent().build();
        } catch (AstronautaException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }
}

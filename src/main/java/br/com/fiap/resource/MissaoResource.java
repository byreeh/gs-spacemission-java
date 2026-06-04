package br.com.fiap.resource;

import br.com.fiap.BO.MissaoBO;
import br.com.fiap.entity.Missao;
import br.com.fiap.excecoes.MissaoException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/missoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MissaoResource {

    @GET
    public Response listar() {
        try {
            br.com.fiap.BO.MissaoBO bo = new MissaoBO();
            List<Missao> missoes = bo.listar();
            return Response.ok(missoes).build();
        } catch (MissaoException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        try {
            MissaoBO bo = new MissaoBO();
            Missao missao = bo.buscarPorId(id);
            return Response.ok(missao).build();
        } catch (MissaoException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Missao missao) {
        try {
            MissaoBO bo = new MissaoBO();
            bo.cadastrar(missao);
            return Response.status(201).entity(missao).build();
        } catch (MissaoException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Missao missao) {
        try {
            missao.setId(id);
            MissaoBO bo = new MissaoBO();
            bo.atualizar(missao);
            return Response.ok(missao).build();
        } catch (MissaoException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        try {
            MissaoBO bo = new MissaoBO();
            bo.deletar(id);
            return Response.noContent().build();
        } catch (MissaoException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }
}

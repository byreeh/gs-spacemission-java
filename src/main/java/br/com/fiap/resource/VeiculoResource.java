package br.com.fiap.resource;

import br.com.fiap.BO.VeiculoBO;
import br.com.fiap.entity.Veiculo;
import br.com.fiap.excecoes.VeiculoException;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/veiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeiculoResource {

    @GET
    public Response listar() {
        try {
            VeiculoBO bo = new VeiculoBO();
            List<Veiculo> veiculos = bo.listar();
            return Response.ok(veiculos).build();
        } catch (VeiculoException e) {
            return Response.status(500).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        try {
            VeiculoBO bo = new VeiculoBO();
            Veiculo veiculo = bo.buscarPorId(id);
            return Response.ok(veiculo).build();
        } catch (VeiculoException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }

    @POST
    public Response cadastrar(Veiculo veiculo) {
        try {
            VeiculoBO bo = new VeiculoBO();
            bo.cadastrar(veiculo);
            return Response.status(201).entity(veiculo).build();
        } catch (VeiculoException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, Veiculo veiculo) {
        try {
            veiculo.setId(id);
            VeiculoBO bo = new VeiculoBO();
            bo.atualizar(veiculo);
            return Response.ok(veiculo).build();
        } catch (VeiculoException e) {
            return Response.status(400).entity(e.getMessage()).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        try {
            VeiculoBO bo = new VeiculoBO();
            bo.deletar(id);
            return Response.noContent().build();
        } catch (VeiculoException e) {
            return Response.status(404).entity(e.getMessage()).build();
        }
    }
}

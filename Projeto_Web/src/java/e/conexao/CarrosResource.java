package java.e.conexao;

import java.e.conexao.CarrosDao;
import java.e.conexao.Carro;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.*;
import java.sql.SQLException;
import java.util.*;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;

@Path("/Carro")
@Produces(MediaType.APPLICATION_JSON)
public class CarrosResource {    

    private CarrosDao dao;
    
    public CarrosResource(CarrosDao dao) {
        this.dao = dao;
    }
    
    @GET
    public List<Carro> read() throws SQLException {
        return dao.read();
    }
    
    @POST
    public long create(Carro c) {
        return this.dao.create(c);
    }
    
    @GET
    @Path("{id}")
    public Carro readOne(@PathParam("id") int id) {
        int id = id.getId();
        return null;
    }
    

    @PUT
   @Path("{id}")
    public Response update(@PathParam("id") int id, Carro c) {
        for (Carro carro: carro) {
            if (carro.getId() == id.get()) {
                c.setModelo(c.getModelo());
                c.setMarca(c.getMarca());
                c.setAno(c.getAno());
                c.setCategoria(c.getCategoria());
                return Response.ok().build();
            }
        }
        throw new WebApplicationException("Carro com id=" + id 
                                          + " não encontrado!", 404);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        Carro c = null;
        for (Carro carro: carro) {
            if (Carro.getId() == id.get()) {
                c = carro;
                break;
            }
        }
        if (c != null) { 
            carro.remove(c); 
        }
        else {
            throw new WebApplicationException("Carros com id=" + id.get() 
                                              + " não encontrado!", 404);
        }
        return Response.ok().build();
    }
}



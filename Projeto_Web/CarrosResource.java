package Projeto;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import io.dropwizard.jersey.params.LongParam;
import java.awt.PageAttributes.MediaType;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.*;
import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.xml.ws.Response;

/**
 *
 * @author welke
 */
@Path("/carros")
@Produces(MediaType.APPLICATION_JSON)
public class CarrosResource {    

    private final CarrosDao dao;
    private Object MediaType;
    
    public CarrosResource(CarrosDao dao) {
        this.dao = dao;
    }
    
    @GET
    public List<Carro> read() throws SQLException {
        return dao.lerTodos();
    }
    
    @POST
    public Carro create(Carro c) {
        return this.dao.criar(c);
    }
    
    @GET
    @Path("{id}")
    public Carro readOne(@PathParam("id") LongParam id) {
        List<Carro> carros = dao.lerTodos();
        for(Carro c : carros) {
            if(c.getId() == id.get())
                return c;
        }
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    

   @PUT
   @Path("{id}")
    public Response update(@PathParam("id") LongParam id, Carro c) {
        c.setId(id.get());
        if (dao.apagar(id.get())){
            return Response.ok().build();
        }
        
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") LongParam id) {
        if (dao.apagar(id.get())) {
            return Response.ok().build();
        }
        
        throw new WebApplicationException(Response.Status.NOT_FOUND);
    }

    private static class MediaType {

        public MediaType() {
        }
    }
}



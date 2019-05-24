/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import java.nio.file.Path;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.*;
import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

/**
 *
 *  Welker e Kelly
 */

@Path("/jogo")
@Produces(MediaType.APPLICATION_JSON)
public class JogoResource {

    private JogoDAO dao;
    private Object MediaType;
    private Object MediaType;
    private Object MediaType;

    public JogoResource(JogoDAO dao) {
        this.dao = dao;
    }

    @GET
    public List<Jogo> read() {
        return dao.read();
    }

    @POST
    public Jogo create(Jogo a) {
        return this.dao.create(a);
    }

    private static class MediaType {

        public MediaType() {
        }
    }

    private static class MediaType {

        public MediaType() {
        }
    }
    
  }
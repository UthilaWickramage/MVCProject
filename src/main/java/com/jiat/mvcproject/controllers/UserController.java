package com.jiat.mvcproject.controllers;

import com.jiat.mvcproject.annotations.IsUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.glassfish.jersey.server.mvc.Viewable;
@IsUser
@Path("/user")
public class UserController {
    @GET
    @Path("/{id}")
    public String get(@PathParam("id") Long id){
        System.out.println(id);
        return id.toString();

    }
}

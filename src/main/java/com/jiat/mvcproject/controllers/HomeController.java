package com.jiat.mvcproject.controllers;

import com.jiat.mvcproject.annotations.IsUser;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@IsUser
@Path("/home")
public class HomeController {
    @GET
    public String get(){
        return "Home";
    }
}

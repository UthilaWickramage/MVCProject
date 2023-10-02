package com.jiat.mvcproject.controllers;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/cart")
public class CartController {
    //this method is will be called if container recieves a request to this url with a GET method.
    @GET
    //need to use public modifier as servlet container will use this from outside the package.
    //must have a return type to add to the response. if no return type is given then response will go without a content.
    //204 no content
    public String get(){
        return "<button>Add to Cart</button>";
    }
}

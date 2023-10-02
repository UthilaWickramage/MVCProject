package com.jiat.mvcproject.controllers;

import com.jiat.mvcproject.annotations.IsUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.server.mvc.Viewable;

import java.util.HashMap;
import java.util.Map;


@Path("/login")
public class LoginController {
    @GET
    //what kind of return is, add response headers with this
    @Produces(MediaType.TEXT_HTML)
    //return type viewable means that we are returning a view from this method.
    public Viewable get() {
        Map<String, Object> model = new HashMap<>();
        model.put("name", "Uthila");
        model.put("age", 20);
        model.put("city", "Maharagama");
        //template name refers to the jsp that has the corresponding view.
        //we can send whatever we add to the viewable as the 2nd parameter to our viewable object
        return new Viewable("/login_index", model);
    }

    @POST
    //this method can be used to take values from request url
    //public String LoginAction(@QueryParam("name") String a, @QueryParam("address") String b, @QueryParam("age") String c) {
    //this method can be used to take values from request body(form submission)
    //public String LoginAction(@FormParam("name") String a, @FormParam("address") String b, @FormParam("age") String c) {
    //this method can be used to take values from the request headers, and take cookie params
    //public String LoginAction(@CookieParam("name") String a, @HeaderParam("address") String b, @FormParam("age") String c) {
    //can use existing request and response objects

    //takes form parameters
    public Response LoginAction(@FormParam("name") String username, @FormParam("password") String password,
    @Context HttpServletRequest request) {
//        request.getCookies();
//        return request.getParameter("name");

        if (username.equals("uthila@gmail.com") && password.equals("1234")) {
            request.getSession().setAttribute("user",username);
            //return Response.temporaryRedirect(UriBuilder.fromUri("home").build()).build();
            return Response.status(Response.Status.FOUND).location(UriBuilder.fromUri("home").build()).build();
        } else {
            //if we use this method won't be changed so the post method will be called again
            //and again so it will keep redirecting. browser will stop it eventually. this is happens for 307
            //if it is success code then browser will request to a whole different url.
            //return Response.temporaryRedirect(UriBuilder.fromUri("login").build()).build();
            return Response.status(Response.Status.FOUND).location(UriBuilder.fromUri("login").build()).build();
            //we can use this instead of temporary redirect. in this method the next redirection will be a GET request
            //so for example, we only need a GET method in the /home if we use that
        }

    }

}

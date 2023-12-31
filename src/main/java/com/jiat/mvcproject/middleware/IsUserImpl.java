package com.jiat.mvcproject.middleware;

import com.jiat.mvcproject.annotations.IsUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.PreMatching;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.glassfish.jersey.server.mvc.Viewable;

import java.io.IOException;

//this annotation means this class is a provider for the jersey
@Provider
//execute this before every request.
//@PreMatching
//this is where all the work is about isUser annotation
@IsUser
public class IsUserImpl implements ContainerRequestFilter {
    //dependency injection. We take existing request and response object
    @Context HttpServletRequest request;
    @Context HttpServletResponse response;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        HttpSession session = request.getSession();
        //check whether existing session has such an attribute.
        if(session.getAttribute("user")==null){
            System.out.println("No Login detected");
            containerRequestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(new Viewable("/404")).build());
        }

    }
}

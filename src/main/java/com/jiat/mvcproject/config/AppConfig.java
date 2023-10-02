package com.jiat.mvcproject.config;

import jakarta.ws.rs.Path;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.jsp.JspMvcFeature;


public class AppConfig extends ResourceConfig {
    //go and execute the constructor chain and comeback to the overridden constructor.
    public AppConfig(){
        //this is how we say which package holds the controller and middleware classes.
        packages("com.jiat.mvcproject.controllers");
        packages("com.jiat.mvcproject.middleware");
        //registering the feature class that offers various features for jsp mvc
        register(JspMvcFeature.class);
        //we put our views in to WEB-INF folder. in default container will look for
        //views in the webapp as the root. so we have to say where is the views using property give path from the root web app.
        property(JspMvcFeature.TEMPLATE_BASE_PATH,"/WEB-INF/views");
    }
}

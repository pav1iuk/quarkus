package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;
@Path("/hello")
public class GreetingResource {
    @GET
    @Path("/whoami")
    @Produces(MediaType.TEXT_PLAIN)
    public String whoAmI(@Context SecurityContext securityContext) {
        Principal userPrincipal = securityContext.getUserPrincipal();
        if (userPrincipal != null) {
            return userPrincipal.getName();
        } else {
            return "anonymous";
        }
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
}


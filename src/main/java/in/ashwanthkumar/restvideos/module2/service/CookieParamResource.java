package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

@Path("/cookie")
@Produces(MediaType.APPLICATION_JSON)
public class CookieParamResource {

    @GET
    @Path("/foo")
    public String foo(@CookieParam("Foo") String foo) {
        return foo;
    }

    @GET
    @Path("/any/{name}")
    public Cookie any(@Context HttpHeaders headers, @PathParam("name") String cookieName) {
        return headers.getCookies().get(cookieName);
    }
}

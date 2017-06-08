package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/path/scope/{id}")
public class ScopeOfPathParam {

    @GET
    @Path("/{id}")
    public String scopeOfParam(@PathParam("id") String id) {
        return id;
    }
}

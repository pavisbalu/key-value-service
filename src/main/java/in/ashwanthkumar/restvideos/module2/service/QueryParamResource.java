package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/query")
@Produces(MediaType.APPLICATION_JSON)
public class QueryParamResource {

    @GET
    public String q(@QueryParam("q") String q) {
        return q;
    }

    @GET
    @Path("/uri")
    public MultivaluedMap<String, String> uriInfo(@Context UriInfo uri) {
        return uri.getQueryParameters();
    }
}

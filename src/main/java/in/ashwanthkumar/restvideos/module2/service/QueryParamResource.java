package in.ashwanthkumar.restvideos.module2.service;

import in.ashwanthkumar.restvideos.module2.color.Color;

import javax.ws.rs.*;
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

    @GET
    @Path("/color")
    public String colorParamConverter(@QueryParam("c") Color color) {
        return color.getValue();
    }
}

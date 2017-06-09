package in.ashwanthkumar.restvideos.module2.service;

import in.ashwanthkumar.restvideos.module2.ColorEnum;
import in.ashwanthkumar.restvideos.module2.color.Color;

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

    @GET
    @Path("/color")
    public String colorParamConverter(@QueryParam("c") Color color) {
        return color.getValue();
    }

    @GET
    @Path("/color/enum")
    public ColorEnum colorEnum(@QueryParam("c") ColorEnum color) {
        return color;
    }
}

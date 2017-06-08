package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/header")
@Produces(MediaType.APPLICATION_JSON)
public class HeaderParamResource {


    public static final String CUSTOM_HEADER_NAME = "X-Custom-Header";

    @GET
    public String simple(@HeaderParam(CUSTOM_HEADER_NAME) String header) {
        return header;
    }

    @GET
    @Path("/all")
    public MultivaluedMap<String, String> context(@Context HttpHeaders headers) {
        return headers.getRequestHeaders();
    }
}

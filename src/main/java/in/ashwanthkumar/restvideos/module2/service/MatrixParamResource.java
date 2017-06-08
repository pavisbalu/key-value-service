package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/matrix")
@Produces(MediaType.APPLICATION_JSON)
public class MatrixParamResource {

    @GET
    @Path("/{model}")
    public String matrixParam(@MatrixParam("model") String model) {
        return model;
    }
}

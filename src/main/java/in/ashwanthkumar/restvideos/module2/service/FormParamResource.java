package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URL;

@Path("/form")
@Produces(MediaType.APPLICATION_JSON)
public class FormParamResource {

    @POST
    public String simple(@FormParam("name") String name, @FormParam("website") URL website) {
        return "Hello " + name + "(" + website.toExternalForm() + ")";
    }
}

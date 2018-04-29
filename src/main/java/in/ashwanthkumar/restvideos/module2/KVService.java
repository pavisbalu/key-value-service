package in.ashwanthkumar.restvideos.module2;

import in.ashwanthkumar.restvideos.module2.inMemory.Store;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/map")
@Produces(MediaType.APPLICATION_JSON)
public class KVService {

    private Store store = new Store();

    private static class setValue {
        public String key;
        public String value;
    }

    @POST
    @Path("/set")
    public String setMap(setValue req) {
        store.setStoreValue(req.key, req.value);
        return "Ok";
    }

    @GET
    @Path("/get")
    public Response getMap(@QueryParam("key") String key){
        String value = store.getStoreValue(key);
        if(value == null) {
            return Response.status(NOT_FOUND).build();
        } else {
            return Response.ok(value).build();
        }
    }


}

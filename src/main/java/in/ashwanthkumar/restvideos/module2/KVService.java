package in.ashwanthkumar.restvideos.module2;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import in.ashwanthkumar.restvideos.module2.inMemory.Store;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Path("/map")
@Produces(MediaType.APPLICATION_JSON)
public class KVService {

    private Store store = new Store();
    private ServiceConfiguration serviceConfiguration;

    public KVService(ServiceConfiguration serviceConfiguration) {
        this.serviceConfiguration = serviceConfiguration;
    }

    private static class setValue {
        public String key;
        public String value;
    }

    @POST
    @Path("/set")
    public String setMap(setValue req) throws UnirestException {
        store.setStoreValue(req.key, req.value);
        return Unirest
                .post("http://localhost:" + serviceConfiguration.getNeighbourPort() + "/application/map/add")
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body(req)
                .asString()
                .getBody();
    }

    @GET
    @Path("/get")
    public Response getMap(@QueryParam("key") String key) {
        String value = store.getStoreValue(key);
        if (value == null) {
            return Response.status(NOT_FOUND).build();
        } else {
            return Response.ok(value).build();
        }
    }

    @POST
    @Path("/add")
    public String addInNeigbour(setValue req) {
        store.setStoreValue(req.key, req.value);
        return "Ok";
    }

}

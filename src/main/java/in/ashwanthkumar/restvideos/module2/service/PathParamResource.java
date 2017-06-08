package in.ashwanthkumar.restvideos.module2.service;

import in.ashwanthkumar.utils.collections.Lists;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.util.List;

@Path("/path")
@Produces(MediaType.APPLICATION_JSON)
public class PathParamResource {

    @GET
    @Path("/foo")
    public String simple() {
        return "/path/foo";
    }

    @GET
    @Path("/more/{first}-{last}")
    public String moreThanOneParam(@PathParam("first") String first,
                                   @PathParam("last") String last) {
        return String.format("/path/%s-%s", first, last);
    }

    @GET
    @Path("/segment/{model}")
    public MultivaluedMap<String, String> pathSegment(@PathParam("model") PathSegment segment) {
        return segment.getMatrixParameters();
    }

    @GET
    @Path("/segments/{models : .+}")
    public List<MultivaluedMap<String, String>> multiplePathSegments(@PathParam("models") List<PathSegment> segments) {
        return Lists.map(segments, PathSegment::getMatrixParameters);
    }

    @GET
    @Path("/uri")
    public String uriInfo(@Context UriInfo uri) {
        return uri.getPath();
    }
}

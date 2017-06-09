package in.ashwanthkumar.restvideos.module2.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/bean")
@Produces(MediaType.APPLICATION_JSON)
public class BeanParamResource {
    private static class Bean {
        @QueryParam("q")
        @Encoded
        @DefaultValue("default-value")
        private String q;

        @HeaderParam("X-Custom-Header")
        private String header;

        public String getQ() {
            return q;
        }

        public Bean setQ(String q) {
            this.q = q;
            return this;
        }

        public String getHeader() {
            return header;
        }

        public Bean setHeader(String header) {
            this.header = header;
            return this;
        }
    }


    @GET
    public String beanInfo(@BeanParam Bean bean) {
        return bean.getQ() + " -- " + bean.getHeader();
    }
}

package in.ashwanthkumar.restvideos.module2;

import in.ashwanthkumar.restvideos.module2.service.*;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class Module2 extends Application<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new Module2().run(args);
    }

    @Override
    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new PathParamResource());
        environment.jersey().register(new ScopeOfPathParam());
        environment.jersey().register(new MatrixParamResource());
        environment.jersey().register(new QueryParamResource());
        environment.jersey().register(new HeaderParamResource());
        environment.jersey().register(new FormParamResource());
        environment.jersey().register(new CookieParamResource());
    }
}

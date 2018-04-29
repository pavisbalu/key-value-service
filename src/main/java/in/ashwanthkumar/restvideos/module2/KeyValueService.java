package in.ashwanthkumar.restvideos.module2;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class KeyValueService extends Application<ServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new KeyValueService().run(args);
    }

    @Override
    public void run(ServiceConfiguration serviceConfiguration, Environment environment) throws Exception {
        environment.jersey().register(new KVService());
    }
}

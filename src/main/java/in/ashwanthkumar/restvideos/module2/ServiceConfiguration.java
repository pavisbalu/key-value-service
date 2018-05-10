package in.ashwanthkumar.restvideos.module2;


import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class ServiceConfiguration extends Configuration {
    @NotEmpty
    private String neighbourPort;

    public String getNeighbourPort() {
        return neighbourPort;
    }
}

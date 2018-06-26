package myrestapi.application;

import org.osgi.service.component.annotations.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.Set;

/**
 * @author rafael.wolf
 * Request - http://localhost:8080/o/myRestApi/greetings/
 */
@ApplicationPath("/greetings")
@Consumes(MediaType.APPLICATION_JSON)
@Component(immediate = true, service = Application.class)
public class MyRestApiApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    @GET
    @Produces("text/plain")
    public String working() {
        return "It works!";
    }

    @GET
    @Path("/morning")
    @Produces("text/plain")
    public String hello() {
        return "Good morning!";
    }

    @GET
    @Path("/morning/{name}")
    @Produces("text/plain")
    public String morning(
            @PathParam("name") String name,
            @QueryParam("drink") String drink) {

        String greeting = "Good Morning " + name;

        if (drink != null) {
            greeting += ". Would you like some " + drink + "?";
        }

        return greeting;
    }

    @POST
    @Path("/json-test")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public TestEntity jsonTest(TestEntity entity) {

        entity.setName(entity.getName() + "- rest api");

        return entity;
    }

    @GET
    @Path("/test")
    public String test() {
        return "testando método rest api!!!";
    }

}
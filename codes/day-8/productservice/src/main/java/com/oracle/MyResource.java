package com.oracle;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    @Inject
    private RepositoryContract repository;
    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("welcome")
    @Produces(MediaType.TEXT_PLAIN)
    public String getMessage() {
        return "welcome to JAX-RS";
    }

    @GET
    @Path("people/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getData(@PathParam("name") String name) {
        return repository.getPerson(name);
    }

    @GET
    @Path("people")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        return repository.getPeople();
    }
}

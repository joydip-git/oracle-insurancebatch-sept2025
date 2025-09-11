package com.oracle.productapiservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.process.internal.RequestScoped;

import jakarta.ws.rs.ApplicationPath;
//import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	private static List<Person> people;
	
	public MyResource() {
		people  = new ArrayList<Person>();
		System.out.println("created");
	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Path("welcome/{fname}/{lname}") // name -> path parameter
	@Produces("text/plain")
	// @Produces(MediaType.TEXT_PLAIN)
	public String getName(@PathParam("fname") String fName, @PathParam("lname") String lName) {
		return " welcome " + fName + " " + lName;
	}

	@GET
	@Path("hi")
	// @Produces("text/plain")
	@Produces(MediaType.TEXT_PLAIN)
	public String get(@QueryParam("fname") String fName, @QueryParam("lname") String lName) {
		return "hi " + fName + " " + lName;
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {
		if (!people.isEmpty()) {
			if (people.stream().anyMatch((p) -> p.getId() == person.getId())) {				
				//throw new BadRequestException("a person with " + person.getId() + " already exists");
				return Response.notModified("a person with " + person.getId() + " already exists").build();
			}
		}

		people.add(person);
		return Response.ok(person).build();
	}

}

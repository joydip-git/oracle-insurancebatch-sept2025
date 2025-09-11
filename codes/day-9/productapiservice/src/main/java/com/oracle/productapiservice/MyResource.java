package com.oracle.productapiservice;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.glassfish.jersey.process.internal.RequestScoped;

//import org.glassfish.jersey.process.internal.RequestScoped;

import jakarta.inject.Singleton;

//import org.glassfish.jersey.process.internal.RequestScoped;

//import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
@Singleton
//@RequestScoped
public class MyResource {

	private static List<Person> people;

	public MyResource() {
		people = new ArrayList<Person>();
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

//	@POST
//	@Path("add")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Person addPerson(Person person) {
//		if (!people.isEmpty()) {
//			
//			Predicate<Person> isPresent = (p)->p.getId() == person.getId();
//			//Returns whether any elements of this stream match the provided predicate. May not evaluate the predicate on all elements if not necessary for determining the result. If the stream is empty then false is returned and the predicate is not evaluated.
//			if (people.stream().anyMatch(isPresent)) {				
//				throw new BadRequestException("a person with " + person.getId() + " already exists");
//				//return Response.notModified("a person with " + person.getId() + " already exists").build();
//			}
//		}
//
//		people.add(person);
//		return person;
//		//return Response.ok(person).build();
//	}

//	@POST
//	@Path("add")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public MyResourceResponse<Person> addPerson(Person person) {
//		try {
//			if (!people.isEmpty()) {
//
//				Predicate<Person> isPresent = (p) -> p.getId() == person.getId();
//				if (people.stream().anyMatch(isPresent)) {
//					return new MyResourceResponse<Person>("person with id: " + person.getId() + " exists", 400, null);
//				}
//			}
//			people.add(person);
//			return new MyResourceResponse<Person>("person added successfully", 200, person);
//		} catch (Exception e) {
//			return new MyResourceResponse<Person>(e.getMessage(), 500, null);
//		}
//	}

	@POST
	@Path("people/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {
		try {
			if (!people.isEmpty()) {

				Predicate<Person> isPresent = (p) -> p.getId() == person.getId();
				if (people.stream().anyMatch(isPresent)) {
					return Response.status(400).entity("person with id: " + person.getId() + " exists").build();
				}
			}
			people.add(person);
			return Response.created(new URI("myresource/addPerson")).entity(person).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

//	@Path("people")
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Person> getAll() {
//		return people;
//	}

	@Path("people/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAll() {
		return people.isEmpty() ? Response.noContent().entity("no records found").build() : Response.ok(people).build();
	}

	@DELETE
	@Path("people/delete/{id}")
	@Produces("application/json")
	public Response delete(@PathParam("id") int personId) {
		if (people.isEmpty())
			return Response.noContent().entity("list is empty").build();
		else {
			if (!people.stream().anyMatch(p -> p.getId() == personId))
				return Response.noContent().entity("person with id " + personId + " does not exist").build();
			else {
				Optional<Person> found = people.stream().filter(p -> p.getId() == personId).findFirst();
				boolean status = people.remove(found.get());
				return status ? Response.ok(found).build() : Response.notModified().entity("could not delete").build();
			}
		}
	}
	
	@PUT
	@Path("people/edit")
	@Produces("application/json")
	@Consumes("application/json")
	public Response update(@QueryParam("id") int personId,Person updated) {
		if (people.isEmpty())
			return Response.noContent().entity("list is empty").build();
		else {
			if (!people.stream().anyMatch(p -> p.getId() == personId))
				return Response.noContent().entity("person with id " + personId + " does not exist").build();
			else {
				Optional<Person> found = people.stream().filter(p -> p.getId() == personId).findFirst();
				Person p = found.get();
				p.setName(updated.getName());
				return Response.ok(found).build();
			}
		}
	}
}

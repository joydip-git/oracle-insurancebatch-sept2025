package com.oracle.productapiservice;

import java.net.URI;
import java.util.List;

//import jakarta.inject.Inject;
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

@Path("people")
public class PeopleResource {

	private static final Repository<Person> repository = new PeopleRepository();
	// private Repository<Person> repository;

//	@Inject
//	public PeopleResource(Repository<Person> repository) {
//		this.repository = repository;
//		System.out.println("people resource created");
//	}

	public PeopleResource() {
		System.out.println("people resource created");
	}

	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPerson(Person person) {
		try {
			Person p = repository.insert(person);
			return Response.created(new URI("myresource/addPerson")).entity(p).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@DELETE
	@Path("delete/{id}")
	@Produces("application/json")
	public Response deletePerson(@PathParam("id") int personId) {
		try {
			Person p = repository.remove(personId);
			return p == null ? Response.notModified().entity("could not delete").build() : Response.ok(p).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPeople() {
		try {
			List<Person> records = repository.fetchAll();
			return Response.ok(records).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@Path("view/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPerson(@PathParam("id") int personId) {
		try {
			Person found = repository.fetch(personId);
			return Response.ok(found).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	@PUT
	@Path("edit")
	@Produces("application/json")
	@Consumes("application/json")
	public Response updatePerson(@QueryParam("id") int personId, Person updated) {
		try {
			Person p = repository.modify(personId, updated);
			return Response.ok(p).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}

package com.oracle.productapiservice;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;


@Path("myresource")
public class MyResource {

	public MyResource() {
		System.out.println("created");
	}
	
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
}

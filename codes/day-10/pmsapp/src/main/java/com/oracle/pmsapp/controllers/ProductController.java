package com.oracle.pmsapp.controllers;

import com.oracle.pmsapp.models.ProductModel;
import com.oracle.pmsapp.services.Manager;

import jakarta.inject.Inject;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("products")
public class ProductController {

	@Inject
	private Manager<ProductModel, Integer> manager;

	public Response addProduct(ProductModel data) {
		return null;
	}

	public Response deleteProduct(@PathParam("id") int id) {
		return null;
	}

	public Response getProduct(@QueryParam("id") int id) {
		return null;
	}

	public Response getProducts() {
		return null;
	}

	public Response updateProduct(@PathParam("id") int id, ProductModel data) {
		return null;
	}
}

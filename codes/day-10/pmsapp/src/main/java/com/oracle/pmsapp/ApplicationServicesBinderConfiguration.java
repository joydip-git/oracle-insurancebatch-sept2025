package com.oracle.pmsapp;

import org.glassfish.hk2.api.TypeLiteral;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.oracle.pmsapp.models.ProductModel;
import com.oracle.pmsapp.repository.ProductRepository;
import com.oracle.pmsapp.repository.RepositoryContract;
import com.oracle.pmsapp.services.Manager;
import com.oracle.pmsapp.services.ProductManager;

//import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApplicationServicesBinderConfiguration extends AbstractBinder {

	@Override
	protected void configure() {
		// if Manager interface is non generic
		// bind(ProductManager.class).to(Manager.class);

		this.bind(ProductManager.class).to(new TypeLiteral<Manager<ProductModel, Integer>>() {
		});
		// .in(Singleton.class);

		this.bind(ProductRepository.class).to(new TypeLiteral<RepositoryContract<ProductModel, Integer>>() {
		});
		// .in(jakarta.inject.Singleton.class);
	}
}

//class ManagerType extends TypeLiteral<Manager<ProductModel, Integer>> {
//}

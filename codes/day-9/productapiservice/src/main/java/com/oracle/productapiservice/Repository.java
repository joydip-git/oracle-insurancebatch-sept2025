package com.oracle.productapiservice;

import java.util.List;

//import org.jvnet.hk2.annotations.Contract;

//@Contract
public interface Repository<T> {
	T fetch(int id) throws Exception;
	List<T> fetchAll() throws Exception;
	T insert(T data) throws Exception;
	T remove(int id) throws Exception;
	T modify(int id, T data) throws Exception;
}

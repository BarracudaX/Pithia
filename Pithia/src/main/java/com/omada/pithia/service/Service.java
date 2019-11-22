package com.omada.pithia.service;

import java.util.List;

public interface Service<T,ID> {

	void save(T t);

	T find(ID id);

	void delete(T t);

	List<T> findAll();

	T update(T t);
}

package com.gapinc.booking.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BaseService<T, ID extends Serializable> {

	@PersistenceContext
	protected EntityManager em;

	@Transactional
	public T save(T entity) {
		em.persist(entity);
		return entity;
	}

	public void delete(T entity) {
		em.remove(entity);
	}

	public T findOne(ID id) {
		@SuppressWarnings("unchecked")
		Class<T> c = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		return em.find(c, id);
	}

}

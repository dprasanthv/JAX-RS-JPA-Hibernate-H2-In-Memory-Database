package com.menu.rest.config;

import java.util.HashSet;
import java.util.Set;

import com.menu.rest.Dao.ItemDaoImpl;

import com.menu.rest.service.ItemController;

public class ApplicationConfig extends javax.ws.rs.core.Application {

	public java.util.Set<java.lang.Object> getSingletons() {
		Set<Object> s = new HashSet<>();
		s.add(new ItemController(new ItemDaoImpl()));
		return s;

	}

}
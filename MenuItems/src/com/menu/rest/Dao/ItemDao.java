package com.menu.rest.Dao;

import java.util.List;

import com.menu.rest.model.Item;

public interface ItemDao {

	List<Item> findAll();

	Boolean save(Item item);

}

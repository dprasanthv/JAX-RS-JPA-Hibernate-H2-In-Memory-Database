package com.menu.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.menu.rest.Dao.ItemDao;
import com.menu.rest.model.Item;

@Path("/item")
public class ItemController {

	private ItemDao itemDao;

	public ItemController(ItemDao i) {
		itemDao = i;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllItem() {
		return Response.status(200).entity(itemDao.findAll()).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveItem(Item item) {
		itemDao.save(item);
		return Response.status(200).entity("Item saved").build();
	}

}
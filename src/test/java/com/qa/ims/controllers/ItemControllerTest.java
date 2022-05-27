package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private ItemDAO dao;

	@InjectMocks
	private ItemController controller;
	
	//Testing the create item method
	@Test
	public void testCreate() {
		final String itemName = "Apple";
		final float price = 0.25f;
		final int stock = 50;
		final Item created = new Item(itemName, price, stock);

		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getFloat()).thenReturn(price);
		Mockito.when(utils.getInt()).thenReturn(stock);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getFloat();
		Mockito.verify(utils, Mockito.times(1)).getInt();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
	
	//Testing the readAll method
	@Test
	public void testReadAll() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("Apple", 0.25f, 50));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}
	
	
	//Testing the update item method
	@Test
	public void testUpdate() {
		Item updated = new Item(1L, "Apple", 0.25f, 50);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(updated.getItemName());
		Mockito.when(this.utils.getFloat()).thenReturn(updated.getPrice());
		Mockito.when(this.utils.getInt()).thenReturn(updated.getStock());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getFloat();
		Mockito.verify(this.utils, Mockito.times(1)).getInt();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	
	}
	
	//Testing the delete item method
	@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}

}

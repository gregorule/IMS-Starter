package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	//Fields
	private ItemDAO itemDAO;
	private Utils utils;
	
	//Constructors
	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	//for the user to read the item table
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for(Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	//for user to create an item
	@Override
	public Item create() {
		LOGGER.info("Please enter the item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price");
		Float price = utils.getFloat();
		LOGGER.info("Please enter how many are in stock");
		int stock = utils.getInt();
		Item item = itemDAO.create(new Item(itemName, price, stock));
		LOGGER.info("Item created");
		return item;
	}

	//for the user to update an order
	@Override
	public Item update() {
		LOGGER.info("Please enter the item id of the item you would like to update");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter the price");
		Float price = utils.getFloat();
		LOGGER.info("Please enter how many are in stock");
		int stock = utils.getInt();
		Item item = itemDAO.update(new Item(itemId, itemName, price, stock));
		LOGGER.info("Item updated");
		return item;
	}

	//for the user to delete an item
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long itemId = utils.getLong();
		return itemDAO.delete(itemId);
	}
	
	
	

}

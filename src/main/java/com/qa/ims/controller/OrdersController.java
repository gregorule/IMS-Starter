package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.LinkDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	//Fields
	private OrdersDAO ordersDAO;
	private Utils utils;
	private ItemDAO itemDAO;
	private LinkDAO linkDAO;
	
	//Constructors
	public OrdersController(OrdersDAO ordersDAO, Utils utils, ItemDAO itemDAO, LinkDAO linkDAO) {
		this.ordersDAO = ordersDAO;
		this.utils = utils;
		this.itemDAO = itemDAO;
		this.linkDAO = linkDAO;
	}

	//for the user to read the order_details table
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for(Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	//for the user to create an order
	@Override
	public Orders create() {
		Long custId = null;
        Orders order = null;
        while (order == null) {
        	LOGGER.info("Please enter a customer ID");
        	custId = utils.getLong(); 	
        	if(linkDAO == null) {
        		if(custId == -1) {
        			break;
        		}
        		if(custId == null) {
        			LOGGER.info("Please enter an existing customer ID");
        			continue;
        		}
        	}
		LOGGER.info("Please enter the item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		LOGGER.info("Please enter the status of this order");
		String orderStat = utils.getString();
		Orders orders = ordersDAO.create(new Orders(custId, itemId, quantity, orderStat));
		LOGGER.info("Item created");
		return orders;
        }
		return order;
	}

	//for the user to update an order
	@Override
	public Orders update() {
		LOGGER.info("Please enter the order ID");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter a customer ID");
		Long custId = utils.getLong();
		LOGGER.info("Please enter an item ID");
		Long itemId = utils.getLong();
		LOGGER.info("Please enter the quantity");
		int quantity = utils.getInt();
		LOGGER.info("Please enter the status of this order");
		String orderStat = utils.getString();
		Orders orders = ordersDAO.update(new Orders(orderId, custId, itemId, quantity, orderStat));
		LOGGER.info("Item updated");
		return orders;
	}

	//for the user to delete an order
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long detailsId = utils.getLong();
		return ordersDAO.delete(detailsId);
	}
	
	

}

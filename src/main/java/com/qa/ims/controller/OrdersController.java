package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	//Fields
	private OrdersDAO ordersDAO;
	private Utils utils;
	
	//Constructors
	public OrdersController(OrdersDAO ordersDAO, Utils utils) {
		this.ordersDAO = ordersDAO;
		this.utils = utils;
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
		LOGGER.info("Please enter the order ID");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the customer ID");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter a list of what was bought");
		String orderDesc = utils.getString();
		LOGGER.info("Please enter the status of this order");
		String orderStat = utils.getString();
		Orders orders = ordersDAO.create(new Orders(orderId, customerId, orderDesc, orderStat));
		LOGGER.info("Item created");
		return orders;
	}

	//for the user to update an order
	@Override
	public Orders update() {
		LOGGER.info("Please enter the order ID");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter the customer ID");
		Long customerId = utils.getLong();
		LOGGER.info("Please enter a list of what was bought");
		String orderDesc = utils.getString();
		LOGGER.info("Please enter the status of this order");
		String orderStat = utils.getString();
		Orders orders = ordersDAO.update(new Orders(orderId, customerId, orderDesc, orderStat));
		LOGGER.info("Item updated");
		return orders;
	}

	//for the user to delete an order
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long itemId = utils.getLong();
		return ordersDAO.delete(itemId);
	}
	
	

}

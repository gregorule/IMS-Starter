package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.LinkDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Link;
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
        Link link = null;
        Orders order = null;	
        Long itemId = null;
        boolean itemLoop = true;
        while (link == null) {
        	LOGGER.info("Please enter a customer ID");
        	custId = utils.getLong(); 	
        	if(linkDAO == null) {
        		if(custId == -1) {
        			break;
        		}
        		if(custId == null) {//if item doesn't exist, change this (for loops/streams)
        			LOGGER.info("Please enter an existing customer ID");
        			continue;
        		}
        	}else {
        		link = new Link(custId);
        		Link linkVariable = linkDAO.create(link);
        		LOGGER.info("detail created");
        		LOGGER.info(link);
        		LOGGER.info(linkVariable);
        	}
        }
        while(itemLoop) {
        	LOGGER.info("Please enter the item ID");
        	itemId = utils.getLong();
        	if(itemId == -1) {
    			itemLoop = false;
    			continue;
    		}
        	if(itemDAO == null) {
        		
        		if(itemId == null) {
        			LOGGER.info("Please enter an existing item ID");
        			continue;
        		}
        	}
        	
        	itemLoop = false;
        
        
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		LOGGER.info("Please enter the status of this order");
		String orderStat = utils.getString();
		order = ordersDAO.create(new Orders(link.getOrderId(), itemId, quantity, orderStat));
		LOGGER.info("Item created");
        
		return order;
        }
		return order;
	}

	//for the user to update an order
	@Override
	public Orders update() {
		Long custId = null;
        Link link = null;
        Orders order = null;	
        Long itemId = null;
        boolean itemLoop = true;
        while (link == null) {
        	LOGGER.info("Please enter the order ID");
    		Long orderId = utils.getLong();
    		LOGGER.info("Please enter a customer ID");
    		custId = utils.getLong();
    		
    		if (linkDAO == null) {
    			if(orderId == -1) {
    				break;
    			}
    			if(orderId == null) {
    				LOGGER.info("Please enter an existing order ID");
        			continue;
    			}
    			
    		}else {
    			link = new Link(orderId, custId);
    			Link linkVariable = linkDAO.update(link);
    		}
    	
        }
        while(itemLoop) {
        	LOGGER.info("Please enter an item ID");
    		itemId = utils.getLong();
    		if(itemId == -1) {
    			itemLoop = false;
    			continue;
    		}
    		if (itemDAO == null){
    			LOGGER.info("Please enter an existing item ID");
    			continue;
    		}
    		itemLoop = false;
        }
        
		
		
		
		LOGGER.info("Please enter the quantity");
		int quantity = utils.getInt();
		LOGGER.info("Please enter the status of this order");
		String orderStat = utils.getString();
		Orders orders = ordersDAO.update(new Orders(link.getOrderId(), link.getCustomerId(), itemId, quantity, orderStat));
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

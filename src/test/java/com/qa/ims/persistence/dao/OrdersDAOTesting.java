package com.qa.ims.persistence.dao;

import org.junit.Before;

import com.qa.ims.utils.DBUtils;

public class OrdersDAOTesting {
	
	private final OrdersDAO DAO = new OrdersDAO();
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	

}

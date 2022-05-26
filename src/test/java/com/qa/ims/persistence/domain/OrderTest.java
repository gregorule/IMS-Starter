package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	
	@Test
	public void simpleEqualsContract() {
	    EqualsVerifier.simple().forClass(Orders.class).verify();
	}

}

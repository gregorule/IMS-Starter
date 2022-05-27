package com.qa.ims.persistence.domain;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class LinkTest {
	
	@Test
	public void simpleEqualsContract() {
	    EqualsVerifier.simple().forClass(Link.class).verify();
	}


}

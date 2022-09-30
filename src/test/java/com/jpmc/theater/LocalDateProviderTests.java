package com.jpmc.theater;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LocalDateProviderTests {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetInstance() {
		assertNotNull(LocalDateProvider.getInstance());
	}

	@Test
	void makeSureCurrentTime() {
		assertEquals(LocalDateProvider.getInstance().currentDate(), LocalDate.now());
	}


}

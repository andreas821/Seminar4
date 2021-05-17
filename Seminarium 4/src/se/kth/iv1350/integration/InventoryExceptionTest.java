package se.kth.iv1350.integration;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

class InventoryExceptionTest {

	@Test
	void testDatabaseNotFoundException() {
		try {
			Inventory inventory = new Inventory();
		
			inventory.getItemDTO(999);
			
			fail("The inventory DatabaseNotFoundException for identifier 999");
		}catch(DatabaseNotFoundException e) {
			
		}catch(Exception e) {
			fail("The inventory threw a incorrect exception");
		}
	}
	
	@Test
	void testNoSuchElementException() {
		try {
			Inventory inventory = new Inventory();
			
			inventory.getItemDTO(-1);
			
		}catch(NoSuchElementException e) {
				
		}catch(Exception e) {
			fail("The inventory threw a incorrect exception");
		}
	}

}

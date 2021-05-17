package se.kth.iv1350.DTO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class SaleDTOTest {

	@Test
	void testGetMethods() {
		int itemPrice = 120;
		int itemVAT = 33;
		String itemDescription = "Test item";
		
		ItemDTO testItem = new ItemDTO(itemPrice, itemVAT, itemDescription);
		
		List<ItemQuantityDTO> testListOfItems = new ArrayList<ItemQuantityDTO>();
		testListOfItems.add(new ItemQuantityDTO(testItem, 1));
		
		SaleDTO testSaleDTO = new SaleDTO(itemPrice, itemVAT, testListOfItems);
		
		int resultPrice = testSaleDTO.getTotalPrice();
		assertEquals(itemPrice, resultPrice, "Expected price and resulting price are not equal");
		
		int resultVAT = testSaleDTO.getVAT();
		assertEquals(itemVAT, resultVAT, "Expected VAT and resulting VAT are not equal");
		
		List<ItemQuantityDTO> resultListOfItems = testSaleDTO.getItems();
		assertEquals(testListOfItems, resultListOfItems, "Expected list of items and resulting list of items are not equal");
		
	}

}

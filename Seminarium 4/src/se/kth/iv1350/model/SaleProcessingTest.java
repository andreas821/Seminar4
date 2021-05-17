package se.kth.iv1350.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.SaleDTO;

class SaleProcessingTest {

	@Test
	void testScanItem() {
		SaleProcessing saleProcessing = new SaleProcessing();
		
		int scanItemQuantity = 1;
		int scanItemPrice = 1000;
		int scanItemVAT = 200;
		String scanItemDescription = "Test item";
		
		ItemDTO itemToBeScanned = new ItemDTO(scanItemPrice, scanItemVAT, scanItemDescription);
		
		saleProcessing.scanItem(itemToBeScanned, scanItemQuantity);
		
		SaleDTO saleData = saleProcessing.getSaleDTO();
		
		int expectedPrice = itemToBeScanned.getPrice() * scanItemQuantity;
		int resultPrice = saleData.getTotalPrice();
		
		int expectedVAT = itemToBeScanned.getVAT() * scanItemQuantity;
		int resultVat = saleData.getVAT();
		
		assertEquals(expectedPrice, resultPrice, "Expected price and resulting price are not equal");
		assertEquals(expectedVAT, resultVat, "Expected VAT and resulting VAT are not equal");
		
	}
	
	@Test
	void testScanMultipleItem() {
		SaleProcessing saleProcessing = new SaleProcessing();
		
		int scanItemQuantity = 10;
		int scanItemPrice = 1000;
		int scanItemVAT = 200;
		String scanItemDescription = "Test item";
		
		ItemDTO itemToBeScanned = new ItemDTO(scanItemPrice, scanItemVAT, scanItemDescription);
		
		saleProcessing.scanItem(itemToBeScanned, scanItemQuantity);
		
		SaleDTO saleData = saleProcessing.getSaleDTO();
		
		int expectedPrice = itemToBeScanned.getPrice() * scanItemQuantity;
		int resultPrice = saleData.getTotalPrice();
		
		int expectedVAT = itemToBeScanned.getVAT() * scanItemQuantity;
		int resultVat = saleData.getVAT();
		
		assertEquals(expectedPrice, resultPrice, "Expected price and resulting price are not equal");
		assertEquals(expectedVAT, resultVat, "Expected VAT and resulting VAT are not equal");
	}

}

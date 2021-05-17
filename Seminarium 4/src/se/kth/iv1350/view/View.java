package se.kth.iv1350.view;

import java.util.NoSuchElementException;

import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.ReceiptDTO;
import se.kth.iv1350.DTO.SaleDTO;
import se.kth.iv1350.controller.Controller;
import se.kth.iv1350.integration.DatabaseNotFoundException;

public class View {
	
	private Controller controller;
	
	public View(Controller controller) {
		this.controller = controller;
		
		System.out.println("Starting a new sale");
		controller.beginSale();
		controller.addObserver(new TotalRevenueView());
		controller.addObserver(new TotalRevenueFileOutput());
		
		scanItem(999, 1);
		
		System.out.println("Getting sale data");
		SaleDTO saleDTO = controller.getSaleDTO();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		scanItem(1233, 3);
		
		System.out.println("Getting sale data");
		saleDTO = controller.getSaleDTO();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		scanItem(123, 3);
		
		System.out.println("Getting sale data");
		saleDTO = controller.getSaleDTO();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		System.out.println("Ending sale");
		saleDTO = controller.endSale();
		System.out.println("Running total:" + saleDTO.getTotalPrice());
		System.out.println("Total VAT:" + saleDTO.getVAT());
		
		System.out.println("Paid amount 5000");
		int change = controller.getChangeAmount(5000);
		System.out.println("Change to return: " + change);
		
		
	}
	
	private void scanItem(int itemIdentifier, int quantity) {
		
		System.out.println("Scanning item " + itemIdentifier +" quantity " + quantity);
		
		try {
			ItemDTO itemDTO = controller.scanItem(itemIdentifier, quantity);
			System.out.println("Item price :" + itemDTO.getPrice());
			System.out.println("Item VAT :" + itemDTO.getVAT());
			System.out.println("Item Description :" + itemDTO.getDescription());
		}catch(NoSuchElementException e) 
		{
			System.out.println("No item with identifier " + itemIdentifier + " could be found");
			System.out.println("To log: " + e);
		}catch(DatabaseNotFoundException e) 
		{
			System.out.println("The server could not be reached");
			System.out.println("To log: " + e);
		}
		
		
	}
	
	

}

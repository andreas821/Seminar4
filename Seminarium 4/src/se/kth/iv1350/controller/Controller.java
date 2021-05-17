package se.kth.iv1350.controller;

import java.util.NoSuchElementException;

import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.ReceiptDTO;
import se.kth.iv1350.DTO.SaleDTO;
import se.kth.iv1350.integration.DatabaseNotFoundException;
import se.kth.iv1350.integration.ExternalAccountingSystem;
import se.kth.iv1350.integration.Inventory;
import se.kth.iv1350.integration.Printer;
import se.kth.iv1350.model.Observer;
import se.kth.iv1350.model.SaleProcessing;

public class Controller {

	private SaleProcessing saleProcessing;
	private ExternalAccountingSystem externalAccountingSystem;
	private Inventory inventory;
	private Printer printer;
	
	/**
	 * Creates a new instance of Controller.
	 */
	public Controller() {
		externalAccountingSystem = new ExternalAccountingSystem();
		inventory = new Inventory();
		printer = new Printer();
	}
	
	/**
	 * Begins the a new sale.
	 *  
	 */
	public void beginSale() {
		saleProcessing = new SaleProcessing();
	}
	
	/**
	 * Ends the sale.
	 * 
	 * @return The information about this sale.
	 * 
	 */
	public SaleDTO endSale() {
		return saleProcessing.getSaleDTO();
	}
	
	/**
	 * Gets information about the scanned item.
	 *  
	 * @param itemIdentifier The item identifier the item scanned
	 * @param quantity The quantity of the items scanned
	 * 
	 * @return The information about the item
	 * 
	 */
	public ItemDTO scanItem(int itemIdentifier, int quantity) throws NoSuchElementException, DatabaseNotFoundException{
		ItemDTO itemDTO = inventory.getItemDTO(itemIdentifier);
		
		if(itemDTO != null) {
			saleProcessing.scanItem(itemDTO, quantity);
		}
		
		return itemDTO;
	}
	
	/**
	 * Gets information about the current sale.
	 * 
	 * @return The information about the sale
	 * 
	 */
	public SaleDTO getSaleDTO() {
		return saleProcessing.getSaleDTO();
	}
	
	/**
	 * Gets the amount of change to return
	 *  
	 * @param amountPaid The amount of money paid
	 * 
	 * @return The amount of change to return
	 * 
	 */
	public int getChangeAmount(int amountPaid) {
		SaleDTO saleDTO = saleProcessing.getSaleDTO();
		
		inventory.updateInventory(saleDTO);
		externalAccountingSystem.logSale(saleDTO);
		
		ReceiptDTO receiptDTO = saleProcessing.getReceiptDTO(amountPaid);
		
		printer.Print(receiptDTO);
		
		return amountPaid - saleDTO.getTotalPrice();
	}
	
	/**
	 * Adds a observer to saleProcessing.
	 *  
	 * @param observer The observer to be added
	 * 
	 */
	public void addObserver(Observer observer) {
		saleProcessing.addObserver(observer);
	}
	
}

package se.kth.iv1350.model;

import se.kth.iv1350.DTO.SaleDTO;

import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.DTO.ItemDTO;
import se.kth.iv1350.DTO.ItemQuantityDTO;
import se.kth.iv1350.DTO.ReceiptDTO;

public class SaleProcessing {

	private List<Observer> observers = new ArrayList<Observer>();
	
	private List<ItemQuantityDTO> listOfItems = new ArrayList<ItemQuantityDTO>();
	
	/**
	 * Creates a instance to process a sale.
	 * 
	 */
	public SaleProcessing() {
		
	}
	
	/**
	 * Adds a observer.
	 *  
	 * @param observer The observer to be added
	 * 
	 */
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	/**
	 * Adds a scanned item.
	 *  
	 * @param itemDTO The item to be added
	 * @param quantity The quantity of item added
	 * 
	 */
public void scanItem(ItemDTO itemDTO, int quantity) {
		
		quantity += removeDuplicate(itemDTO);
		
		listOfItems.add(new ItemQuantityDTO(itemDTO, quantity));
		
	}
	
	private int removeDuplicate(ItemDTO itemDTO) {
		
		int quantity = 0;
		
		for(int i = 0; i < listOfItems.size(); i++) {
			if(listOfItems.get(i).getItem().equals(itemDTO)) {
				quantity += listOfItems.get(i).getQuantity();
				listOfItems.remove(i);
				break;
			}
		}
			
		return quantity;
	}
	
	/**
	 * Gets information about the current sale.
	 *  
	 * @return A object representing the sale
	 * 
	 */
	public SaleDTO getSaleDTO() {
		int totalPrice = 0;
		int totalVAT = 0;
		
		for(int i = 0; i < listOfItems.size(); i++) {
			int quantity = listOfItems.get(i).getQuantity();
			ItemDTO item = listOfItems.get(i).getItem();
			totalPrice += item.getPrice() * quantity;
			totalVAT += item.getVAT() * quantity;
		}
		
		SaleDTO saleDTO = new SaleDTO(totalPrice, totalVAT, listOfItems);
		
		return saleDTO;
	}
	
	/**
	 * Gets the receipt associated with the sale.
	 *  
	 * @return The receipt
	 * 
	 */
	public ReceiptDTO getReceiptDTO(int amountPaid) {
		
		SaleDTO saleDTO = getSaleDTO();
		
		int change = amountPaid - saleDTO.getTotalPrice();
		
		ReceiptDTO receipt = new ReceiptDTO(05052021, 123243, "Matbutik", "Afärsvägen 52", saleDTO.getItems(), saleDTO.getTotalPrice(), saleDTO.getVAT(), amountPaid, change);
	
		notifyObservers();
		
		return receipt;
	}
	
	private void notifyObservers() {
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).newSale(getSaleDTO());
		}
	}
	
}

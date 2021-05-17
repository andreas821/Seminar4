package se.kth.iv1350.DTO;

import java.util.List;

public class ReceiptDTO {
	
	private int date;
	private int time;
	private String storeName;
	private String storeAddress;
	private List<ItemQuantityDTO> listOfItems; //change
	private int totalPrice;
	private int vat;
	private int amountPaid;
	private int change;
	
	/**
	 * Creates a instance of a receipt
	 *  
	 * @param date The current date
	 * @param time The current time
	 * @param storeName The name of the store
	 * @param storeAdress The address of this store
	 * @param listOfItems A list of items purchased
	 * @param totalPrice The total price of the sale
	 * @param vat The VAT
	 * @param amountPaid The amount of cash paid
	 * @param change The amount of cnahge returned
	 * 
	 */
	public ReceiptDTO(int date, int time, String storeName, String storeAddress, List<ItemQuantityDTO> listOfItems, int totalPrice, int vat, int amountPaid, int change) {
		this.date = date;
		this.time = time;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.listOfItems = listOfItems;
		this.totalPrice = totalPrice;
		this.vat = vat;
		this.amountPaid = amountPaid;
		this.change = change;
	}
	
	/**
	 * Gets the date
	 *  
	 * @return The date
	 */
	public int getDate() {
		return date;
	}
	
	/**
	 * Gets the time
	 *  
	 * @return The time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * Gets the name of the store
	 *  
	 * @return The name of the store
	 */
	public String getStoreName() {
		return storeName;
	}
	
	/**
	 * Gets the store address
	 *  
	 * @return The address of the store
	 */
	public String getStoreAddress() {
		return storeAddress;
	}
	
	/**
	 * Gets the items purchased
	 *  
	 * @return A list of items purchased
	 */
	public List<ItemQuantityDTO> getListOfItems(){
		return listOfItems;
	}
	
	/**
	 * Gets the total price of the sale
	 *  
	 * @return The total price (including VAT)
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * Gets the VAT in the sale
	 *  
	 * @return The VAT
	 */
	public int getVAT() {
		return vat;
	}
	
	/**
	 * Gets the amount paid in the sale
	 *  
	 * @return The amount paid
	 */
	public int getAmountPaid() {
		return amountPaid;
	}
	
	/**
	 * Gets the amount of change returned in the sale
	 *  
	 * @return The amount of change
	 */
	public int getChange() {
		return change;
	}

}

package se.kth.iv1350.DTO;

import java.util.List;

public class SaleDTO {

	private int totalPrice;
	private int vat;
	private List<ItemQuantityDTO> items;
	
	/**
	 * Creates a instance representing a sale
	 *  
	 * @param totalPrice The total price of the sale (including VAT)
	 * @param vat The amount of VAT
	 * @param items A list of items in the sale
	 */
	public SaleDTO(int totalPrice, int vat, List<ItemQuantityDTO> items) {
		this.totalPrice = totalPrice;
		this.vat = vat;
		this.items = items;
	}
	
	/**
	 * Gets the total price of the sale
	 *  
	 * @return The total price of the sale (including VAT) 
	 */
	public int getTotalPrice() {
		return totalPrice;
	}
	
	/**
	 * Gets the VAT of the sale
	 *  
	 * @return The VAT
	 */
	public int getVAT() {
		return vat;
	}
	
	/**
	 * Gets the items purchased
	 *  
	 * @return A list of items purchased
	 */
	public List<ItemQuantityDTO> getItems(){
		return items;
	}
	
}

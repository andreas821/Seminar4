package se.kth.iv1350.DTO;

public class ItemDTO {

	private int price;
	private int vat;
	private String description;
	
	/**
	 * Creates a new instance of a item.
	 *  
	 * @param price The price of the item (including VAT)
	 * @param vat The VAT of this item
	 * @param description The description of the item
	 * 
	 */
	public ItemDTO(int price, int vat, String description) {
		this.price = price;
		this.vat = vat;
		this.description = description;
	}
	
	/**
	 * Gets the price of this item
	 * 
	 * @return The price
	 * 
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * Gets the VAT of this item
	 * 
	 * @return The VAT
	 * 
	 */
	public int getVAT() {
		return vat;
	}
	
	/**
	 * Gets the item description
	 * 
	 * @return The description
	 * 
	 */
	public String getDescription() {
		return description;
	}
}

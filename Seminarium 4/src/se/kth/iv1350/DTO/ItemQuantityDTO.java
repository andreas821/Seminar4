package se.kth.iv1350.DTO;

public class ItemQuantityDTO {

	private ItemDTO item;
	private int quantity;
	
	/**
	 * Creates a instance holding a quantity of items
	 *  
	 * @param item The item stored
	 * @param quantity The quantity of items
	 * 
	 */
	public ItemQuantityDTO(ItemDTO item, int quantity) {
		this.item = item;
		this.quantity = quantity;
	}
	
	/**
	 * Gets the stored item
	 *  
	 * @return The item stored
	 * 
	 */
	public ItemDTO getItem() {
		return item;
	}
	
	/**
	 * Gets the quantity of items
	 *  
	 * @return The quantity
	 * 
	 */
	public int getQuantity() {
		return quantity;
	}
	
}

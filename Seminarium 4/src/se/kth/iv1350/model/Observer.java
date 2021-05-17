package se.kth.iv1350.model;

import se.kth.iv1350.DTO.SaleDTO;

public interface Observer {

	
	/**
	 * Invoked when a sale is completed
	 * 
	 * @param saleDTO The sale completed
	 */
	
	void newSale(SaleDTO saleDTO);
	
}

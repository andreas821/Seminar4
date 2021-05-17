package se.kth.iv1350.integration;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.DTO.SaleDTO;

public class ExternalAccountingSystem {

	private List<SaleDTO> sales;
	
	/**
	 * Creates a new instance of the external accounting system.
	 *   
	 */
	public ExternalAccountingSystem() {
		sales = new ArrayList<SaleDTO>();
	}
	
	/**
	 * Logs a sale.
	 *  
	 * @param saleDTO The sale to be logged
	 * 
	 */
	public void logSale(SaleDTO saleDTO) {
		sales.add(saleDTO);
	}
	
}

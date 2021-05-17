package se.kth.iv1350.view;

import se.kth.iv1350.DTO.SaleDTO;
import se.kth.iv1350.model.Observer;

public class TotalRevenueView implements Observer {

	private int totalRevenu = 0;
	
	@Override
	public void newSale(SaleDTO saleDTO) {
		totalRevenu += saleDTO.getTotalPrice();
		System.out.println("Current total revenue is: " + totalRevenu);
		
	}

}

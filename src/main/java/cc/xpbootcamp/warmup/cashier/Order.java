package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private static final double TAX_RATE = .10;
	private String customerName;
	private String customerAddress;
	private List<LineItem> items;

	public Order(String cName, String addr, List<LineItem> lineItemList) {
		this.customerName = cName;
		this.customerAddress = addr;
		this.items = lineItemList;
	}

	String getCustomerName() {
		return customerName;
	}

	String getCustomerAddress() {
		return customerAddress;
	}

	List<LineItem> getLineItems() {
		return items;
	}


	double calculateTotWithTax() {
		double total = 0d;
		for (LineItem lineItem : getLineItems()) {

			total += lineItem.totalAmount() + lineItem.totalAmount() * TAX_RATE;
		}
		return total;
	}

	double calculateItemTax() {
		double totSalesTax = 0d;
		for (LineItem lineItem : getLineItems()) {
			double salesTax = lineItem.totalAmount() * TAX_RATE;
			totSalesTax += salesTax;
		}
		return totSalesTax;
	}
}

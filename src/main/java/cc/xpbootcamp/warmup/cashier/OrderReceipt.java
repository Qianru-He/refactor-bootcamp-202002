package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Date;


public class OrderReceipt {
	private static final int DISCOUNT_DAY = 3;
	private static final double DISCOUNT_RATE = 0.02;
	private Order order;
	private double discount = 0;
	private Date date = new Date();

	public OrderReceipt(Order order) {
		this.order = order;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		output.append(printHeaders());

		output.append(printDate());

		output.append(printsLineItems());

		output.append(printFooter());

		return output.toString();
	}

	private String printDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY年M月dd日,EEEE");
		return dateFormat.format(this.date) + '\n';
	}

	private String printFooter() {
		String footer = "";
		double total = order.calculateTotalPrice();

		if(isDiscount()){
			discount = total * DISCOUNT_RATE;
			footer+="折扣："+ discount +'\n';
		}
		footer+="税额："+order.calculateItemTax()+'\n'+
				"总价："+(total - discount)+'\n';
		return footer;
	}

	private boolean isDiscount() {
		return date.getDay()==DISCOUNT_DAY;
	}


	private String printsLineItems() {
		StringBuilder products = new StringBuilder();
		for (LineItem lineItem : order.getLineItems()) {
			products.append(lineItem.getDescription()).append(',')
					.append(lineItem.getPrice()).append('x')
					.append(lineItem.getQuantity()).append(',')
					.append(lineItem.getTotalAmount())
					.append('\n');
		}
		products.append("--------------------\n");
		return products.toString();
	}

	private String  printHeaders() {
		return "======老王超市，值得信赖======\n";
	}

}
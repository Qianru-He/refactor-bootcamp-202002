package cc.xpbootcamp.warmup.cashier;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class OrderReceipt {
	private Order order;
	private Date date = new Date();
	private static String ON_SALE_DAY = "星期三";

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

		output.append(printsTheStateTax(order.calculateItemTax()));

		output.append(printFooter(order.calculateTotWithTax()));

		return output.toString();
	}

	private String printDate() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY年M月dd日,EEEE");
		return dateFormat.format(this.date) + '\n';
	}

	private String printFooter(double tot) {
		String footer = "";
		double total = tot;
		String dayForWeek = getDayForWeek();
		if(isDiscount(dayForWeek)){
			footer+="折扣："+tot*0.02+'\n';
			total = total*0.98;
		}
		footer+="总价："+total+'\n';
		return footer;
	}

	private boolean isDiscount(String dayForWeek) {
		return dayForWeek.equals(ON_SALE_DAY);
	}

	private String printsTheStateTax(double totSalesTx) {
		return "税额："+totSalesTx+'\n';
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

	private String getDayForWeek() {
		String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
}
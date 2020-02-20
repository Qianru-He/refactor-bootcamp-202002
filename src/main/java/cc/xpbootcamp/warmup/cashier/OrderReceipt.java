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

		printHeaders(output);

		printDate(output);

		printsLineItems(output);

		printsTheStateTax(output, order.calculateItemTax());

		printTotalAmount(output, order.calculateTotWithTax());

		return output.toString();
	}

	private void printDate(StringBuilder output) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY年MM月dd日,EEEE");
		output.append(dateFormat.format(date)).append('\n');
	}

	private void printTotalAmount(StringBuilder output, double tot) {
		double total = tot;
		String dayForWeek = getDayForWeek();
		if(dayForWeek.equals(ON_SALE_DAY)){
			output.append("折扣：").append(tot*0.02).append('\n');
			total = total*0.98;
		}
		output.append("总价：").append(total).append('\n');
	}

	private void printsTheStateTax(StringBuilder output, double totSalesTx) {
		output.append("税额：").append(totSalesTx).append('\n');
	}

	private void printsLineItems(StringBuilder output) {
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getItemInfo());
		}
		output.append("--------------------\n");
	}

	private void printHeaders(StringBuilder output) {
		output.append("======老王超市，值得信赖======\n");
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
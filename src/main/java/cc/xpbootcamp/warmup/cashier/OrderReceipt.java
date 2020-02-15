package cc.xpbootcamp.warmup.cashier;

public class OrderReceipt {
	private Order order;

	public OrderReceipt(Order order) {
		this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		printHeaders(output);

		printCustomerData(output);

		printsLineItems(output);

		printsTheStateTax(output, order.calculateItemTax());

		printTotalAmount(output, order.calculateTotWithTax());

		return output.toString();
	}

	private void printTotalAmount(StringBuilder output, double tot) {
		output.append("Total Amount").append('\t').append(tot);
	}

	private void printsTheStateTax(StringBuilder output, double totSalesTx) {
		output.append("Sales Tax").append('\t').append(totSalesTx);
	}

	private void printsLineItems(StringBuilder output) {
		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getItemInfo());

		}
	}

	private void printCustomerData(StringBuilder output) {
		output.append(order.getCustomerName());
		output.append(order.getCustomerAddress());
	}

	private void printHeaders(StringBuilder output) {
		output.append("======Printing Orders======\n");
	}
}
package cc.xpbootcamp.warmup.cashier;

public class LineItem {
	private String description;
	private double price;
	private int quantity;

	public LineItem(String desc, double price, int qty) {
		this.description = desc;
		this.price = price;
		this.quantity = qty;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }
	public String getItemInfo(){
		return description+'\t'+price+'\t'+quantity+'\t'+totalAmount()+'\n';
	}
}
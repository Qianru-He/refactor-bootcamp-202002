package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    String customerName;
    String customerAddress;
    List<LineItem> items;

    public Order(String cName, String addr, List<LineItem> lineItemList) {
        this.customerName = cName;
        this.customerAddress = addr;
        this.items = lineItemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public List<LineItem> getLineItems() {
        return items;
    }

}

package cc.xpbootcamp.warmup.cashier;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();
        assertThat(output, containsString("Mr X"));
        assertThat(output, containsString("Chicago, 60601"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() throws ParseException {
        OrderReceipt receipt = getOrderReceipt();
        String str="2020-02-17 21:08:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);
        receipt.setDate(date);

        String output = receipt.printReceipt();
        assertThat(output, containsString("milk,10.0x2,20.0\n"));
        assertThat(output, containsString("biscuits,5.0x5,25.0\n"));
        assertThat(output, containsString("chocolate,20.0x1,20.0\n"));
        assertThat(output, containsString("税额：6.5"));
        assertThat(output, containsString("总价：71.5"));
    }

    @Test
    void shouldPrintHeadersAndDivider() {
        OrderReceipt receipt = getOrderReceipt();

        String output = receipt.printReceipt();
        assertThat(output,containsString("======老王超市，值得信赖======"));
        assertThat(output,containsString("--------------------"));
    }
    @Test
    public void shouldOnSaleWhenWednesdays() throws ParseException {
        OrderReceipt receipt = getOrderReceipt();
        String str="2020-02-19 21:08:06";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);
        receipt.setDate(date);

        String output = receipt.printReceipt();
        assertThat(output, containsString("税额：6.5"));
        assertThat(output, containsString("折扣：1.43"));
        assertThat(output, containsString("总价：70.07"));
    }

    public OrderReceipt getOrderReceipt() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        return new OrderReceipt(new Order(null, null, lineItems));
    }
}
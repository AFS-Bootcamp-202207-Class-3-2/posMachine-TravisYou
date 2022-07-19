package pos.machine;

import java.util.List;

public class Receipt {
    int totalPrice;
    List<ReceiptItem> receiptItems;
    Receipt(int totalPrice, List<ReceiptItem> receiptItems) {
        this.totalPrice = totalPrice;
        this.receiptItems = receiptItems;
    }
}

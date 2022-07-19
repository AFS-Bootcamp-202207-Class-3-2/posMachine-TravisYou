package pos.machine;

import java.util.List;

public class Receipt {
    private int totalPrice;
    private List<ReceiptItem> receiptItems;
    Receipt(int totalPrice, List<ReceiptItem> receiptItems) {
        this.totalPrice = totalPrice;
        this.receiptItems = receiptItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ReceiptItem> getReceiptItems() {
        return receiptItems;
    }

    public void setReceiptItems(List<ReceiptItem> receiptItems) {
        this.receiptItems = receiptItems;
    }
}

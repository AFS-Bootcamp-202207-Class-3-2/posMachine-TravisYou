package pos.machine;

public class ReceiptItem {
    String name;
    int quantity;
    int unitPrice;
    int subTotal;

    public ReceiptItem(String name, int quantity, int unitPrice) {
        this.name = name;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subTotal = quantity * unitPrice;
    }
}

package pos.machine;

import java.util.List;
import java.util.Map;

public class PosMachine {
    public Map<String, Integer> countQuantity(List<String> barcodes) {
        return null;
    }

    public Receipt makeReceipt(Map<String, Integer> barcodesQuantity) {
        return null;
    }

    public List<ReceiptItem> getReceiptItems(Map<String, Integer> barcodesQuantity) {
        return null;
    }

    public int getTotalPrice(List<ReceiptItem> receiptItems) {
        return 0;
    }

    public String renderReceipt(Receipt receipt) {
        return null;
    }

    public String spliceItemsDetail(Receipt receipt) {
        return null;
    }

    public String spliceReceipt(Receipt receipt) {
        return null;
    }

    public String printReceipt(List<String> barcodes) {
        return null;
    }
}

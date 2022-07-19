package pos.machine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PosMachine {
    public Map<String, Integer> countQuantity(List<String> barcodes) {
        Map<String, Integer> barcodesQuantity = new HashMap<String, Integer>(0);
        for (String barcode: barcodes) {
            int nowQuantity = barcodesQuantity.containsKey(barcode) ? barcodesQuantity.get(barcode) : 0;
            barcodesQuantity.put(barcode, nowQuantity + 1);
        }
        return barcodesQuantity;
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
        Map<String, Integer> barcodesQuantity = countQuantity(barcodes);
        Receipt receipt = makeReceipt(barcodesQuantity);
        return renderReceipt(receipt);
    }
}

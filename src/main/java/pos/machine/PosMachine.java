package pos.machine;

import java.util.ArrayList;
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
        List<ReceiptItem> receiptItems = getReceiptItems(barcodesQuantity);
        int totalPrice = getTotalPrice(receiptItems);
        return new Receipt(totalPrice, receiptItems);
    }

    public List<ReceiptItem> getReceiptItems(Map<String, Integer> barcodesQuantity) {
        List<ReceiptItem> receiptItems = new ArrayList<>();
        List<ItemInfo> itemInfos = ItemDataLoader.loadAllItemInfos();
        itemInfos.forEach(itemInfo -> {
            int quantity = barcodesQuantity.get(itemInfo.getBarcode());
            ReceiptItem receiptItem = new ReceiptItem(itemInfo.getName(), quantity, itemInfo.getPrice());
            receiptItems.add(receiptItem);
        });
        return receiptItems;
    }

    public int getTotalPrice(List<ReceiptItem> receiptItems) {
        int totalPrice = receiptItems.stream().mapToInt(ReceiptItem::getSubTotal).sum();
        return totalPrice;
    }

    public String renderReceipt(Receipt receipt) {
        return spliceReceipt(receipt);
    }

    public String spliceItemsDetail(Receipt receipt) {
        String itemsDetail = "";
        List<ReceiptItem> receiptItems = receipt.getReceiptItems();
        for(ReceiptItem receiptItem : receiptItems) {
            String name = receiptItem.getName();
            int quantity = receiptItem.getQuantity();
            int unitPrice = receiptItem.getUnitPrice();
            int subTotal = receiptItem.getSubTotal();
            itemsDetail += String.format("Name: %s, Quantity: %d, Unit price: %d (yuan), Subtotal: %d (yuan)\n", name, quantity, unitPrice, subTotal);
        }
        return itemsDetail;
    }

    public String spliceReceipt(Receipt receipt) {
        return "***<store earning no money>Receipt***\n" +
                spliceItemsDetail(receipt)+
                "----------------------\n" +
                String.format("Total: %d (yuan)\n", receipt.getTotalPrice()) +
                "**********************";
    }

    public String printReceipt(List<String> barcodes) {
        Map<String, Integer> barcodesQuantity = countQuantity(barcodes);
        Receipt receipt = makeReceipt(barcodesQuantity);
        return renderReceipt(receipt);
    }
}

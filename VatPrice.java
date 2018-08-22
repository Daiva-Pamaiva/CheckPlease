import java.math.BigDecimal;
import java.math.RoundingMode;
import static java.math.BigDecimal.valueOf;

class VatPrice {
    private static final String CURRENCY = "€";
    public static void main(String args[]) {
        printReceipt(4, new BigDecimal("400"));
    }
    private static void printReceipt(int quantity, BigDecimal totalAmount) {
        final BigDecimal netAmount = totalAmount.divide(valueOf(121), 2, RoundingMode.HALF_UP).multiply(valueOf(100));
        final BigDecimal vatAmount = totalAmount.subtract(netAmount);
        final BigDecimal itemPrice = netAmount.divide(valueOf(quantity));
        System.out.println("-----------Your Receipt:-----------");
        System.out.println(String.format("Item Price (excluding VAT): %.2f %s", itemPrice, CURRENCY));
        System.out.println(String.format("Quantity: %d", quantity));
        System.out.println(String.format("Net Amount (excluding VAT): %.2f %s", netAmount, CURRENCY));
        System.out.println(String.format("VAT Amount: %.2f €", vatAmount));
        System.out.println(String.format("Gross Amount (including VAT): %.2f %s", totalAmount, CURRENCY));
        System.out.println("-----------Thanks for buying!-----------");
    }
}
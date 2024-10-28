import java.util.ArrayList;
import java.util.List;

/**
 * Class Order mengelola seluruh pesanan dan melakukan perhitungan total, pajak, dan diskon.
 */
public class Order {
    private List<OrderItem> orderItems;
    private double taxRate;
    private double discount;

    /**
     * Konstruktor untuk pesanan dengan tarif pajak dan diskon.
     *
     * @param taxRate Tarif pajak
     * @param discount Diskon
     */
    public Order(double taxRate, double discount) {
        this.orderItems = new ArrayList<>();
        this.taxRate = taxRate;
        this.discount = discount;
    }

    /**
     * Menambahkan item ke pesanan.
     *
     * @param item Item pesanan
     */
    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    /**
     * Menghitung total harga sebelum pajak dan diskon.
     *
     * @return Total harga semua item
     */
    public double calculateSubtotal() {
        double subtotal = 0;
        for (OrderItem item : orderItems) {
            //custom live template totalbelanjasebelumkenapajak
            subtotal += item.calculateItemTotal();
        }
        return subtotal;
    }

    /**
     * Menghitung total setelah pajak dan diskon.
     *
     * @return Total yang harus dibayar
     */
    public double calculateTotal() {
        double subtotal = calculateSubtotal();

        //custom live template totalbelanjasesudahkenapajak
        double total = subtotal + (subtotal * taxRate) - discount;

        return total;
    }

    /**
     * Mencetak nota pesanan.
     */
    public void printReceipt() {
        System.out.println("Nota Pemesanan Restoran");
        System.out.println("------------------------");

        for (OrderItem item : orderItems) {
            System.out.printf("%s (x%d): Rp %.2f%n", item.getItemName(), item.getQuantity(), item.calculateItemTotal());
        }

        System.out.println("------------------------");
        System.out.printf("Subtotal: Rp %.2f%n", calculateSubtotal());
        System.out.printf("Pajak: Rp %.2f%n", calculateSubtotal() * taxRate);
        System.out.printf("Diskon: Rp %.2f%n", discount);
        System.out.printf("Total: Rp %.2f%n", calculateTotal());

    }

    public static void main(String[] args) {
        // Contoh penggunaan
        Order order = new Order(0.10, 5000);  // 10% pajak, Rp 5000 diskon
        order.addItem(new OrderItem("Nasi Goreng", 20000, 2));
        order.addItem(new OrderItem("Mie Ayam", 15000, 1));
        order.addItem(new OrderItem("Es Teh", 5000, 3));
        order.printReceipt();
    }
}

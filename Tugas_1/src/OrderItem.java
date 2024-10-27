/**
 * Class OrderItem merepresentasikan item pesanan dengan nama, harga, dan jumlahnya.
 */
public class OrderItem {
    private String itemName;
    private double price;
    private int quantity;

    /**
     * Konstruktor untuk item pesanan.
     *
     * @param itemName Nama item
     * @param price Harga per item
     * @param quantity Jumlah item
     */
    public OrderItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Menghitung total harga untuk item ini berdasarkan jumlah.
     *
     * @return Total harga untuk item ini
     */
    public double calculateItemTotal() {
        return price * quantity;
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
}

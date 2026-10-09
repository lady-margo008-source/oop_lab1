public class OrderItem {
    private final String name;
    private final int quantity;
    private final double price;
    public OrderItem(String name, int quantity, double price){
        if (name==null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Должно быть название у товара!");
        }
        if (quantity<=0) {
            throw new IllegalArgumentException("Количество товара должно быть положительным!");
        }
        if (price<=0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной или равной 0!");
        }
        this.name=name.trim();
        this.quantity=quantity;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
    public double getTotalPrice(){
        return quantity*price;
    }
}

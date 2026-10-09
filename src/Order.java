import java.util.ArrayList;
import java.util.List;
public class Order {
    private final int id;
    private final Client client;
    private final List<OrderItem> items;
    private Courier courier;
    private OrderStatus status;
    public Order(int id, Client client){
        if(id<=0){
            throw new IllegalArgumentException("ID заказа должен быть положительным");
        }
        if(client==null){
            throw new IllegalArgumentException("У заказа должен быть заказчик");
        }
        this.id = id;
        this.client = client;
        this.items = new ArrayList<>();
        this.status = OrderStatus.created;
        this.courier = null;
    }
    public void addItem(OrderItem item){
        if(item==null){
           throw new IllegalArgumentException("Товар закончился! Нельзя добавить товар!");
        }
        this.items.add(item);
    }
    //Подсчет общей стоимости товаров в заказе
    public double getTotalSumma(){
        double total=0.0;
        for (OrderItem item:items){
            total += item.getTotalPrice();
        }
        return total;
    }
    public int getId() { return id; }
    public Client getClient() { return client; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); }
    public Courier getCourier() { return courier; }
    public OrderStatus getStatus() { return status; }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
    public void changeStatus(OrderStatus newStatus) {
        if (this.status == OrderStatus.delivered) {
            throw new IllegalArgumentException("Нельзя изменить статус заказа, который уже успешно ДОСТАВЛЕН!");
        }
        if (this.status == OrderStatus.canceled) {
            throw new IllegalArgumentException("Нельзя изменить статус у уже ОТМЕНЕННОГО заказа!");
        }
        this.status = newStatus;
        System.out.println("[СТАТУС] Статус заказа №" + this.id + " успешно изменен на: " + newStatus);
    }

}


import java.util.ArrayList;
import java.util.List;
public class OrderService {
    private final List<Order> orders;
    private final List<Courier> couriers;
    private final Storage storage;
    public OrderService(Storage storage){
        if (storage==null) {
            throw new IllegalArgumentException("Склад не может быть пустой!");
        }
        this.storage=storage;
        this.orders=new ArrayList<>();
        this.couriers=new ArrayList<>();
    }
    //создание курьера
    public void registerCourier(Courier courier){
        if (courier==null){
            throw new IllegalArgumentException("Курьер не может быть null");
        }
        this.couriers.add(courier);
        System.out.println("Курьер"+courier.getName()+"успешно зарегистрирован!");
    }
    //создание заказа
    public void createOrder(int OrderId,Client client){
        Order newOrder = new Order(orderId, client);
        this.orders.add(newOrder);
        System.out.println("Заказ №" + orderId + " успешно создан для клиента " + client.getName());
    }
    //Поиск заказа
    public Order findOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getId() == orderId) {
                return order;
            }
        }
        throw new IllegalArgumentException("Заказ с ID " + orderId + " не найден в системе!");
    }
    //поиск свободного курьера
    private Courier findAvailableCourier() {
        for (Courier courier : couriers) {
            if (courier.isAvailable()) {
                return courier;
            }
        }
        return null;
    }
    //отмена заказа
    public void cancelOrder(int orderId) {
        Order order = findOrderById(orderId);

        order.changeStatus(OrderStatus.CANCELED);
        System.out.println("Возвращаем товары отмененного заказа на склад...");
        for (OrderItem item : order.getItems()) {
            storage.addItems(item.getName(), item.getQuantity(), item.getPrice());
        }
        if (order.getCourier() != null) {
            System.out.println("Освобождаем курьера " + order.getCourier().getName());
            order.getCourier().markAvailable();
            order.setCourier(null);
        }

        System.out.println("Заказ №" + orderId + " полностью отменен, ресурсы освобождены.");
    }
    public List<Order> getOrders() { return new ArrayList<>(orders); }
    public List<Courier> getCouriers() { return new ArrayList<>(couriers); }
}

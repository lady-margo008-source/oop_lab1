import java.util.HashMap;
import java.util.Map;
public class Storage {
    private final Map<String, OrderItem> items;
    public Storage(){
        this.items=new HashMap<>();
    }
public void addItems(String name, int quantity, double price) {
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Название товара не может быть пустым");
    }
    if (quantity <= 0 || price < 0) {
        throw new IllegalArgumentException("Некорректное количество или цена");
    }
    String key = name.trim().toLowerCase();
    if (items.containsKey(key)) {
        OrderItem existing = items.get(key);
        int totalQuantity = existing.getQuantity() + quantity;
        items.put(key, new OrderItem(existing.getName(), totalQuantity, price));
    } else {
        items.put(key, new OrderItem(name.trim(), quantity, price));
    }
}
public void takeItems(String name, int quantity) {
        String key = name.trim().toLowerCase();
    if (!items.containsKey(key)) {
        throw new IllegalArgumentException("Такого товара нет на складе: " + name);
    }
    OrderItem stockItem = items.get(key);
    if (stockItem.getQuantity() < quantity) {
        throw new IllegalArgumentException("Недостаточно товара! Доступно всего: " + stockItem.getQuantity());
    }
    int newQuantity = stockItem.getQuantity() - quantity;
    if (newQuantity == 0) {
        items.remove(key);
    } else {
        items.put(key, new OrderItem(stockItem.getName(), newQuantity, stockItem.getPrice()));
    }
}
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Склад пуст.");
            return;
        }
        System.out.println("Товары на складе:");
        for (OrderItem item : items.values()) {
            System.out.println("- " + item.getName() + ": " + item.getQuantity() + " шт., " + item.getPrice() + " руб.");
        }
    }
    // Метод получения товара по имени для проверки его цены
    public OrderItem getCurrentItem(String name) {
        String key = name.trim().toLowerCase();
        if (!items.containsKey(key)) {
            throw new IllegalArgumentException("Такого товара нет на складе: " + name);
        }
        return items.get(key);
    }


}
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ КОРЗИНЫ И СТАТУСОВ ЗАКАЗА ===\n");

        // 1. Создаем клиента
        Client client = new Client("Иван", "+79991112233", 1, "ул. Пушкина, д. 10");

        // 2. Создаем новый заказ для этого клиента
        Order order = new Order(101, client);
        System.out.println("Создан заказ №" + order.getId() + " для клиента " + order.getClient().getName());
        System.out.println("Начальный статус заказа: " + order.getStatus());

        // 3. Наполняем корзину заказа товарами
        order.addItem(new OrderItem("Клавиатура", 1, 2500.0));
        order.addItem(new OrderItem("Мышь", 2, 1200.0)); // 2 штуки по 1200

        // Проверяем автоматический подсчет стоимости (2500 + 2400 = 4900)
        System.out.println("Итоговая сумма заказа: " + order.getTotalSumma() + " руб.");

        System.out.println("\n-----------------------------------\n");

        // 4. Имитируем жизненный цикл заказа и успешную отмену
        System.out.println("Клиент передумал и отменяет заказ:");
        try {
            order.changeStatus(OrderStatus.canceled);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        System.out.println("\n-----------------------------------\n");

        // 5. Проверка защиты: пробуем перевести отмененный заказ в статус "В ПУТИ"
        System.out.println("Пробуем отправить отмененный заказ курьером (должна сработать защита):");
        try {
            order.changeStatus(OrderStatus.delivering);
            System.out.println("[ВНИМАНИЕ] Защита пробита! Отмененный заказ поехал к клиенту.");
        } catch (IllegalArgumentException e) {
            System.out.println("[ОК] Защита сработала! Перехвачена ошибка: " + e.getMessage());
        }
    }
}

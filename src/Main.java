public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ КЛАССА COURIER ===\n");

        // 1. Тест: Создание успешного курьера
        try {
            Courier courier = new Courier("Алексей", "+7896523645863", 1);
            System.out.println("[УСПЕХ] Курьер создан!");
            System.out.println("Имя: " + courier.getName());
            System.out.println("Свободен ли сейчас? " + courier.isAvailable());

            // Проверяем смену статуса
            System.out.println("\nОтправляем курьера на заказ...");
            courier.markBusy();
            System.out.println("Свободен ли теперь? " + courier.isAvailable());


            System.out.println("\nПробуем занять его повторно:");
            courier.markBusy();

        } catch (IllegalArgumentException e) {
            System.out.println("[ОК] Защита сработала! Ошибка: " + e.getMessage());
        }
    }
}

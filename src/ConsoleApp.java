import java.util.Scanner;
    public class ConsoleApp {
        private final OrderService orderService;
        private final Storage storage;
        private final Scanner scanner;
        public ConsoleApp() {
            this.storage = new Storage();
            this.orderService = new OrderService(this.storage);
            this.scanner = new Scanner(System.in);
        }
        public void start() {
            initDefaultStorage();
            while (true) {
                printMenu();
                System.out.print("Выберите пункт меню: ");
                String choice = scanner.nextLine().trim();
                try {
                    switch (choice) {
                        case "1":
                            createClientAndOrder();
                            break;
                        case "2":
                            addItemToOrderFlow();
                            break;
                            case "3":
                            registerCourier();
                            break;
                        case "4":
                            cancelOrderFlow();
                            break;
                        case "5":
                            assignDeliveryFlow(); // Вместо "Функция в разработке..."
                            break;
                        case "6":
                            storage.showItems();
                            break;
                        case "0":
                            System.out.println("Выход из программы. До свидания!");
                            return;
                        default:
                            System.out.println("[ОШИБКА] Неверный пункт меню, попробуйте еще раз.");
                    }
                } catch (Exception e) {
                    System.out.println("[ВНИМАНИЕ] Действие не выполнено: " + e.getMessage());
                }
                System.out.println("\n=======================================");
            }
        }
        private void initDefaultStorage() {
            storage.addItems("Клавиатура", 10, 2500.0);
            storage.addItems("Мышь", 15, 1200.0);
            storage.addItems("Монитор", 5, 15000.0);
        }
        private void printMenu() {
            System.out.println("\n=== МЕНЮ СЛУЖБЫ ДОСТАВКИ ===");
            System.out.println("1. Создать новый заказ (и клиента)");
            System.out.println("2. Добавить товар в заказ (списание со склада)");
            System.out.println("3. Зарегистрировать нового курьера");
            System.out.println("4. Отменить существующий заказ");
            System.out.println("5. Назначить доставку и курьера на заказ");
            System.out.println("6. Показать остатки товаров на складе");
            System.out.println("0. Выход");
        }

        private void createClientAndOrder() {
            System.out.print("Введите ID нового заказа (число): ");
            int orderId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Введите ID клиента (число): ");
            int clientId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Введите имя клиента: ");
            String name = scanner.nextLine();

            System.out.print("Введите телефон клиента: ");
            String phone = scanner.nextLine();

            System.out.print("Введите адрес доставки: ");
            String address = scanner.nextLine();

            Client client = new Client(name, phone, clientId, address);
            orderService.createOrder(orderId, client);
        }

        private void registerCourier() {
            System.out.print("Введите ID курьера (число): ");
            int id = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Введите имя курьера: ");
            String name = scanner.nextLine();

            System.out.print("Введите телефон курьера: ");
            String phone = scanner.nextLine();

            Courier courier = new Courier(name, phone, id);
            orderService.registerCourier(courier);
        }

        private void cancelOrderFlow() {
            System.out.print("Введите ID заказа для отмены: ");
            int id = Integer.parseInt(scanner.nextLine().trim());
            orderService.cancelOrder(id);
        }
        // Подменю для Пункта 4: Выбор типа доставки
        private void assignDeliveryFlow() {
            System.out.print("Введите ID заказа для назначения доставки: ");
            int orderId = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("\nВыберите тип доставки:");
            System.out.println("1. Самовывоз (0 руб.)");
            System.out.println("2. Стандартная доставка (300 руб., нужен курьер)");
            System.out.println("3. Экспресс-доставка (500 руб. + 10% от товаров, нужен курьер)");
            System.out.print("Ваш выбор: ");
            String deliveryChoice = scanner.nextLine().trim();

            DeliveryMethod selectedMethod;
            switch (deliveryChoice) {
                case "1":
                    selectedMethod = new PickupDelivery();
                    break;
                case "2":
                    selectedMethod = new StandardDelivery();
                    break;
                case "3":
                    selectedMethod = new ExpressDelivery();
                    break;
                default:
                    throw new IllegalArgumentException("Неверный выбор типа доставки.");
            }
            orderService.assignDeliveryMethod(orderId, selectedMethod);
        }
        //добавление товара в корзину
        private void addItemToOrderFlow() {
            System.out.print("Введите ID заказа: ");
            int orderId = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Введите название товара с клавиатуры: ");
            String itemName = scanner.nextLine();

            System.out.print("Введите количество: ");
            int quantity = Integer.parseInt(scanner.nextLine().trim());
            orderService.addItemToOrder(orderId, itemName, quantity);
        }


    }


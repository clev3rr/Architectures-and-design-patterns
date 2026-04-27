// 1. Спільний інтерфейс для всіх типів доставки
public interface Delivery {
    double calculateCost();
    void arrangeDelivery(String orderDetails);
}

// 2. Конкретні продукти (Способи доставки)
public class CourierDelivery implements Delivery {
    @Override
    public double calculateCost() {
        return 150.0; // Вартість послуг кур'єра
    }

    @Override
    public void arrangeDelivery(String orderDetails) {
        System.out.println("Формування доставки КУР'ЄРОМ за адресою пацієнта для: " + orderDetails);
    }
}

public class PostalDelivery implements Delivery {
    @Override
    public double calculateCost() {
        return 80.0; // Вартість поштової відправки
    }

    @Override
    public void arrangeDelivery(String orderDetails) {
        System.out.println("Передача пакунку з ліками до поштового відділення для: " + orderDetails);
    }
}

public class PharmacyPickup implements Delivery {
    @Override
    public double calculateCost() {
        return 0.0; // Самовивіз безкоштовний
    }

    @Override
    public void arrangeDelivery(String orderDetails) {
        System.out.println("Бронювання препаратів на касі в обраній аптеці для: " + orderDetails);
    }
}

// 3. Базовий клас Фабрики
public abstract class DeliveryFactory {
    // Фабричний метод
    public abstract Delivery createDelivery();

    // Загальна бізнес-логіка оформлення замовлення
    public void processOrder(String orderDetails) {
        Delivery delivery = createDelivery();
        double cost = delivery.calculateCost();
        System.out.println("Вартість доставки складе: " + cost + " грн.");
        delivery.arrangeDelivery(orderDetails);
    }
}

// 4. Конкретні фабрики для створення відповідних типів доставки
public class CourierFactory extends DeliveryFactory {
    @Override
    public Delivery createDelivery() {
        return new CourierDelivery();
    }
}

public class PostalFactory extends DeliveryFactory {
    @Override
    public Delivery createDelivery() {
        return new PostalDelivery();
    }
}

public class PickupFactory extends DeliveryFactory {
    @Override
    public Delivery createDelivery() {
        return new PharmacyPickup();
    }
}

// 5. Клієнтський код (Наприклад, контролер кошика інтернет-аптеки)
public class PharmacyApp {
    public static void main(String[] args) {
        String orderInfo = "Замовлення #777 (Вітамін С, Ібупрофен)";

        // Користувач обирає самовивіз
        System.out.println("--- Клієнт обрав самовивіз ---");
        DeliveryFactory pickupFactory = new PickupFactory();
        pickupFactory.processOrder(orderInfo);

        // Інший користувач замовляє ліки кур'єром
        System.out.println("\n--- Клієнт обрав кур'єра ---");
        DeliveryFactory courierFactory = new CourierFactory();
        courierFactory.processOrder(orderInfo);
    }
}

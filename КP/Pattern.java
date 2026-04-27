package org.example.lab1; // Вказує пакет, у якому знаходиться цей клас

// Імпорт необхідних класів з бібліотеки Spring Boot для запуску консольного додатка
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Анотація, яка позначає цей клас як головний конфігураційний клас Spring Boot додатка
public class Lab1Application implements CommandLineRunner { // Реалізуємо інтерфейс CommandLineRunner, щоб виконати код одразу після старту програми в консолі

    private final MinArray minArray; // Оголошення поля для зберігання об'єкта класу MinArray (нашої бізнес-логіки)

    // Конструктор класу. Через нього Spring автоматично створює та передає (інжектить) об'єкт MinArray
    public Lab1Application(MinArray minArray) {
       this.minArray = minArray;
    }

    // Головний метод main — стандартна точка входу для запуску будь-якої Java-програми
    public static void main(String[] args) {
       // Запускає фреймворк Spring Boot, піднімає контекст та ініціалізує наш додаток
       SpringApplication.run(Lab1Application.class, args);
    }

    // Перевизначений метод run. Код у ньому виконається автоматично після того, як Spring Boot успішно завантажиться
    @Override
    public void run(String... args) throws Exception {
       // Виведення інформаційного текстового заголовка в консоль
       System.out.println("=== Пошук мінімального числа в масиві ===");

       // Виклик методу findMin() з нашого компонента для виконання основної логіки програми
       minArray.findMin();
    }
}
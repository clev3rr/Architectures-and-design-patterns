public class Main {
    public static void main(String[] args) {
        // створення відділів
        Department company = new Department("Company");
        Department engineering = new Department("Engineering");
        Department qaTeam = new Department("QA Team");
        Department marketing = new Department("Marketing");

        // наповнення співробітниками
        engineering.add(new Employee("Dasha", "Engineer", 5000));
        engineering.add(new Employee("Maksym", "Engineer", 4500));
        engineering.add(new Employee("Artem", "Engineer", 6000));

        qaTeam.add(new Employee("Zina", "QA", 3800));
        qaTeam.add(new Employee("Sanya", "QA", 4200));

        marketing.add(new Employee("Sveta", "Marketer", 4000));
        marketing.add(new Employee("Katya", "Marketer", 4800));

        // формування ієрархії
        engineering.add(qaTeam); // вкладений відділ QA всередині Engineering
        company.add(engineering);
        company.add(marketing);

        // виведення
        System.out.println("--- Структура компанії ---");
        company.printStructure(0);

        System.out.println("\n--- Статистика ---");
        System.out.println("Загальний фонд оплати праці компанії: " + company.getTotalSalary());
        System.out.println("Кількість людей у Engineering (включно з QA): " + engineering.getHeadcount());
    }
}
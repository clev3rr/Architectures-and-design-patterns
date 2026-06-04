// листовий вузол (Leaf)
public class Employee implements OrgUnit {
    private String name;
    private String position;
    private double salary;

    public Employee(String name, String position, double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalSalary() {
        return salary;
    }

    @Override
    public int getHeadcount() {
        return 1; // один співробітник - це одна людина
    }

    @Override
    public void printStructure(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "└── " + position + ": " + name + " (" + salary + ")");
    }
}
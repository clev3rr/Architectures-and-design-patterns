import java.util.ArrayList;
import java.util.List;

// Композитний вузол (Composite)
public class Department implements OrgUnit {
    private String name;
    private List<OrgUnit> children = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    // методи управління нащадками (безпечний підхід)
    public void add(OrgUnit unit) {
        children.add(unit);
    }

    public void remove(OrgUnit unit) {
        children.remove(unit);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getTotalSalary() {
        double total = 0;
        for (OrgUnit child : children) {
            total += child.getTotalSalary(); // рекурсивний виклик
        }
        return total;
    }

    @Override
    public int getHeadcount() {
        int total = 0;
        for (OrgUnit child : children) {
            total += child.getHeadcount(); // рекурсивний виклик
        }
        return total;
    }

    @Override
    public void printStructure(int indent) {
        String padding = " ".repeat(indent);
        System.out.println(padding + "├── Department: " + name);
        for (OrgUnit child : children) {
            child.printStructure(indent + 4);
        }
    }
}
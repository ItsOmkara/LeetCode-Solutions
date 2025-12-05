import java.util.ArrayList;
import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        List<Skill> skillList = new ArrayList<>();
        skillList.add(new Skill("Java", "Expert"));
        skillList.add(new Skill("Spring Boot", "Intermediate"));

        Employee e1 = new Employee("Omkar", 101, skillList);
        Employee e2 = new Employee(e1); // copy constructor

        e2.skills.get(0).name = "Python";
        e2.skills.get(0).level = "Beginner";

        e1.printDetails();
        System.out.println("\nCopied Employee:");
        e2.printDetails();
    }
}

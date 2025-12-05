import java.util.ArrayList;
import java.util.List;

public class Employee {
    String empName;
    int empId;
    List<Skill> skills;

    Employee(String empName, int empId, List<Skill> skills) {
        this.empName = empName;
        this.empId = empId;
        this.skills = skills;
    }

    // ✅ Simple Copy Constructor (shallow copy)
    Employee(Employee e) {
        this.empName = e.empName;
        this.empId = e.empId;
        this.skills = new ArrayList<>();
        for (Skill s : e.skills) {
            this.skills.add(new Skill(s)); // copy using Skill's copy constructor
        }   // same list reference (shallow copy)
    }

    void printDetails() {
        System.out.println("Employee: " + empName + " | ID: " + empId);
        System.out.println("Skills: ");
        for (Skill s : skills) {
            System.out.println(" - " + s);
        }
    }
}

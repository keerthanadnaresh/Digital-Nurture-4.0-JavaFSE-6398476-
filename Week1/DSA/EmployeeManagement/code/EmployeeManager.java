class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    void displayInfo() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: INR " + salary);
    }
}

public class EmployeeManager {
    static Employee[] employees = new Employee[10];
    static int count = 0;

    
    static void addEmployee(Employee emp) {
        if (count < employees.length) {
            employees[count++] = emp;
        } else {
            System.out.println("Employee list is full.");
        }
    }

    
    static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee found:");
                employees[i].displayInfo();
                return;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
    }

    
    static void displayAll() {
        System.out.println("\n Employee List:");
        for (int i = 0; i < count; i++) {
            employees[i].displayInfo();
        }
    }

    
    static void deleteEmployee(int id) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[count - 1] = null;
                count--;
                found = true;
                System.out.println(" Employee with ID " + id + " deleted.");
                break;
            }
        }
        if (!found) {
            System.out.println(" Employee with ID " + id + " not found.");
        }
    }

    public static void main(String[] args) {
        
        addEmployee(new Employee(1, "Alice", "HR Manager", 60000));
        addEmployee(new Employee(2, "Bob", "Developer", 45000));
        addEmployee(new Employee(3, "Charlie", "Tester", 40000));

        
        displayAll();

       
        searchEmployee(2);  
        searchEmployee(5);  

        
        deleteEmployee(1);  

        
        displayAll();
    }
}

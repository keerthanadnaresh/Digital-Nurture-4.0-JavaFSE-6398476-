class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }

    void displayTask() {
        System.out.println("Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}

public class TaskManager {
    Task head = null;

    
    void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
        System.out.println(" Task added: " + name);
    }

    
    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        System.out.println("\n All Tasks:");
        Task current = head;
        while (current != null) {
            current.displayTask();
            current = current.next;
        }
    }

    
    void searchTask(int id) {
        Task current = head;
        while (current != null) {
            if (current.taskId == id) {
                System.out.println("\n Task Found:");
                current.displayTask();
                return;
            }
            current = current.next;
        }
        System.out.println(" Task with ID " + id + " not found.");
    }

    
    void deleteTask(int id) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.taskId == id) {
            head = head.next;
            System.out.println(" Task with ID " + id + " deleted.");
            return;
        }

        Task current = head;
        while (current.next != null) {
            if (current.next.taskId == id) {
                current.next = current.next.next;
                System.out.println(" Task with ID " + id + " deleted.");
                return;
            }
            current = current.next;
        }

        System.out.println(" Task with ID " + id + " not found.");
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        
        manager.addTask(101, "Design Homepage", "Pending");
        manager.addTask(102, "Implement Login", "In Progress");
        manager.addTask(103, "Test Payment", "Completed");

        
        manager.displayTasks();

        
        manager.searchTask(102);  
        manager.searchTask(200);  

        
        manager.deleteTask(101);  
        manager.displayTasks();   
    }
}

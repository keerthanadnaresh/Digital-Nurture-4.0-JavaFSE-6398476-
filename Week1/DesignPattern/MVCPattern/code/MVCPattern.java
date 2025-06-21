
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

   
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getGrade() {
        return grade;
    }
    public void setGrade(String grade) {
        this.grade = grade;
    }
}


class StudentView {
    public void showStudentInfo(String name, String id, String grade) {
        System.out.println("=== Student Details ===");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
        System.out.println("========================");
    }
}


class StudentController {
    Student student;
    StudentView view;

    public StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void updateView() {
        view.showStudentInfo(student.getName(), student.getId(), student.getGrade());
    }

    public void setStudentName(String name) {
        student.setName(name);
    }

    public void setStudentId(String id) {
        student.setId(id);
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
    }

    public Student getStudent() {
        return student;
    }
}


public class MVCPattern {
    public static void main(String[] args) {
        // Model
        Student student = new Student("John Doe", "S101", "A");

        // View
        StudentView view = new StudentView();

        // Controller
        StudentController controller = new StudentController(student, view);

        
        controller.updateView();

        
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("A+");

        
        controller.updateView();
    }
}

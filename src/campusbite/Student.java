package campusbite;

public class Student extends User {
    private String studentId;

    public Student(String name, String email, String studentId) {
        super(name, email);
        this.studentId = studentId;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Student ID: " + studentId);
    }
}

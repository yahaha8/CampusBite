package campusbite;

public class Admin extends User {
    private String adminId;

    public Admin(String name, String email, String adminId) {
        super(name, email);
        this.adminId = adminId;
    }

    @Override
    public void displayProfile() {
        super.displayProfile();
        System.out.println("Admin ID: " + adminId);
    }
}

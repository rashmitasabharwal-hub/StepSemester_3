public class SrmStudent {
    private static String collegeName;
    private static String academicYear;
    private String studentName;

    // Static initialization block runs exactly once when class is loaded
    static {
        collegeName = "SRM Institute of Science and Technology";
        academicYear = "2025-2026";
        System.out.println("College info loaded");
    }

    public SrmStudent(String studentName) {
        this.studentName = studentName;
        System.out.println("Student record created: " + this.studentName);
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        // Loop creates multiple objects without re-running static block
        for (String name : names) {
            new SrmStudent(name);
        }
    }
}
package samplearrays;
public class CourseNumbersArray {

    private int[] registeredCourses;

    public CourseNumbersArray(int[] registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public void addNewCourse(int courseNumber) {
        // Create a new array with one extra slot
        int[] updatedCourses = new int[registeredCourses.length + 1];

        // Copy existing courses
        for (int i = 0; i < registeredCourses.length; i++) {
            updatedCourses[i] = registeredCourses[i];
        }

        // Add the new course
        updatedCourses[registeredCourses.length] = courseNumber;

        // Update reference
        registeredCourses = updatedCourses;

        System.out.println("Course " + courseNumber + " added successfully.");
    }

    public void printRegisteredCourses() {
        System.out.println("List of registered courses:");
        for (int i = 0; i < registeredCourses.length; i++) {
            System.out.println("- " + registeredCourses[i]);
        }
        System.out.println();
    }

    public boolean containsCourse(int courseNumber) {
        for (int i = 0; i < registeredCourses.length; i++) {
            if (registeredCourses[i] == courseNumber) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] registeredCourses = {1010, 1020, 2080, 2140, 2150, 2160};
        CourseNumbersArray studentCourses = new CourseNumbersArray(registeredCourses);

        System.out.println("Initial courses:");
        studentCourses.printRegisteredCourses();

        studentCourses.addNewCourse(110);
        studentCourses.addNewCourse(210);

        System.out.println("After adding new courses:");
        studentCourses.printRegisteredCourses();

        int courseToCheck = 210;
        if (studentCourses.containsCourse(courseToCheck)) {
            System.out.println("Course " + courseToCheck + " exists in the list.");
        } else {
            System.out.println("Course " + courseToCheck + " does not exist in the list.");
        }
    }
}

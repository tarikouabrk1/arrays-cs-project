package samplearrays;

import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students.length == 0) return null;
        Student oldest = students[0];
        for (int i = 1; i < students.length; i++) {
            if (students[i].getAge() > oldest.getAge()) {
                oldest = students[i];
            }
        }
        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int nb = 0;
        for (Student s : students) {
            if (s.getAge() >= 18) nb++;
        }
        return nb;
    }

    // 4) Average Grade
    public static double averageGrade(Student[] students) {
        if (students.length == 0) return 0;
        double total = 0;
        for (Student s : students) {
            total += s.getGrade();
        }
        return total / students.length;
    }

    // 5) Search by Name (case-insensitive)
    public static Student findStudentByName(Student[] students, String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getGrade() < students[j].getGrade()) {
                    Student tmp = students[i];
                    students[i] = students[j];
                    students[j] = tmp;
                }
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        for (Student s : students) {
            if (s.getGrade() >= 15) {
                System.out.println(s);
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setGrade(newGrade);
                return true;
            }
        }
        return false;
    }

    // 9) Find Duplicate Names
    public static void printDuplicateNames(Student[] students) {
        boolean found = false;
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if (students[i].getName().equalsIgnoreCase(students[j].getName())) {
                    System.out.println(students[i].getName());
                    found = true;
                    break;
                }
            }
        }
        if (!found) System.out.println("No duplicate names");
    }

    // 10) Append a new student to the array
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        Student[] result = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            result[i] = students[i];
        }
        result[students.length] = newStudent;
        return result;
    }

    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Ali", 20, 14),
                new Student(2, "Sara", 19, 16),
                new Student(3, "Dina", 22, 12),
                new Student(4, "Omar", 17, 18),
                new Student(5, "Ali", 21, 15)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("\nOldest: " + findOldest(arr));

        // 3) Count adults
        System.out.println("Adults: " + countAdults(arr));

        // 4) Average grade
        System.out.println("Average grade: " + averageGrade(arr));

        // 5) Find by name
        System.out.println("\nFind Dina: " + findStudentByName(arr, "Dina"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 19);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("\nDuplicate names:");
        printDuplicateNames(arr);

        // 10) Append new student
        arr = appendStudent(arr, new Student(6, "Nadia", 18, 13));
        System.out.println("\nAfter appending:");
        for (Student s : arr) System.out.println(s);
    }
}

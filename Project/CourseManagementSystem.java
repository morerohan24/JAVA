import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseManagementSystem {
    private List<Course> courses;
    private List<Student> students;

    public CourseManagementSystem() {
        courses = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public Student findStudentByID(String studentID) {
        for (Student student : students) {
            if (student.getStudentID().equals(studentID)) {
                return student;
            }
        }
        return null;
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public void registerStudentForCourse(String studentID, String courseCode) {
        Student student = findStudentByID(studentID);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (student.registerCourse(course)) {
                System.out.println("Student " + student.getName() + " successfully registered for course " + course.getTitle() + ".");
            } else {
                System.out.println("Registration failed. The course is full.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    public void dropStudentFromCourse(String studentID, String courseCode) {
        Student student = findStudentByID(studentID);
        Course course = findCourseByCode(courseCode);

        if (student != null && course != null) {
            if (student.dropCourse(course)) {
                System.out.println("Student " + student.getName() + " successfully dropped from course " + course.getTitle() + ".");
            } else {
                System.out.println("Course drop failed. The student is not registered for this course.");
            }
        } else {
            System.out.println("Invalid student ID or course code.");
        }
    }

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();

        // Add sample courses
        cms.addCourse(new Course("CS101", "Introduction to Computer Science", "Basic concepts of computer science", 30, "MWF 9:00-10:00 AM"));
        cms.addCourse(new Course("MATH101", "Calculus I", "Introduction to calculus", 25, "TTh 10:00-11:30 AM"));

        // Add sample students
        cms.addStudent(new Student("S001", "Alice"));
        cms.addStudent(new Student("S002", "Bob"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nCourse Management System");
            System.out.println("1. List Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    cms.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String studentID = scanner.next();
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.next();
                    cms.registerStudentForCourse(studentID, courseCode);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    studentID = scanner.next();
                    System.out.print("Enter course code: ");
                    courseCode = scanner.next();
                    cms.dropStudentFromCourse(studentID, courseCode);
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

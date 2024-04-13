import java.util.*;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private List<Student> students;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.students = new ArrayList<>();
    }

    // getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

class Student {
    private String id;
    private String name;
    private List<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}

public class stdCourseRegSystem {
    private List<Course> courses;
    private List<Student> students;

    public stdCourseRegSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    // getters and setters
    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    void displayCourses() {
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + (course.getCapacity() - course.getStudents().size()));
            System.out.println();
        }
    }

    void registerStudentToCourse(Student student, Course course) {
        if (course.getStudents().size() < course.getCapacity()) {
            course.getStudents().add(student);
            student.getRegisteredCourses().add(course);
            System.out.println("Student " + student.getName() + " registered to course " + course.getTitle());
        } else {
            System.out.println("Sorry, the course " + course.getTitle() + " is full.");
        }
    }

    void removeStudentFromCourse(Student student, Course course) {
        if (student.getRegisteredCourses().contains(course)) {
            student.getRegisteredCourses().remove(course);
            course.getStudents().remove(student);
            System.out.println("Student " + student.getName() + " removed from course " + course.getTitle());
        } else {
            System.out.println("Student " + student.getName() + " is not registered for the course " + course.getTitle());
        }
    }

    public static void main(String[] args) {
        stdCourseRegSystem university = new stdCourseRegSystem();

        // Create some courses
        Course course1 = new Course("CS101", "Introduction to Computer Science", "Basics of computer science", 30, "Mon 10:00-11:30");
        Course course2 = new Course("CS102", "Data Structures", "Introduction to data structures", 30, "Wed 10:00-11:30");
        university.getCourses().add(course1);
        university.getCourses().add(course2);

        // Create some students
        Student student1 = new Student("s123", "Alice");
        Student student2 = new Student("s456", "Bob");
        university.getStudents().add(student1);
        university.getStudents().add(student2);

        // Register the students to the courses
        university.registerStudentToCourse(student1, course1);
        university.registerStudentToCourse(student2, course1);
        university.registerStudentToCourse(student2, course2);

        // Display the courses
        university.displayCourses();

        // Remove a student from a course
        university.removeStudentFromCourse(student2, course2);
        
        // Display the courses again to see the updated slots
        university.displayCourses();
    }
}

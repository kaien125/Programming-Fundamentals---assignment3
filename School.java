import java.util.ArrayList;

public class School {
	// use ArrayLists to store references of all Course objects and Student objects
	private ArrayList<Course> courses = new ArrayList<Course>();
	private ArrayList<Student> students = new ArrayList<Student>();

	public void addCourse(Course newCourse) {
		courses.add(newCourse);
	}

	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}

	public ArrayList<Student> getStudents() {
		return students;
	}
}

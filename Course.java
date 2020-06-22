import java.util.ArrayList;

public class Course {
	private String courseId;
	private String courseName;
	private int courseCredit;
	private ArrayList<Integer> marks = new ArrayList<Integer>();
	private ArrayList<Student> students = new ArrayList<Student>();

	public Course(String courseId) {
		this.courseId = courseId;
	}

	public void addMark(int newMark) {
		marks.add(newMark);
	}

	public void addStudent(Student newStudent) {
		students.add(newStudent);
	}

	public String getId() {
		return courseId;
	}

	public void setId(String newId) {
		courseId = newId;
	}

	public String getName() {
		return courseName;
	}

	public void setName(String newName) {
		courseName = newName;
	}

	public int getCredit() {
		return courseCredit;
	}

	public void setCredit(int newCredit) {
		courseCredit = newCredit;
	}

	// return number of students enrolled
	public int getEnroll() {
		return students.size();
	}

	// return average score of this course
	public int avgMark() {
		int totalMark = 0;
		try {
			for (int i = 0; i < marks.size(); i++) {
				totalMark += marks.get(i);
			}

			int avg = totalMark / marks.size();
			return avg;

		} catch (ArithmeticException e) {
			System.out.println("No student enrolled in course " + courseId);
			return 0;
		} catch (Exception e) {
			System.out.println("Something wrong...");
			return 0;
		}
	}
}
import java.util.ArrayList;

public class Student {
	private String studentId;
	private int age;
	private ArrayList<Integer> marks = new ArrayList<Integer>();
	private String studentName;
	private ArrayList<Course> courses = new ArrayList<Course>();

	public Student(String studentId) {
		this.studentId = studentId;
	}

	public String getId() {
		return studentId;
	}

	public void setId(String newId) {
		studentId = newId;
	}

	public String getName() {
		return studentName;
	}

	public void setName(String newName) {
		studentName = newName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int newAge) {
		age = newAge;
	}

	public int getMark(int i) {
		return marks.get(i);
	}

	// return total credit for all courses enrolled
	public int getCredit() {
		int totalCredit = 0;
		for (Course course : courses) {
			totalCredit += course.getCredit();
		}
		return totalCredit;
	}

	public void addMark(int newMark) {
		marks.add(newMark);
	}

	public void addCourse(Course newCourse) {
		courses.add(newCourse);
	}

	// return number of courses enrolled
	public int getEnroll() {
		return courses.size();
	}

	// return average score of this student
	public int avgMark() {
		int totalMark = 0;

		for (int i = 0; i < marks.size(); i++) {
			totalMark += marks.get(i);
		}

		int avg = totalMark / marks.size();

		return avg;
	}

	// return adjusted GPA
	public double GPA() {
		int totalGpa = 0;
		for (int i = 0; i < marks.size(); i++) {
			if ((marks.get(i) >= 80) & (marks.get(i) <= 100)) {
				totalGpa += 4 * courses.get(i).getCredit();
			} else if ((marks.get(i) >= 70) & (marks.get(i) < 80)) {
				totalGpa += 3 * courses.get(i).getCredit();
			} else if ((marks.get(i) >= 60) & (marks.get(i) < 70)) {
				totalGpa += 2 * courses.get(i).getCredit();
			} else if ((marks.get(i) >= 50) & (marks.get(i) < 60)) {
				totalGpa += 1 * courses.get(i).getCredit();
			} else if ((marks.get(i) >= 0) & (marks.get(i) < 50)) {
				totalGpa += 0 * courses.get(i).getCredit();
			} else {
				// if there is invalid mark in the file, return 0
				System.out.println("Error mark. Cannot calculate.");
				totalGpa = 0;
			}
		}

		double gpa = (double) totalGpa / this.getCredit();
		// return two decimal places without rounding
		// code referenced from:
		// [3]"How can I truncate a double to only two decimal places in Java?", Stack
		// Overflow, 2020. [Online]. Available:
		// https://stackoverflow.com/questions/7747469/how-can-i-truncate-a-double-to-only-two-decimal-places-in-java.
		// [Accessed: 02- Jun- 2020].
		return Math.floor(gpa * 100) / 100;
	}
}
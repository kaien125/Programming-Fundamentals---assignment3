import java.util.*;
import java.io.*;

public class MySchool {

	public static void main(String[] args) throws IOException {
		try {
			// first command line input should be scores.txt
			// read file name from command line
			Scanner scores = new Scanner(new File(args[0]));

			School mySchool = new School();

			String size = scores.next();

			// code referenced from:
			// [1]B. Kiers, "Java: parse int value from a char", Stack Overflow, 2020.
			// [Online]. Available:
			// https://stackoverflow.com/questions/4968323/java-parse-int-value-from-a-char.
			// [Accessed: 02- Jun- 2020].
			int studentNum = Character.getNumericValue(size.charAt(0));
			int courseNum = Character.getNumericValue(size.charAt(1));

			// create arrays of object Student and Course
			Student[] inputStudent = new Student[studentNum];
			Course[] inputCourse = new Course[courseNum];

			while (scores.hasNext()) {
				for (int i = 0; i < inputCourse.length; i++) {
					// use next input as courseId to declare new Course object
					inputCourse[i] = new Course(scores.next());
					// add this course to School object mySchool
					mySchool.addCourse(inputCourse[i]);
				}

				for (int row = 0; row < inputStudent.length; row++) {
					// use next input as studentId to declare new Student object
					inputStudent[row] = new Student(scores.next());
					// add this student to School object mySchool
					mySchool.addStudent(inputStudent[row]);

					double scoreDouble;
					int score;

					for (int col = 0; col < inputCourse.length; col++) {
						try {
							// convert input from string to double
							// code referenced from:
							// [2]M. Courteaux, "How to do an Integer.parseInt() for a decimal number?",
							// Stack Overflow, 2020. [Online]. Available:
							// https://stackoverflow.com/questions/1450991/how-to-do-an-integer-parseint-for-a-decimal-number.
							// [Accessed: 02- Jun- 2020].
							scoreDouble = Double.parseDouble(scores.next());
							// then cast to integer to ignore the decimal part
							score = (int) scoreDouble;

							// score = -1 means not enrolled in that course
							if (score != -1) {
								inputStudent[row].addMark(score);
								inputCourse[col].addMark(score);

								inputStudent[row].addCourse(inputCourse[col]);
								inputCourse[col].addStudent(inputStudent[row]);
							}
						} catch (NumberFormatException e) {
							System.out.println("Characters in file.");
						} catch (Exception e) {
							System.out.println("Something wrong.");
						}
					}
				}
			}

			int topAvg = 0;
			int topStudent = 0;

			for (int i = 0; i < inputStudent.length; i++) {
				topAvg = inputStudent[0].avgMark();

				if (topAvg < inputStudent[i].avgMark()) {
					topStudent = i;
					topAvg = inputStudent[i].avgMark();
				}
			}

			System.out.println("The top student is " + inputStudent[topStudent].getId() + " with an average " + topAvg);

			// read second file name from command line
			// second file name should be courses.txt
			Scanner courses = new Scanner(new File(args[1]));

			PrintWriter pwCourses = new PrintWriter(new BufferedWriter(new FileWriter("courses_report.txt")));

			do {
				for (int i = 0; i < inputCourse.length; i++) {
					// read next input as courseId
					String courseId = courses.next();
					// write courseId into new file courses_report.txt
					pwCourses.print(courseId + " ");

					String courseName = courses.next();
					// encapsulate courseName into Course object
					inputCourse[i].setName(courseName);
					pwCourses.print(inputCourse[i].getName() + " ");

					int courseCredit = courses.nextInt();
					inputCourse[i].setCredit(courseCredit);
					pwCourses.print(inputCourse[i].getCredit() + " ");

					pwCourses.print(inputCourse[i].getEnroll() + " ");

					pwCourses.print(inputCourse[i].avgMark());
					pwCourses.println();

				}
				pwCourses.close();
			} while (courses.hasNext());

			System.out.println("courses_report.txt generated!");

			// third command line input should be scores.txt
			Scanner students = new Scanner(new File(args[2]));

			PrintWriter pwStudents = new PrintWriter(new BufferedWriter(new FileWriter("student_report.txt")));

			while (students.hasNext()) {
				String studentId = students.next();
				// search ArrayList students in mySchool to match studentId
				for (Student s : mySchool.getStudents()) {
					// encapsulate related input into the matched object
					if (s.getId().equals(studentId)) {
						String studentName = students.next();
						s.setName(studentName);

						int studentAge = students.nextInt();
						s.setAge(studentAge);
					}
				}
			}

			// print each student`s information into new file
			for (Student s : mySchool.getStudents()) {
				pwStudents.print(s.getId() + " ");
				pwStudents.print(s.getName() + " ");
				pwStudents.print(s.getAge() + " ");
				pwStudents.print(s.getCredit() + " ");
				pwStudents.print(s.GPA());
				pwStudents.println();
			}
			pwStudents.close();

			System.out.println("student_report.txt generated!");

		} catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Need Three Files: scores.txt, courses.txt and students.txt");
		} catch (Exception e) {
			System.out.println("Something wrong.");
		}
	}
}
# Programming-Fundamentals---assignment3
MySchool is a Java application for schools. It reads data from files. 
## Section 1: 
The program can read from a file specified in command line and store student scores in
a 2D integer array.
### scores.txt
34 C081 C082 C083 C084<br />
S2023 99 75 85 62<br />
S2025 -1 92 67 52<br />
S1909 100 83 45 -1<br />

The file stores data as a text table shown above. Data fields are separated by spaces and new lines.
The first row contains course IDs and the first column contains student IDs. The first field in the data,
the top left corner, shows the number of rows and the number of columns in one integer. For
example ‘34’, the first digit 3 means there are 3 students in this table. The second digit 4 means
there are 4 courses. You can assume that the total number of courses will never be more than 9.
The table stores every student’s final results in those courses. Results are all integers. A result ‘-1’
means not enrolled in that course. A ‘0’ means the student did enrol but failed to receive any mark.
The program can find the student with the highest average score and display on the command line:
```
> java MySchool scores.txt
> The top student is S2023 with an average 80
```
## Section 2: 
The program can read one more file which stores the information of courses offered by the school.
Info includes course ID, course title and credit points. You can assume all courses of the school
appear in this file and in the first file (student results file). There is no duplicate or redundant courses.
### courses.txt
C081 Mathematics 12<br />
C082 Science 12<br />
C083 English 24<br />
C084 Technologies 6<br />

The program can produce a text file named as course_report.txt.
```
> java MySchool scores.txt courses.txt
> The top student is S2023 with an average 80
> courses_report.txt generated!
```

Given the above courses.txt, course_report.txt should look like below. The fourth column is
the number of enrolled students. The fifth column is the average score of each course.<br />

C081 Mathematics 12 2 99<br />
C082 Science 12 3 83<br />
C083 English 24 3 65<br />
C084 Technologies 6 2 57<br />
## Section 3: 
The program can read one more file from command line. That file stores information
about students, that includes student ID, name (no space between first name and last name, but an
underscore) and age. You can assume all students appear in this file as well as in the first file
(student results file). There is no duplicate records or empty records.
### students.txt
S2023 Sue_Vaneer 14<br />
S2025 Robin_Smith 13<br />
S1909 Barry_Banks 15<br />

The program can produce a text file report named as student_report.txt.
```
> java MySchool scores.txt courses.txt students.txt
> The top student is S2023 with an average 80
> course_report.txt generated!
> student_report.txt generated!
```
Given the above students.txt, student_report.txt should look like below. The fourth
column is the number of courses that student enrolled im. The fifth column is the average GPA. A
course result of 80+ receives 4 GPA points. A result of 70-79 receives 3 points. A result in between
60-69 is 2 points. 50-59 gets 1 points. Under 50 has 0 points. For example Sue Vaneer has 2 HD, 1
DI and 1 CR. So her GPA is ( 4 x 2 + 3 + 2 ) / 4 = 3.25.<br />

S2023 Sue_Vaneer 14 4 3.25<br />
S2025 Robin_Smith 13 3 2.33<br />
S1909 Barry_Banks 15 3 2.66<br />

The program can handle some variations in the files.<br />
(1) characters in sources.txt will be treated as -1.<br />
(2) decimal numbers will be treated as integers, ignoring the decimal part, e.g 99.5 -> 99<br />
(3) The order of lines in both students.txt and courses.txt does not matter. (You can
assume that the order of columns does not change.)

## Section 4: 
The program achieves the above requirements in OO style with at least three classes,
School, Student and Course. Design the appropriate instance variables, constructor(s) and
methods for these classes. Class related info should be encapsulated inside of these classes.
In addition, student_report.txt generated at this level is more advanced, taking credit points of
each course into consideration. See below. The fourth column is now the total credit points that the
student has completed. For example Sue Vaneer, she has done all four courses, so she earned 12 +
12 + 24 + 6 = 54 credit points. The fifth column is the adjusted GPA. So that for Sue is (4 x 12 + 3 x
12 + 4 x 24 + 2 x 6 ) / 54 = 3.55.<br />

S2023 Sue_Vaneer 14 54 3.55<br />
S2025 Robin_Smith 13 42 2.42<br />
S1909 Barry_Banks 15 48 2.0<br />

## Section 5: Miscellaneous
To verify the calculations, you can import the files, especial the provided test files, into a spreadsheet
tool, e.g. Excel, Google Spreadsheet, Numbers, which can easily compute average, max etc.
You program may have no interaction with users during execution. Simply run the code, read the
files, display output and/or generate file(s).
You can assume user always type file names in the right order in command line, e.g. score file first,
then course file, then student file. However it is possible that file is missing or cannot be found.

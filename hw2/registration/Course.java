package registration;

/**
 * Represents a course which a student can register for and waitlist in
 *
 * @author nwang89
 * @version 1.0
 */


public class Course {
    private static int numCoursesOffered;
    private int courseNumber;
    private Department dept;
    private int credits;
    private int classSize;
    private int waitlistCap;
    private Student[] registeredStudents;
    private int numStudentRegistered;
    private LectureTime time;

    /**
     * Creates a LectureTime
     *
     * @param dept the department offering the course
     * @param courseNumber the course number of this course
     * @param credits the number of credits this course is worth
     * @param classSize the maximum class size of the class
     * @param waitlistCap the maximum length of the waitlist
     * @param time the time that the course takes place
     *
     */
    public Course(Department dept, int courseNumber, int credits, int classSize,
                  int waitlistCap, LectureTime time) {
        this.dept = dept;
        this.courseNumber = courseNumber;
        this.credits = credits;
        this.classSize = classSize;
        this.waitlistCap = waitlistCap;
        this.time = time;
        this.registeredStudents =
            new Student[this.classSize + this.waitlistCap];
        this.numStudentRegistered = 0;
        numCoursesOffered++;
    }
    /**
     * @return the number of courses offered
     */
    public static int getNumCoursesOffered() {
        //non-static variable this cannot be referenced from a static context
        return numCoursesOffered;
    }
    /**
     * @return the number of credits of this course
     */
    public int getCredits() {
        return this.credits;
    }
    /**
     * @return the department offering this course
     */
    public Department getDept() {
        return this.dept;
    }
    /**
     * set the department of this course
     *
     * @param department the department that this course is offered
     */
    public void setDept(Department department) {
        this.dept = department;
    }
    /**
     * @return an list of students registered for this class
     */
    public Student[] getRegisteredStudents() {
        return registeredStudents;
    }
    /**
     * @return the number of student bothing taking and
     * waitlisted in this course
     */
    public int getNumStudentsRegistered() {
        return this.numStudentRegistered;
    }
    /**
     * @return the time this course takes place
     */
    public LectureTime getTime() {
        return this.time;
    }
    /**
     * @return the maximum class size of this course
     */
    public int getClassSize() {
        return this.classSize;
    }
    /**
     * Determine whether the size is smaller than original size,
     * maybe reset the size
     *
     * @param size the size that needs to be compared
     * @return false if the size is less than or equal to classSize
     * and true otherwise
     * If true, set classSize to size, resize registeredStudents array
     * and may need to promote student from waitlist
     */
    public boolean setClassSize(int size) {
        if (size <= this.classSize) {
            return false;
        } else {
            int preSize = this.classSize;
            this.classSize = size;
            Student[] temp = new Student[this.classSize + this.waitlistCap];
            System.arraycopy(registeredStudents, 0,
                             temp, 0, numStudentRegistered);
            registeredStudents = temp;

            for (int i = preSize;
                 i < Math.min(this.classSize, numStudentRegistered); i++) {
                registeredStudents[i].promotedFromWaitlist(this);
            }
            return true;
        }
    }
    /**
     * Returns the student at position i
     *
     * @param i the index of the position
     * @return the student at postion i in the registeredStudents list
     * returns null if there is no such student or the position is
     * bigger than the size of the array
     */
    public Student getRegisteredPosition(int i) {
        if (i >= registeredStudents.length) {
            return null;
        } else {
            return registeredStudents[i];
        }
    }
    /**
     * Determines whether the student is successfuly added to a course
     *
     * @param student the student being checked
     * @return true if the method successfully adds the student to the
     * registerdStudent array.
     * The operation fails and return false in the following conditions:
     * if the registeredStudent list is filled
     * if the student will be taking more than 18 credits after registering
     * if the student is already registered for the class
     * if the student is not available duing the course time
     * if the student is to be placed on the waitlist but is already
     * waitlisted in five or more classes
     */
    protected boolean addStudent(Student student) {
        numStudentRegistered++;

        if (numStudentRegistered > registeredStudents.length) {
            numStudentRegistered--;
            return false;
        }

        if (student.getCredits() + this.getCredits() > 18) {
            numStudentRegistered--;
            return false;
        }

        if (student.registeredForCourse(this)) {
            numStudentRegistered--;
            return false;
        }

        if (!student.availableAt(this.getTime())) {
            numStudentRegistered--;
            return false;
        }

        if (numStudentRegistered > this.classSize) {
            if (student.waitlist(this)) {
                registeredStudents[numStudentRegistered - 1] = student;
                return true;
            } else {
                numStudentRegistered--;
                return false;
            }
        }

        registeredStudents[numStudentRegistered - 1] = student;
        student.register(this);
        return true;
    }
    /**
     * @return A string of the form "department abbreviation
     * and course number", for example, "CS1331"
     */
    public String toString() {
        return this.dept + String.valueOf(this.courseNumber);
    }



}
package registration;

/**
 * Represents of a student able to register for courses
 *
 * @author nwang89
 * @version 1.0
 */
public class Student {

    private Course[] courses;
    private Course[] waitlists;
    private int numCoursesRegistered;
    private int numCoursesWaitlisted;
    private int credits;
    private String name;

    /**
     * Creates a Student
     *
     * @param name the name of the student
     *
     */
    public Student(String name) {
        this.courses = new Course[5];
        this.waitlists = new Course[5];
        this.numCoursesRegistered = 0;
        this.numCoursesWaitlisted = 0;
        this.credits = 0;
        this.name = name;
    }

    /**
     * @return the name of the student
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return the credits that the student is taking and waitlisted in
     */
    public int getCredits() {
        return this.credits;
    }
    /**
     * @return the the number of courses that the student is taking
     */
    public int getNumCoursesRegistered() {
        return this.numCoursesRegistered;
    }
    /**
     * @return the number of courses that the student is waitlisted in
     */
    public int getNumCoursesWaitlisted() {
        return this.numCoursesWaitlisted;
    }
    /**
     * @return an array of courses that the student is signed up to take
     */
    public Course[] getCourses() {
        return this.courses;
    }
    /**
     * @return an array of courses that the student is waitlisted in
     */
    public Course[] getWaitlists() {
        return this.waitlists;
    }
    /**
     * Determines whether the student is available at a time
     *
     * @param time the time being checked for availability
     * @return true if the student does not have a class(both taking
     * and waitlisted in) during this time and false otherwise
     */
    public boolean availableAt(LectureTime time) {
        for (int i = 0; i < numCoursesRegistered; i++) {
            LectureTime existCoursesTime = courses[i].getTime();
            if (existCoursesTime.overlap(time)) {
                return false;
            }
        }
        for (int i = 0; i < numCoursesWaitlisted; i++) {
            LectureTime existCoursesTime = waitlists[i].getTime();
            if (existCoursesTime.overlap(time)) {
                return false;
            }
        }
        return true;
    }
    /**
     * Register a student to this course. Add the course to courses array
     * If courses is full, the size of courses should be doubled and then the
     * course is added to the array
     *
     * @param course the course the student registers for
     */
    protected void register(Course course) {
        this.numCoursesRegistered++;
        if (numCoursesRegistered > courses.length) {
            Course[] temp = new Course[courses.length * 2];
            System.arraycopy(courses, 0, temp, 0, courses.length);
            courses = temp;
        }
        courses[numCoursesRegistered - 1] = course;
        this.credits += course.getCredits();
    }
    /**
     * Determines whether the student is successfully waitlisted in a course
     *
     * @param course the course this student wants to be waitlisted in
     * @return false if the student is waitlisted for five or more courses
     * and true otherwise. If true, it adds course to waitlists.
     */
    protected boolean waitlist(Course course) {
        if (numCoursesWaitlisted >= 5) {
            return false;
        }
        numCoursesWaitlisted++;
        waitlists[numCoursesWaitlisted - 1] = course;
        return true;
    }
    /**
     * Determines whether the student has registered fot the course
     *
     * @param course the course that needs to be checked
     * @return true if the student is either taking or waitlisted
     * for this course and false otherwise
     */
    public boolean registeredForCourse(Course course) {
        //For this homework assume that there will only be one
        // instance of each course, so uses ==
        for (Course each : courses) {
            if (each == course) {
                return true;
            }
        }
        for (Course each : waitlists) {
            if (each == course) {
                return true;
            }
        }
        return false;
    }
    /**
     * @return A string of the name of the student
     */
    public String toString() {
        return this.name;
    }
    /**
     * A wrapper method for course's addStudent method
     *
     * @param course The course that the student is attempting to register for
     * @return Whether or not the operation was successful
     */
    public boolean signUp(Course course) {
        return course.addStudent(this);
    }
    /**
     * Removes a course from waitlists classes and add it to courses
     *
     * @param course the course in which the student has been
     * promoted from the waitlist
     *
     * @return Whether or not the operation was successful
     */
    protected boolean promotedFromWaitlist(Course course) {
        for (int i = 0; i < numCoursesWaitlisted; i++) {
            if (course == waitlists[i]) {
                for (int j = i + 1; j < numCoursesWaitlisted; j++) {
                    waitlists[j - 1] = waitlists[j];
                }
                numCoursesWaitlisted--;
                waitlists[numCoursesWaitlisted] = null;
                credits -= course.getCredits();
                register(course);
                return true;
            }
        }
        return false;
    }
}

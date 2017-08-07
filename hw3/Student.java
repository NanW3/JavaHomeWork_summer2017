/**
* Represent a Student with GPA, ID and classes taking
* an subclass of Person
*
*
* @author nwang89
* @version 1.0
*/
public class Student extends Person {
    private double avgGPA;
    private int gtID;
    private String[] classes;
    /**
    * Creates an Undergrad
    *
    * @param name the name of student
    * @param age the age of student
    * @param homeTown the hometown of student
    * @param avgGPA average gpa of student
    * @param gtID the gtID of student
    * @param classes String array of classes that
    * the student is currently taking
    */
    public Student(String name, int age, String homeTown,
                   double avgGPA, int gtID, String[] classes) {
        super(name, age, homeTown);
        this.avgGPA = avgGPA;
        this.gtID = gtID;
        this.classes = classes;
    }
    /**
    * @return the avgGPA of the student
    */
    public double getAvgGPA() {
        return this.avgGPA;
    }
    /**
    * @return the classes the student is taking
    */
    public String[] getClasses() {
        return this.classes;
    }
    /**
    * @return a string of form "name is age years old from
    * homeTown with gtid gtID"
    */
    public String toString() {
        return super.toString() + " with gtid " + this.gtID;
    }
    /**
    * @return gtID of the student
    */
    public int getGTID() {
        return this.gtID;
    }
    /**
     * Checks if this student equals the object
     * override the equals method in Person class
     *
     * @param o an object
     * @return true if o is an instance of Student and has the
     * exactly same name, age, hometown and gtID as this student,
     * otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        if (!(o instanceof Student)) {
            return false;
        }

        Student s = (Student) o;

        if (s.gtID != this.gtID) {
            return false;
        }

        return true;
    }


}
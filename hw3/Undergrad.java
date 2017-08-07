/**
* Represent a Undergrad with sleephours
* an subclass of Student
*
*
* @author nwang89
* @version 1.0
*/
public class Undergrad extends Student {
    private int sleepHours;
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
    * @param sleepHours represents the hours of sleep
    * they get
    */
    public Undergrad(String name, int age, String homeTown,
                     double avgGPA, int gtID, String[] classes,
                     int sleepHours) {
        super(name, age, homeTown, avgGPA, gtID, classes);
        this.sleepHours = sleepHours;
    }
    /**
     * @return a string of form "Undergrad name is age year old from
     * hometown with gtid gtID is only sleeping sleepHours hours per
     * night"
     */
    public String toString() {
        return "undergrad " + super.toString() + " is only sleeping "
               + this.sleepHours + " hours per night";
    }
    /**
     * Checks if this undergrad equals the object
     * override the equals method in Student class
     *
     * @param o an object
     * @return true if o is an instance of Undergrad and has the
     * exactly same name, age, hometown, gtID and sleepHours as
     * this Undergrad otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        if (!(o instanceof Undergrad)) {
            return false;
        }

        Undergrad u = (Undergrad) o;

        if (u.sleepHours != this.sleepHours) {
            return false;
        }

        return true;
    }

}

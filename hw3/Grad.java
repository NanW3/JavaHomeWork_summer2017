/**
* Represent a Grad with thesisTitle
* an subclass of Student
*
*
* @author nwang89
* @version 1.0
*/
public class Grad extends Student {
    private String thesisTitle;
    /**
    * Creates an grad
    *
    * @param name the name of student
    * @param age the age of student
    * @param homeTown the hometown of student
    * @param avgGPA average gpa of student
    * @param gtID the gtID of student
    * @param classes String array of classes that
    * the student is currently taking
    * @param thesisTitle title of defense thesis
    */
    public Grad(String name, int age, String homeTown,
                double avgGPA, int gtID, String[] classes,
                String thesisTitle) {
        super(name, age, homeTown, avgGPA, gtID, classes);
        this.thesisTitle = thesisTitle;
    }
    /**
    * @return the thesisTitle of the student
    */
    public String getThesisTitle() {
        return this.thesisTitle;
    }
    /**
    * @return a string of format "grad name is age years
    * old from hometown with gtid gtID"
    */
    public String toString() {
        return "grad " + super.toString();
    }
      /**
     * Checks if this grad equals the object
     * override the equals method in Student class
     *
     * @param o an object
     * @return true if o is an instance of grad and has the
     * exactly same name, age, hometown, gtID and thesisTitle
     * as this Undergrad otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }

        if (!(o instanceof Grad)) {
            return false;
        }

        Grad g = (Grad) o;

        if (!(g.thesisTitle.equals(g.thesisTitle))) {
            return false;
        }

        return true;
    }
}

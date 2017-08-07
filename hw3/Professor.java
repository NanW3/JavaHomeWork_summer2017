/**
* Represent a Professor with classSize and classes
* they teach
* an subclass of Person
*
*
* @author nwang89
* @version 1.0
*/
public class Professor extends Person {
    private int classSize;
    private String[] classes;
    /**
     * Creates a Professor
     *
     * @param name the name of person
     * @param age the age of person
     * @param homeTown the hometown of person
     * @param classSize the class size
     * @param classes String array of the classes
     * they teach
     *
     */
    public Professor(String name, int age, String homeTown,
                     int classSize, String[] classes) {
        super(name, age, homeTown);
        this.classSize = classSize;
        this.classes = classes;
    }
     /**
    * @return a string of format "Professor name has a class of
    * classSize students"
    */
    public String toString() {
        return "Professor " + this.getName() + " has a class of "
               + this.classSize + " students ";
    }
    /**
     * Checks if this professor equals the object
     * override the equals method in Object class
     *
     * @param o an object
     * @return true if o is an instance of Professor and has the
     * exactly same name, age, hometown and classSize as this
     * object otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (!(super.equals(o))) {
            return false;
        }

        if (!(o instanceof Professor)) {
            return false;
        }

        Professor p = (Professor) o;

        if (p.classSize != this.classSize) {
            return false;
        }

        return true;
    }
}
/**
 * Represents a person who has name, age annd hometown
 *
 * @author nwang89
 * @version 1.0
 */



public class Person {
    private String name;
    private int age;
    private String homeTown;

    /**
     * Creates a Person
     *
     * @param name the name of person
     * @param age the age of person
     * @param homeTown the hometown of person
     *
     */
    public Person(String name, int age, String homeTown) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
    }
     /**
     * Creates a Person with default hometown
     *
     * @param name the name of person
     * @param age the age of person
     *
     */
    public Person(String name, int age) {
        this(name, age, "Atlanta");
    }
    /**
     * Creates a Person with default age and hometown
     *
     * @param name the name of person
     *
     */
    public Person(String name) {
        this(name, 18, "Atlanta");
    }
    /**
     * @return the name of person
     */
    public String getName() {
        return this.name;
    }
    /**
     * @return the age of person
     */
    public int getAge() {
        return this.age;
    }
    /**
     * @return the homeTown of person
     */
    public String getHometown() {
        return this.homeTown;
    }
    /**
     * @return a string of form "name is age year old from hometown"
     */
    public String toString() {
        return this.name + " is " + this.age
               + " years old from " + this.homeTown;
    }
    /**
     * Checks if this person equals the object
     * override the equals method in Object class
     *
     * @param o an object
     * @return true if o is an instance of Person and has the
     * exactly same name, age, and hometown as this Person,
     * otherwise return false
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }

        Person p = (Person) o;

        if (!(p.name.equals(this.name))) {
            return false;
        }

        if (p.age != this.age) {
            return false;
        }

        if (!(p.homeTown.equals(this.homeTown))) {
            return false;
        }

        return true;
    }
}
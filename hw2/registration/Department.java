package registration;

/**
 * Represents a department and its abbreviation
 *
 * @author nwang89
 * @version 1.0
 */

public enum Department {
    // value declaration must be the first statement in the type declaration
    COMPUTERSCIENCE("CS"),
    MATHEMATICS("MATH"),
    PHYSICS("PHYS"),
    ELECTRICALENGINEERING("EE"),
    LITERATUREMEDIAANDCOMMUNICATION("LMC");

    private String abbr;
    /**
     * Creates a Department
     *
     * @param abbr the abbreviation of the depatment
     */
    private Department(String abbr) {
        this.abbr = abbr;
    }
    /**
     * @return A string of the constant's abbreviation
     */
    public String toString() {
        return this.abbr;
    }
}
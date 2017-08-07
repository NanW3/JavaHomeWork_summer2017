/**
 * @author nwang89
 * @version 2.0
 */
public class Character implements Comparable<Character> {

    private String name;
    private int combatSkill;
    private int intelligenceLevel;
    private boolean hasSpecialPower;
    private int numDragons;
    private String message;
    /**
    * construct a Character
    * @param name the name of person
    * @param combatSkill combat ability of person
    * @param intelligenceLevel intelligence level of person
    * @param hasSpecialPower whether character has unusual powers
    * @param numDragons he number of dragons that character has
    * @param message a message that will appear when you find
    * the character
    */
    public Character(String name, int combatSkill,
                    int intelligenceLevel, boolean hasSpecialPower,
                    int numDragons, String message) {
        this.name = name;
        this.combatSkill = combatSkill;
        this.intelligenceLevel = intelligenceLevel;
        this.hasSpecialPower = hasSpecialPower;
        this.numDragons = numDragons;
        this.message = message;
    }
    /**
    * @return the name of person
    */
    public String getName() {
        return this.name;
    }
    /**
    * set the name of person
    * @param name the name of person
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
    * @return the combat ability of person
    */
    public int getCombatSkill() {
        return this.combatSkill;
    }
    /**
    * set the combat ability of person
    * @param combatSkill combat ability of person
    */
    public void setCombatSkill(int combatSkill) {
        this.combatSkill = combatSkill;
    }
    /**
    * @return the intelligence level of person
    */
    public int getIntelligenceLevel() {
        return this.intelligenceLevel;
    }
    /**
    * set the intelligence level of person
    * @param intelligenceLevel intelligence level of person
    */
    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }
    /**
    * @return the whether character has unusual powers
    */
    public boolean getHasSpecialPower() {
        return this.hasSpecialPower;
    }
    /**
    * set whether the character has special powers
    * @param hasSpecialPower whether character has unusual powers
    */
    public void setHasSpecialPower(boolean hasSpecialPower) {
        this.hasSpecialPower = hasSpecialPower;
    }
    /**
    * @return the number of dragons that character has
    */
    public int getNumDragons() {
        return this.numDragons;
    }
    /**
    * set the number of dragons
    * @param numDragons he number of dragons that character has
    */
    public void setNumDragons(int numDragons) {
        this.numDragons = numDragons;
    }
    /**
    * @return the message that will appear when you find
    * the character
    */
    public String getMessage() {
        return this.message;
    }
    /**
    * set the messgae of the person
    * @param message a message that will appear when you find
    * the character
    */
    public void setMessage(String message) {
        this.message = message;
    }
    /**
    * Should return a string in the format used in the below example.
    *
    * Name: Jon; Combat Skill: 4; Intel: 7; Special Power: no; Dragons: 0
    *
    * If hasSpecialPower is false, "Special Power: " should say no
    * afterward. If hasSpecialPower is true, "SpecialPower: "
    * should say yes afterward.
    * @return a String representation of the Character
    */
    public String toString() {
        return "Name: " + this.name + "; " + "Combat Skill: "
               + this.combatSkill + "; "
               + "Intel: " + this.intelligenceLevel + "; "
               + "Special Power: "
               + (this.hasSpecialPower ? "yes; " : "no; ")
               + "Dragons: " + this.numDragons;
    }

    /**
    * @override compareTo method in Comparable interface
    * @param c a Character
    * @return positive integer if the sum of combatSkill and
    * intelligenceLevel of this character is less than c's, return
    * a negative integer vice versa, return 0 if they are equal
    */
    @Override
    public int compareTo(Character c) {
        return (this.combatSkill + this.intelligenceLevel)
                - (c.combatSkill + c.intelligenceLevel);
    }

    /**
    * @override equals method in Object class
    * @param o an object
    * @return true if their names are equal, otherwise return false
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Character)) {
            return false;
        }

        Character c = (Character) o;
        return this.name.equals(c.getName());
    }

    /**
    * @return a hashcode of the character
    */
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + combatSkill;
        result = 31 * result + intelligenceLevel;
        result = 31 * result + (hasSpecialPower ? 1 : 0);
        result = 31 * result + numDragons;
        result = 31 * result + message.hashCode();
        return result;
    }

}
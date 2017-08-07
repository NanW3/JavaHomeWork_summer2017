import java.util.Comparator;
/**
* Minion class
* @author nwang89
* @version 1.0
*/
public class Minion implements Comparable<Minion> {

    private String name;
    private double height;
    private int iQLevel;
    /**
    * Construct a new Minion
    * @param name the name of minion
    * @param height the height of minion
    * @param iQLevel the IQ of minion
    */
    public Minion(String name, double height, int iQLevel) {
        this.name = name;
        this.height = height;
        this.iQLevel = iQLevel;
    }
    /**
    * @param o an object
    * @return true if o is equal to this minion
    */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof Minion)) {
            return false;
        }

        Minion m = (Minion) o;
        return this.name.equals(m.name)
               && this.height == m.height
               && this.iQLevel == m.iQLevel;
    }
    /**
    * @return a hashCode of this minion
    */
    @Override
    public int hashCode() {
        int result = 17;
        long temp = Double.doubleToLongBits(height);

        result += result * 31 + name.hashCode();
        result += result * 31 + (int) (temp ^ (temp >>> 32));
        result += result * 31 + iQLevel;
        return result;
    }
    /**
    * @param other another minion
    * @return negative number, positive number or zero by comparing
    * their name
    */
    @Override
    public int compareTo(Minion other) {
        return this.name.compareTo(other.name);
    }
    /**
    * @return a String representation in the format of
    *  "name has IQ of iQLevel and height of height cm."
    */
    @Override
    public String toString() {
        return String.format("%s has IQ of %d and height of %.2f cm",
                             name, iQLevel, height);
    }
    /**
    * @return a comparator that compares minions by IQ
    */
    public Comparator<Minion> compareByIQ() {
        return new Comparator<Minion>() {
            public int compare(Minion a, Minion b) {
                return a.iQLevel - b.iQLevel;
            }
        };
    }

     /**
    * @return a comparator that compares minions by height
    */
    public Comparator<Minion> compareByHeight() {
        return new Comparator<Minion>() {
            public int compare(Minion a, Minion b) {
                return Double.compare(a.height, b.height);
            }
        };
    }

}
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Rapidash
* @author Heather, nwang89
* @version 2
*/
public class Rapidash extends FireType {

    public static final int MAX_LEVEL = 150;
    private static int num = 0;

    /**
     * Constructor
     * @param x The X position of Rapidash
     * @param y The Y position of Rapidash
     * @param bounds The bounding Rectangle
     */
    public Rapidash(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/rapidash.png"));
        num++;
    }
    /**
     * @override the canReproduceWithPokemon() method
     * in Pokemon class
     * @param otherPokemon the Pokemon that this Pokemon
     * intends to reproduce with
     * @return true if otherPokemon are of the same
     * Pokemon species
     *
     */
    @Override
    public boolean canReproduceWithPokemon(Pokemon otherPokemon) {
        return otherPokemon instanceof Rapidash;
    }
    /**
     * @override the reproduceWithPokemon() method
     * in Pokemon class
     * @param otherPokemon a Pokemon instance
     * @return a new Pokemon of the same type in the same
     * location, if reproduction does not happen for some
     * reason, return null.
     * Give reproduction some random chance of occurring if
     * the Pokemon are colliding with each other.
     * the possibility of reproduction is 7%.(highest)
     * if the total number of venusaur is greater then 13
     * the reproduction is not permitted.
     */
    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (Math.random() < 0.07 && num < 13) {
            Pokemon baby = new Rapidash(this.getXPos(), this.getYPos(),
                                        this.getBounds());
            return baby;
        }
        return null;
    }
    /**
     * @override the isOld() methog in Pokemon class
     * @return whether or not the Pokemon instance has
     * surpassed some determined maximum level
     *
     */
    @Override
    public boolean isOld() {
        return this.getLevel() > MAX_LEVEL;
    }
    /**
     * @override the canHarmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current Pokemon instance
     * can harm an instance of the other Pokemon through combat
     * If a Rapidash is fighting a Fire type Pokemon and its
     * level is higher than that of the Pokemon it is fighting,
     * then it has a 90% chance of harming the other Fire type.
     * Otherwise, it has a 12% chance. If not fighting a Fire
     * type, Rapidash has the same chance of beating others as
     * any other Fire type.
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof FireType) {
            if (this.getLevel() > otherPokemon.getLevel()) {
                return (Math.random() < 0.9);
            } else {
                return (Math.random() < 0.12);
            }
        } else {
            return super.canHarmPokemon(otherPokemon);
        }
    }
    /**
     * @override the harmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * decrease the other Pokemon's health by -10
     *
     */
    @Override
    public void harmPokemon(Pokemon otherPokemon) {
        otherPokemon.increaseHealth(-10);
    }
    /**
     * @override the hasFainted method in Pokemon class
     * @return whether or not the Pokemon instance has
     * fainted.(health == 0 or they have exceeded maximum
     * level).
     * decease the number of instance by 1
     *
     */
    @Override
    public boolean hasFainted() {
        if (super.hasFainted()) {
            num--;
            return true;
        } else {
            return false;
        }
    }
}

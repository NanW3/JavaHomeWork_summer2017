import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
* Venusaur
* @author Heather, nwang89
* @version 2
*/
public class Venusaur extends GrassType {

    public static final int MAX_LEVEL = 50;
    private static int num = 0;

    /**
     * Constructor
     * @param x The X position of Venusaur
     * @param y The Y position of Venusaur
     * @param bounds The bounding Rectangle
     */
    public Venusaur(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
        setImage(new ImageIcon("../resources/venusaur.png"));
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
        return otherPokemon instanceof Venusaur;
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
     * the possibility of reproduction is 5%.
     * if the total number of venusaur is greater then 13
     * the reproduction is not permitted.
     */
    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (Math.random() < 0.05 && num < 13) {
            Pokemon baby = new Venusaur(this.getXPos(), this.getYPos(),
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
     * a Venusaur has a 10% higher chance of harming a Fire type
     * Pokemon than another Grass type Pokemon would be. It can
     * also harm a Poliwhirl 70% of the time, but it only has
     * normal Grass type hit rates against all other types and
     * species.
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof FireType) {
            return Math.random() < 0.3;
        } else if (otherPokemon instanceof Poliwhirl) {
            return Math.random() < 0.7;
        } else {
            return super.canHarmPokemon(otherPokemon);
        }

    }
    /**
     * @override the harmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * decrease the other Pokemon's health by -5
     *
     */
    @Override
    public void harmPokemon(Pokemon otherPokemon) {
        otherPokemon.increaseHealth(-5);
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

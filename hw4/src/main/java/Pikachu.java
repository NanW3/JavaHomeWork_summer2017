import java.awt.Rectangle;
import javax.swing.ImageIcon;
/**
* Pikachu
* @author nwang89
* @version 1
*/
public class Pikachu extends ElectricType {

    public static final int MAX_LEVEL = 100;
    private static int num = 0;
    /**
     * Constructor
     * @param xPos The X position of Poliwhirl
     * @param yPos The Y position of Poliwhirl
     * @param bounds The bounding Rectangle
     */
    public Pikachu(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        setImage(new ImageIcon("../resources/pikachu.png"));
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
        return otherPokemon instanceof Pikachu;
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
     * the possibility of reproduction is 6%.
     * if the total number of venusaur is greater then 13
     * the reproduction is not permitted.
     */
    @Override
    public Pokemon reproduceWithPokemon(Pokemon otherPokemon) {
        if (Math.random() < 0.06 && num < 13) {
            Pokemon baby = new Pikachu(this.getXPos(), this.getYPos(),
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
     * If a Pikachu is fighting an Water type Pokemon, its chance
     * of harming is 10% greater than its chance of harming any
     * other Water type Pokemon. Otherwise, its chances of
     * harming a Pokemon are equivalent to those of other Electric
     * type Pokemon.
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        if (otherPokemon instanceof WaterType) {
            return Math.random() < 0.7;
        }
        return super.canHarmPokemon(otherPokemon);
    }
    /**
     * @override the harmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * decrease the other Pokemon's health by -20
     *
     */
    @Override
    public void harmPokemon(Pokemon otherPokemon) {
        otherPokemon.increaseHealth(-20);
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
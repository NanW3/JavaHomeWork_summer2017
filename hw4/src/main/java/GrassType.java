import java.awt.Rectangle;
import java.util.Random;
/**
 * A grass type pokemon
 *
 * @author Farhan Tejani, nwang89
 * @version 2
 */
public abstract class GrassType extends Pokemon {


    /**
     * Constructor
     * @param x The X position of the Grass type Pokemon
     * @param y The Y position of the Grass type Pokemon
     * @param bounds The bounding Rectangle
     */
    public GrassType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }
    /**
    * @override the move() method in Pokemon class
    * Every time it moves, its level increases by 1
    * when it is in its green quadrant(top-left), it
    * gain health rather than lose it.
    */
    @Override
    public void move() {
        super.move();
        this.increaseLevel(1);

        int recW = (int) this.getBounds().getWidth();
        int recH = (int) this.getBounds().getHeight();
        int imaW = this.getImage().getIconWidth();
        int imaH = this.getImage().getIconHeight();
        int x = this.getXPos();
        int y = this.getYPos();

        if (x >= 0 && x <= recW / 2
            && y >= 0 && y <= recH / 2) {
            this.increaseHealth(1);
        } else {
            this.increaseHealth(-1);
        }
    }
    /**
     * @override the canHarmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current Pokemon instance
     * can harm an instance of the other Pokemon through combat
     * GrassType has a greater chance of harming WaterType and
     * a lesser chance of harming a FireType.
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        Random rand = new Random();
        if (otherPokemon instanceof WaterType) {
            return rand.nextInt(100) < 80;
        }

        if (otherPokemon instanceof FireType) {
            return rand.nextInt(100) < 20;
        }

        if (otherPokemon instanceof ElectricType) {
            return rand.nextInt(100) < 30;
        }

        return super.canHarmPokemon(otherPokemon);
    }
}

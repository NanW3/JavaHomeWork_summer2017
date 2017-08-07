import java.awt.Rectangle;
import java.util.Random;
/**
 * A water type pokemon
 *
 * @author Farhan Tejani, nwang89
 * @version 2
 */
public abstract class WaterType extends Pokemon {

    /**
     * Constructor
     * @param x The X position of this Water Type Pokemon
     * @param y The Y position of this Water Type Pokemon
     * @param bounds The bounding Rectangle
     */
    public WaterType(int x, int y, Rectangle bounds) {
        super(x, y, bounds);
    }

    /**
    * @override the move() method in Pokemon class
    * Every time it moves, its health decreases by 1
    * when it is in blue quadreant(bottom left), its
    * level up more rapidly, increases by 5, while its
    * level increases by 1 in other areas of the map
    */
    @Override
    public void move() {
        super.move();
        this.increaseHealth(-1);

        int recW = (int) this.getBounds().getWidth();
        int recH = (int) this.getBounds().getHeight();
        int imaW = this.getImage().getIconWidth();
        int imaH = this.getImage().getIconHeight();
        int x = this.getXPos();
        int y = this.getYPos();

        if (x >= 0 && x <= recW / 2
            && y >= recH / 2 && y + imaH < recH) {
            this.increaseLevel(5);
        } else {
            this.increaseLevel(1);
        }
    }
    /**
     * @override the canHarmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current Pokemon instance
     * can harm an instance of the other Pokemon through combat
     * WaterType has a greater chance of harming a FireType and a
     * lesser chance of harming a GrassType
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {
        Random rand = new Random();
        if (otherPokemon instanceof FireType) {
            return rand.nextInt(100) < 80;
        }

        if (otherPokemon instanceof GrassType) {
            return rand.nextInt(100) < 20;
        }

        if (otherPokemon instanceof ElectricType) {
            return rand.nextInt(100) < 40;
        }

        return super.canHarmPokemon(otherPokemon);
    }
}

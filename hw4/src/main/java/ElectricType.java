import java.awt.Rectangle;
/**
 * A Electric type pokemon
 *
 * @author Farhan Tejani, nwang89
 * @version 2
 */
public abstract class ElectricType extends Pokemon {

    private double chance;

    /**
     * Constructor
     * @param xPos The X position of this Fire type
     * @param yPos The Y position of this Fire type
     * @param bounds The bounding Rectangle
     */
    public ElectricType(int xPos, int yPos, Rectangle bounds) {
        super(xPos, yPos, bounds);
        this.chance = 0;
    }
    /**
    * @override the move() method in Pokemon class
    * Every time it moves, its level increases by 1
    * its health decreases by 1
    */
    @Override
    public void move() {
        super.move();
        this.increaseLevel(1);
        this.increaseHealth(-1);
    }
    /**
     * @override the canHarmPokemon() method in Pokemon class
     * @param otherPokemon a Pokemon instance
     * @return whether or not the current Pokemon instance
     * can harm an instance of the other Pokemon through combat
     * if it is in its white area (bottom-right), the chance of
     * harming other types of Pokemon increases 50%. Its chance
     * harming other types of Pokemon remains the same in other
     * areas of the map.
     *
     */
    @Override
    public boolean canHarmPokemon(Pokemon otherPokemon) {

        int recW = (int) this.getBounds().getWidth();
        int recH = (int) this.getBounds().getHeight();
        int imaW = this.getImage().getIconWidth();
        int imaH = this.getImage().getIconHeight();
        int x = this.getXPos();
        int y = this.getYPos();

        if (x >= recW / 2 && x + imaW < recW
            && y > recH / 2 && y + imaH < recH) {
            this.chance = 0.5;
        }

        if (otherPokemon instanceof FireType) {
            return Math.random() < 0.3 * (1 + chance);
        }

        if (otherPokemon instanceof WaterType) {
            return Math.random() < 0.6 * (1 + chance);
        }

        if (otherPokemon instanceof GrassType) {
            return Math.random() < 0.7 * (1 + chance);
        }

        return super.canHarmPokemon(otherPokemon);
    }
}
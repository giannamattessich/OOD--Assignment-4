/**
 * A class representing a single pixel.
 */
public class Pixel {
    private int red;
    private int green;
    private int blue;

    /**
     * Constructs a pixel with the given red, green, and blue values.
     *
     * @param red   the red value
     * @param green the green value
     * @param blue  the blue value
     */
    public Pixel(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    /**
     * Returns the red value of this pixel.
     *
     * @return the red value
     */
    public int getRed() {
        return red;
    }

    /**
     * Returns the green value of this pixel.
     *
     * @return the green value
     */
    public int getGreen() {
        return green;
    }

    /**
     * Returns the blue value of this pixel.
     *
     * @return the blue value
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Returns a string representation of this pixel.
     *
     * @return a string representation of this pixel
     */
    public String toString() {
        return "(" + red + ", " + green + ", " + blue + ")";
    }
}
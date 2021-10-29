package model;

import java.util.Objects;

/**
 * Class to represent a single image pixel with red, green, and blue components.
 */
public class Pixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Constructor for a single pixel object.
   *
   * @param red   represents red channel.
   * @param green represents green channel.
   * @param blue  represents blue channel.
   */
  public Pixel(int red, int green, int blue) throws IllegalArgumentException {
    if ((red < 0) || (green < 0) || (blue < 0)) {
      throw new IllegalArgumentException("model.Pixel components cannot be negative.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Pixel)) {
      return false;
    } else {
      Pixel that = (Pixel) obj;
      return ((this.red == that.red) &&
              (this.green == that.green) &&
              (this.blue == that.blue));
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.red, this.blue, this.green);
  }

  /**
   * Method to get single pixel value(which is the maximum value of the
   * 3 channels).
   *
   * @return value of a pixel.
   */
  public int getPixelValue() {
    return Math.max(Math.max(this.red, this.green), this.blue);
  }

  /**
   * Method to get the intensity of a single pixel.
   * model.Pixel intensity is the average of the 3 channels.
   *
   * @return pixel intensity.
   */
  public int getPixelIntensity() {
    return ((this.red + this.green + this.blue) / 3);
  }

  /**
   * Method to get the luma of a single pixel.
   * model.Pixel luma is the weighted sum derived from the formula: 0.2126𝑟+0.7152𝑔+0.0722𝑏.
   *
   * @return pixel luma.
   */
  public int getPixelLuma() {
    return (int) ((0.2126 * (this.red)) + (0.7152 * (this.green)) +
            (0.0722 * (this.blue)));
  }

  /**
   * Method which visualizes the red component of a pixel by creating a corresponding
   * greyscale pixel.
   *
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeRedChannel() {
    return new Pixel(this.red, this.red, this.red);
  }

  /**
   * Method which visualizes the red component of a pixel by creating a corresponding
   * greyscale pixel.
   *
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeGreenChannel() {
    return new Pixel(this.green, this.green, this.green);
  }

  /**
   * Method which visualizes the red component of a pixel by creating a corresponding
   * greyscale pixel.
   *
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeBlueChannel() {
    return new Pixel(this.blue, this.blue, this.blue);
  }


}


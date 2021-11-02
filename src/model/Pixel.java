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
    if (((red < 0) || (red > 255)) || ((green < 0) || (green > 255)) ||
            ((blue < 0) || (blue > 255))) {
      throw new IllegalArgumentException("Pixel components cannot be negative or" +
              " above 8-bit depth.");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

   /**
   * Method which visualizes the red component of a pixel by creating a
   * corresponding greyscale pixel.
   *
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeRedChannel() {
    return new Pixel(this.red, this.red, this.red);
  }

  /**
   * Method which visualizes the red component of a pixel by creating a
   * corresponding greyscale pixel.
   *
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeGreenChannel() {
    return new Pixel(this.green, this.green, this.green);
  }

  /**
   * Method which visualizes the red component of a pixel by creating a
   * corresponding greyscale pixel.
   *
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeBlueChannel() {
    return new Pixel(this.blue, this.blue, this.blue);
  }

  /**
   * Method which visualizes the luminance of a pixel by creating a corresponding
   * greyscale pixel.
   * 
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeLuma() {
    return new Pixel(this.getPixelLuma(), this.getPixelLuma(), this.getPixelLuma());
  }

  /**
   * Method which visualizes the intensity of a pixel by creating a corresponding
   * greyscale pixel.
   * 
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeIntensity() {
    return new Pixel(this.getPixelIntensity(), this.getPixelIntensity(), this.getPixelIntensity());
  }

  /**
   * Method which visualizes the value of a pixel by creating a corresponding
   * greyscale pixel.
   * 
   * @return corresponding greyscale pixel.
   */
  public Pixel visualizeValue() {
    return new Pixel(this.getPixelValue(), this.getPixelValue(), this.getPixelValue());
  }

  /**
   * Method to get red component of pixel.
   * @return red component.
   */
  public int getRed() {
    return this.red;
  }

  /**
   * Method to get green component of pixel.
   * @return green component.
   */
  public int getGreen() {
    return this.green;
  }

  /**
   * Method to get blue component of pixel.
   * @return blue component.
   */
  public int getBlue() {
    return this.blue;
  }

  /**
   * Method to set red component of pixel
   * @param red represents new red component value.
   */
  public void setRed(int red) {
    this.red = red;
  }

  /**
   * Method to set green component of pixel
   * @param green represents new red component value.
   */
  public void setGreen(int green) {
    this.green = green;
  }

  /**
   * Method to set blue component of pixel
   * @param blue represents new blue component value.
   */
  public void setBlue(int blue) {
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
   * Method which brightens a pixel by increasing the value of each channel by a
   * given amount. If the final value of any channel exceeds 255, the channel is
   * set to 255. If the final value of any channel is less than 0, the channel is
   * set to 0.
   *
   * @param amount represents the amount by which the pixel is to be brightened.
   * @return brightened pixel.
   */
  public Pixel brighten(int amount) {
    int newRed = this.red + amount;
    int newGreen = this.green + amount;
    int newBlue = this.blue + amount;
    if (newRed > 255) {
      newRed = 255;
    }
    if (newGreen > 255) {
      newGreen = 255;
    }
    if (newBlue > 255) {
      newBlue = 255;
    }
    if (newRed < 0) {
      newRed = 0;
    }
    if (newGreen < 0) {
      newGreen = 0;
    }
    if (newBlue < 0) {
      newBlue = 0;
    }
    return new Pixel(newRed, newGreen, newBlue);
  }
}


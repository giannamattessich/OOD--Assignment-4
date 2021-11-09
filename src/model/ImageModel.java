package model;

import java.util.Arrays;
import java.util.Objects;
import model.imagetransformations.ImageProcessor;

/**
 * Class to implement image interface. Provides operations that operate on pixels
 * of a model.
 */
public class ImageModel implements Image {
  private Pixel[][] imagePixels;

  /**
   * Creates an Image from the given 2D matrix of Pixels.
   *
   * @param imagePixels the 2D array of Pixels containing the pixel values of this Image.
   */
  public ImageModel(Pixel[][] imagePixels) {
    this.imagePixels = imagePixels;
  }

  @Override
  public Pixel getPixelAt(int row, int col) {
    int red = this.imagePixels[row][col].getRed();
    int green = this.imagePixels[row][col].getGreen();
    int blue = this.imagePixels[row][col].getBlue();
    return new Pixel(red, green, blue);
  }

  @Override
  public void setPixelAt(int row, int col, int red, int green, int blue) {
    Pixel p = this.imagePixels[row][col];
    p.setRed(red);
    p.setGreen(green);
    p.setBlue(blue);
    this.imagePixels[row][col] = p;
  }

  @Override
  public void setImagePixels(Pixel[][] pixels) {
    this.imagePixels = pixels;
  }

  @Override
  public Pixel[][] getImagePixels() {
    Pixel[][] result = new Pixel[getHeight()][getWidth()];
    for (int i = 0; i < getHeight(); i++) {
      for (int j = 0; j < getWidth(); j++) {
        result[i][j] = this.imagePixels[i][j];
      }
    }
    return result;
  }

  @Override
  public int getWidth() {
    return this.imagePixels[0].length;
  }

  @Override
  public int getHeight() {
    return this.imagePixels.length;
  }

  @Override
  public Image changeImage(ImageProcessor cmd) {
    return cmd.process(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Image)) {
      return false;
    } else {
      Image that = (Image) obj;
      return Arrays.deepEquals(this.imagePixels, that.getImagePixels());
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(Arrays.deepHashCode(this.getImagePixels()));
  }
}

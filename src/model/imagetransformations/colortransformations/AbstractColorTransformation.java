package model.imagetransformations.colortransformations;

import model.Image;
import model.ImageModel;
import model.Pixel;

/**
 * Abstract class for a color transformation of an image.
 */
public abstract class AbstractColorTransformation implements ColorTransformations {
  protected double[][] colorMatrix;

  /**
   * Constructor for an abstract color transformation, which includes multiplying individual pixels
   * to a color matrix.
   *
   */
  public AbstractColorTransformation() {
    this.colorMatrix = initColorMat();
  }

  protected abstract double[][] initColorMat();

  /**
   * Multiplies color transformation matrix to rgb values of a pixel.
   *
   * @param p is pixel to be multiplied.
   * @return new pixel representing result after multiplying color transformation matrix.
   */
  protected Pixel multiplyMatrix(Pixel p) {
    int[] result = new int[colorMatrix.length];
    double multiCol = 0;
    for (int i = 0; i < colorMatrix.length; i++) {

      multiCol += colorMatrix[i][0] * p.getRed();
      multiCol += colorMatrix[i][1] * p.getGreen();
      multiCol += colorMatrix[i][2] * p.getBlue();

      result[i] = (int) multiCol;
    }
    int red = result[0];
    int green = result[1];
    int blue = result[2];
    red = Math.min(255, red);
    green = Math.min(255, green);
    blue = Math.min(255, blue);
    return new Pixel(red, green, blue);
  }

  @Override
  public Image process(Image orgImg) {
    Image result = new ImageModel(orgImg.getImagePixels());
    Pixel[][] newPixels = new Pixel[result.getHeight()][result.getWidth()];
    for (int i = 0; i < result.getHeight(); i++) {
      for (int j = 0; j < result.getWidth(); j++) {
        int newRed = multiplyMatrix(orgImg.getPixelAt(i, j)).getRed();
        int newGreen = multiplyMatrix(orgImg.getPixelAt(i, j)).getGreen();
        int newBlue = multiplyMatrix(orgImg.getPixelAt(i, j)).getBlue();
        newRed = Math.min(255, newRed);
        newGreen = Math.min(255, newGreen);
        newBlue = Math.min(255, newBlue);
        newPixels[i][j] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new ImageModel(newPixels);
  }
}

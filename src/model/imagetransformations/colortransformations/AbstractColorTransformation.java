package model.imagetransformations.colortransformations;

import model.Image;
import model.ImageModel;
import model.Pixel;

/**
 * Abstract class for a color transformation of an image.
 */
public class AbstractColorTransformation implements ColorTransformations {
  double[][] colorMatrix;

  /**
   * Constructor for an abstract color transformation, which includes multiplying individual pixels
   * to a color matrix.
   *
   * @param colorMatrix represents colormatrix for each distinct type of color transformation.
   */
  public AbstractColorTransformation(double[][] colorMatrix) {
    this.colorMatrix = colorMatrix;
  }

  /**
   * Multiplies color transformation matrix to rgb values of a pixel.
   *
   * @param p is pixel to be multiplied.
   * @return new pixel representing result after multiplying color transformation matrix.
   */
  protected Pixel multiplyMatrix(Pixel p) {
    int[] result = new int[colorMatrix.length];
    for (int i = 0; i < colorMatrix.length; i++) {
      double multCol = 0;

      multCol += colorMatrix[i][0] * p.getRed();
      multCol += colorMatrix[i][1] * p.getGreen();
      multCol += colorMatrix[i][2] * p.getBlue();

      result[i] = (int) multCol;
    }
    int red = result[0];
    int green = result[1];
    int blue = result[2];
    return new Pixel(red, green, blue);
  }

  @Override
  public Image process(Image orgImg) {
    Pixel[][] newPixels = new Pixel[orgImg.getHeight()][orgImg.getWidth()];
    for (int i = 0; i < orgImg.getHeight(); i++) {
      for (int j = 0; j < orgImg.getWidth(); j++) {
        int newRed = multiplyMatrix(orgImg.getPixelAt(i, j)).getRed();
        int newGreen = multiplyMatrix(orgImg.getPixelAt(i, j)).getGreen();
        int newBlue = multiplyMatrix(orgImg.getPixelAt(i, j)).getBlue();
        if (newRed > 255) {
          newRed = 255;
        } else if (newGreen > 255) {
          newGreen = 255;
        } else if (newBlue > 255) {
          newBlue = 255;
        }
        newPixels[i][j] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return new ImageModel(newPixels);
  }
}

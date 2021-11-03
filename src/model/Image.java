package model;

import model.ImageTransformations.ImageProcessor;

/**
 * Interface that represents an Image Object. Upon construction of an Image
 * object, the image will load.
 */
public interface Image {

  /**
   * Returns pixel at given position.
   *
   * @param row represents row x-value of position.
   * @param col represents y-value of a position.
   * @return pixel at position.
   */
  Pixel getPixelAt(int row, int col);

  /**
   * Sets pixel to specified arguments at specified position.
   *
   * @param row   of pixel.
   * @param col   of pixel.
   * @param red   component of pixel.
   * @param green component of pixel.
   * @param blue  component of pixel.
   */
  void setPixelAt(int row, int col, int red, int green, int blue);

  /**
   * Gets Pixels of image.
   *
   * @return pixels of image;
   */
  Pixel[][] getImagePixels();

  /**
   * Gets width of image.
   *
   * @return width.
   */
  int getWidth();

  /**
   * Gets height of image.
   *
   * @return height.
   */
  int getHeight();

  /**
   * Applies specified ImageProcessor transformation on this image and returns new image
   * with transformation applied.
   *
   * @param cmd transformation to be applied.
   * @return image with transformation applied.
   */
  public Image changeImage(ImageProcessor cmd);

  @Override
  public boolean equals(Object obj);

  @Override
  public int hashCode();

}


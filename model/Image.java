package model;

/**
 * Interface that represents an Image Object. Upon construction of an Image
 * object, the image will load. Users can call command-line arguments to
 * perform operations on an image.
 */
public interface Image {

  /**
   * Sets filename of image.
   *
   * @param fileName is name of image.
   */
  public void setFileName(String fileName);

  /**
   * Gets filename of an image.
   *
   * @return filename of image.
   */
  public String getFileName();

  /**
   * Sets filepath of image.
   * @param filePath is file path for image.
   */
  public void setFilePath(String filePath);

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
   * Method to create greyscale image to visualize red component of pixel.
   *
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image createRedGreyScale(Image orgIm);

  /**
   * Method to create greyscale image to visualize green component of pixel.
   *
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image createGreenGreyScale(Image orgIm);

  /**
   * Method to create greyscale image to visualize blue component of pixel.
   *
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image createBlueGreyScale(Image orgIm);

  /**
   * Method to create greyscale image to visualize value of pixel.
   *
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image createValueGreyScale(Image orgIm);

  /**
   * Method to create greyscale image to visualize luma of pixel.
   *
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image createLumaGreyScale(Image orgIm);

  /**
   * Method to create greyscale image to visualize intensity of pixel.
   *
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image createIntensityGreyScale(Image orgIm);

  /**
   * Method to create brightened image.
   *
   * @param orgIm     original image to be processed.
   * @param increment increment by which to brighten image.
   * @return new image with process applied to original image.
   */
  Image brightenImage(Image orgIm, int increment);

  /**
   * Method to flip an image vertically.
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image verticalFlipImage(Image orgIm);

  /**
   * Method to flip an image horizontally.
   * @param orgIm original image to be processed.
   * @return new image with process applied to original image.
   */
  Image horizontalFlipImage(Image orgIm);
}

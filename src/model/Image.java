package model;

/**
 * Interface that represents an Image Object. Upon construction of an Image
 * object, the image will load. Users can call command-line arguments to perform
 * operations on an image.
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
  void setPixelAt(int row, int col, Pixel pixel);

  /**
   * Gets Pixels of image.
   *
   * @return pixels of image;
   */
  Pixel[][] getImagePixels();
  
  /**
   * Sets pixels of image.
   */
  void setImagePixels(Pixel[][] pixels);

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
   */
  void redComponent();

  /**
   * Method to create greyscale image to visualize green component of pixel.
   *
   */
  void greenComponent();

  /**
   * Method to create greyscale image to visualize blue component of pixel.
   *
   */
  void blueComponent();

  /**
   * Method to create greyscale image to visualize value of pixel.
   *
   */
  void valueComponent();

  /**
   * Method to create greyscale image to visualize luma of pixel.
   *
   */
  void lumaComponent();

  /**
   * Method to create greyscale image to visualize intensity of pixel.
   *
   */
  void intensityComponent();

  /**
   * Method to create brightened image.
   *
   * @param constant increment by which to brighten image.
   */
  void brighten(int constant);

  /**
   * Method to create darkened image.
   *
   * @param constant increment by which to darken image.
   */
  void darken(int constant);

  /**
   * Method to flip an image vertically.
   * 
   */
  void flipVertical();

  /**
   * Method to flip an image horizontally.
   * 
   */
  void flipHorizontal();
}

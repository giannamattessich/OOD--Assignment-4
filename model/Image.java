package model;

/**
 * Interface that represents an Image Object. Upon construction of an Image
 * object, the image will load. Users can call command-line arguments to
 * perform operations on an image.
 */
public interface Image {
  public void loadImage(String filePath, String fileName);

  public void saveImage(String filePath, String fileName);

  public Pixel getPixelAt(int row, int col);

  public Image createRedImage()
}

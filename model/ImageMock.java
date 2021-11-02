package model;

public class ImageMock extends AbstractImage {

  /**
   * Constructor for an abstract image.
   *
   * @param filePath
   * @param fileName is the file provided by user.
   */
  public ImageMock(String filePath, String fileName) {
    super(filePath, fileName);
  }

  @Override
  protected void initImage(String filePath) {

  }

  @Override
  public void loadImage(String filePath, String fileName) {
    return null;
  }

  @Override
  public void saveImage(String filePath, String fileName) {

  }
}

package model;

public class ImageMock extends ImageImpl {

  private StringBuilder log = new StringBuilder();

  /**
   * Constructor for an abstract image.
   *
   * @param fileName is the file provided by user.
   */
  public ImageMock(String fileName) {
    super(fileName);
  }

  
  /** 
   * This method is used to get the log.
   * For the method getPixelAt.
   * @param row is the row of the pixel.
   * @param col is the column of the pixel.
   * @return Pixel is the pixel at the given row and column.
   */
  @Override
  public Pixel getPixelAt(int row, int col) {
    log.append("getPixelAt(" + row + ", " + col + ")");
    return super.getPixelAt(row, col);
  }

  
  /** 
   * This method is used to get the log.
   * For the method getHeight.
   * @return int is the height of the image.
   */
  @Override
  public int getHeight() {
    log.append("getHeight()");
    return super.getHeight();
  }

  
  /** 
   * This method is used to get the log.
   * For the method setFileName.
   * @param fileName is the file provided by user.
   */
  @Override
  public void setFileName(String fileName) {
    log.append("setFileName(" + fileName + ")");
    super.setFileName(fileName);
  }

  
  /** 
   * This method is used to get the log.
   * For the method getImagePixels.
   * @return Pixel[][]
   */
  @Override
  public Pixel[][] getImagePixels() {
    log.append("getImagePixels()");
    return super.getImagePixels();
  }

  /**
   * This method is used to get the log.
   * For the method setImagePixels.
   * @param imagePixels is the pixel array.
   */
  @Override
  public void setImagePixels(Pixel[][] pixels) {
    log.append("setImagePixels(" + pixels + ")");
    super.setImagePixels(pixels);
  }

  /**
   * This method is used to get the log.
   * For the method setPixelAt.
   * @param row is the row of the pixel.
   * @param col is the column of the pixel.
   * @param pixel is the pixel at the given row and column.
   */
  @Override
  public void setPixelAt(int row, int col, Pixel pixel) {
    log.append("setPixelAt(" + row + ", " + col + ", " + pixel + ")");
    super.setPixelAt(row, col, pixel);
  }

  /**
   * This method is used to get the log.
   * For the method flipVertical.
   */
  @Override
  public void flipVertical() {
    log.append("flipVertical()");
    super.flipVertical();
  }

  /**
   * This method is used to get the log.
   * For the method flipHorizontal.
   */
  @Override
  public void flipHorizontal() {
    log.append("flipHorizontal()");
    super.flipHorizontal();
  }

  /**
   * This method is used to get the log.
   * For the method brighten.
   * @param factor is the factor of the brightness.
   */
  @Override
  public void brighten(int factor) {
    log.append("brighten(" + factor + ")");
    super.brighten(factor);
  }

  /**
   * This method is used to get the log.
   * For the method darken.
   * @param factor is the factor of the brightness.
   */
  @Override
  public void darken(int factor) {
    log.append("darken(" + factor + ")");
    super.darken(factor);
  }

  /**
   * This method is used to get the log.
   * For the method redComponent().
   */
  @Override
  public void redComponent() {
    log.append("redComponent()");
    super.redComponent();
  }

  /**
   * This method is used to get the log.
   * For the method greenComponent().
   */
  @Override
  public void greenComponent() {
    log.append("greenComponent()");
    super.greenComponent();
  }

  /**
   * This method is used to get the log.
   * For the method blueComponent().
   */
  @Override
  public void blueComponent() {
    log.append("blueComponent()");
    super.blueComponent();
  }

  /**
   * This method is used to get the log.
   * For the method lumaComponent().
   */
  @Override
  public void lumaComponent() {
    log.append("lumaComponent()");
    super.lumaComponent();
  }

  /**
   * This method is used to get the log.
   * For the method intensityComponent().
   */
  @Override
  public void intensityComponent() {
    log.append("intensityComponent()");
    super.intensityComponent();
  }

  /**
   * This method is used to get the log.
   * For the method valueComponent().
   */
  @Override
  public void valueComponent() {
    log.append("valueComponent()");
    super.valueComponent();
  }
  

}

package model;

/**
 * Abstract class to represent images of different file types.
 */
public abstract class AbstractImage implements Image {
  protected String fileName;
  protected int width;
  protected int height;
  protected int maxColorVal;
  protected Pixel[][] imagePixels;

  /**
   * Constructor for an abstract image.
   *
   * @param filePath is the file provided by user.
   */
  public AbstractImage(String fileName) {
    this.fileName = fileName;
  }

  public Pixel getPixelAt(int row, int col) {
    return this.imagePixels[row][col];
  }

  public int getHeight() {
    return this.height;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  @Override
  public Pixel[][] getImagePixels() {
    return this.imagePixels;
  }

  @Override
  public void setImagePixels(Pixel[][] pixels) {
    this.imagePixels = pixels;
  }

  @Override
  public void setPixelAt(int row, int col, Pixel pixel) {
    this.imagePixels[row][col] = pixel;
  }

  /**
   * Flips the image vertically.
   */
  public void flipVertical() {
    Pixel[][] temp = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        temp[i][j] = this.imagePixels[this.height - i - 1][j];
      }
    }
    this.imagePixels = temp;
  }

  /**
   * Flips the image horizontally.
   */
  public void flipHorizontal() {
    Pixel[][] temp = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        temp[i][j] = this.imagePixels[i][this.width - j - 1];
      }
    }
    this.imagePixels = temp;
  }

  /**
   * Brightens the image by adding a constant to RGB values within each pixel.
   * Will not exceed 255 for any RGB value once added.
   *
   * @param constant is the amount to add to each RGB value.
   */
  public void brighten(int constant) {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j].brighten(constant);
      }
    }
  }

  /**
   * Darkens the image by subtracting a constant from RGB values within each
   * pixel. Will not go below 0 for any RGB value once subtracted.
   *
   * @param constant is the amount to subtract from each RGB value.
   *
   */
  public void darken(int constant) {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j].brighten(-1 * constant);
      }
    }
  }

  /**
   * Visualize the red channel of the image in greyscale.
   */
  public void redComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeRedChannel();
      }
    }
  }

  /**
   * Visualize the green channel of the image in greyscale.
   */
  public void greenComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeGreenChannel();
      }
    }
  }

  /**
   * Visualize the blue channel of the image in greyscale.
   */
  public void blueComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeBlueChannel();
      }
    }
  }

  /**
   * Visualize the luma channel of the image in greyscale.
   */
  public void lumaComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeLuma();
      }
    }
  }

  /**
   * Visualize the intensity channel of the image in greyscale.
   */
  public void intensityComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeIntensity();
      }
    }
  }

  /**
   * Visualize the value channel of the image in greyscale.
   */
  public void valueComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeValue();
      }
    }
  }

  /**
   * Get the name of the image.
   */
  public String getFileName() {
    return fileName;
  }

  @Override
  public int getWidth() {
    return this.width;
  }

}

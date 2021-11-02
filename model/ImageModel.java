package model;

/**
 * Class to implement image interface. Provides operations that operate on pixels
 * of a model.
 */
public class ImageModel implements Image {
  private final Pixel[][] imagePixels;
  private String imagePath;
  private String imageName;

  /**
   * Creates an Image from the given 2D matrix of Pixels.
   *
   * @param imagePixels the 2D array of Pixels containing the pixel values of this Image.
   */
  public ImageModel(Pixel[][] imagePixels) {
    this.imagePixels = imagePixels;
    this.imageName = "default";
    this.imagePath = "default";
  }

  /**
   * Sets filename of image.
   *
   * @param fileName is name of image.
   */
  public void setFileName(String fileName) {
    this.imageName = fileName;
  }

  /**
   * Gets filename of an image.
   *
   * @return filename of image.
   */
  public String getFileName() {
    return this.imageName;
  }

  /**
   * Sets filepath of image.
   *
   * @param filePath is file path for image.
   */
  public void setFilePath(String filePath) {
    this.imagePath = filePath;
  }

  @Override
  public Pixel getPixelAt(int row, int col) {
    return this.imagePixels[row][col];
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
  public Pixel[][] getImagePixels() {
    Pixel[][] result = this.imagePixels;
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
  public Image createRedGreyScale(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        int red = resultImage.getPixelAt(i, j).getRed();
        resultImage.setPixelAt(i, j, red, red, red);
      }
    }
    return resultImage;
  }

  @Override
  public Image createGreenGreyScale(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        int green = resultImage.getPixelAt(i, j).getGreen();
        resultImage.setPixelAt(i, j, green, green, green);
      }
    }
    return resultImage;
  }

  @Override
  public Image createBlueGreyScale(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        int blue = resultImage.getPixelAt(i, j).getBlue();
        resultImage.setPixelAt(i, j, blue, blue, blue);
      }
    }
    return resultImage;
  }

  @Override
  public Image createValueGreyScale(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        int value = resultImage.getPixelAt(i, j).getPixelValue();
        resultImage.setPixelAt(i, j, value, value, value);
      }
    }
    return resultImage;
  }

  @Override
  public Image createLumaGreyScale(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        int luma = resultImage.getPixelAt(i, j).getPixelLuma();
        resultImage.setPixelAt(i, j, luma, luma, luma);
      }
    }
    return resultImage;
  }

  @Override
  public Image createIntensityGreyScale(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        int intensity = resultImage.getPixelAt(i, j).getPixelIntensity();
        resultImage.setPixelAt(i, j, intensity, intensity, intensity);
      }
    }
    return resultImage;
  }

  @Override
  public Image brightenImage(Image orgIm, int increment) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        resultImage.getImagePixels()[i][j] = resultImage.getPixelAt(i, j).brighten(increment);
      }
    }
    return resultImage;
  }

  @Override
  public Image verticalFlipImage(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        Pixel flippedPixel = resultImage.getPixelAt(j, ((givenHeight - 1) - i));
        int flippedRed = flippedPixel.getRed();
        int flippedGreen = flippedPixel.getGreen();
        int flippedBlue = flippedPixel.getBlue();
        resultImage.setPixelAt(i, j, flippedRed, flippedGreen, flippedBlue);
      }
    }
    return resultImage;
  }

  @Override
  public Image horizontalFlipImage(Image orgIm) {
    Image resultImage = new ImageModel(orgIm.getImagePixels());
    int givenHeight = orgIm.getHeight();
    int givenWidth = orgIm.getWidth();
    for (int i = 0; i < givenHeight; i++) {
      for (int j = 0; j < givenWidth; j++) {
        Pixel flippedPixel = resultImage.getPixelAt(((givenWidth - 1) - j), i);
        int flippedRed = flippedPixel.getRed();
        int flippedGreen = flippedPixel.getGreen();
        int flippedBlue = flippedPixel.getBlue();
        resultImage.setPixelAt(i, j, flippedRed, flippedGreen, flippedBlue);
      }
    }
    return resultImage;
  }
}

package model.imagetransformations.colortransformation;

import model.Image;
import model.ImageModel;
import model.imagetransformations.ImageProcessor;

/**
 * Abstract class to represent the different greyscale transformations.
 * Transformation types included in greyScaleType enum. Possible transformations
 * include red greyscale, green greyscale, blue greyscale, value greyscale,
 * intensity greyscale, and luma greyscale.
 */
public abstract class AbstractGreyScale implements ColorTransformations {
  /**
   * Enumeration to represent type of greyscale transformation.
   */
  protected enum greyScaleType { red, green, blue, value, intensity, luma }

  protected greyScaleType type;

  /**
   * Abstract constructor for a greyscale transformation.
   *
   * @param type represents type of greyscale transformation to be processed.
   */
  public AbstractGreyScale(greyScaleType type) {
    this.type = type;
  }

  @Override
  public Image process(Image orgImage) {
    ImageProcessor.nullImageException(orgImage);
    Image resultImage = new ImageModel(orgImage.getImagePixels());
    int givenHeight = orgImage.getHeight();
    int givenWidth = orgImage.getWidth();
    greyScaleType type = this.type;
    switch (type) {
      case red:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            int red = resultImage.getPixelAt(i, j).getRed();
            resultImage.setPixelAt(i, j, red, red, red);
          }
        }
        break;
      case green:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            int green = resultImage.getPixelAt(i, j).getGreen();
            resultImage.setPixelAt(i, j, green, green, green);
          }
        }
        break;
      case blue:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            int blue = resultImage.getPixelAt(i, j).getBlue();
            resultImage.setPixelAt(i, j, blue, blue, blue);
          }
        }
        break;
      case value:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            int value = resultImage.getPixelAt(i, j).getPixelValue();
            resultImage.setPixelAt(i, j, value, value, value);
          }
        }
        break;
      case intensity:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            int intensity = resultImage.getPixelAt(i, j).getPixelIntensity();
            resultImage.setPixelAt(i, j, intensity, intensity, intensity);
          }
        }
        break;
      case luma:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            int luma = resultImage.getPixelAt(i, j).getPixelLuma();
            resultImage.setPixelAt(i, j, luma, luma, luma);
          }
        }
        break;
      default:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            resultImage.setPixelAt(i, j, 0, 0, 0);
          }
        }
    }
    return resultImage;
  }
}




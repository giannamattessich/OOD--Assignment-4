package model.imagetransformations.lighttransformation;

import model.Image;
import model.ImageModel;
import model.Pixel;
import model.imagetransformations.ImageProcessor;

/**
 * Abstract class to represent the different lighting transformations.
 * Transformation types included in lightTypes enum. Possible transformations
 * include a brightened or darkened image. Light transformations are constructed with
 * a given increment as well, which determines the amount an image is lightened/darkened by.
 */
public abstract class AbstractLight implements LightTransformations {
  protected int increment;
  protected lightTypes type;

  enum lightTypes { brighten, darken }

  /**
   * Abstract constructor for a light transformation.
   *
   * @param increment amount image is lightened/darkened.
   * @param type      represents type of light transformation.
   */
  public AbstractLight(int increment, lightTypes type) {
    this.increment = increment;
    this.type = type;
  }

  @Override
  public Image process(Image orgImage) {
    ImageProcessor.nullImageException(orgImage);
    Image resultImage = new ImageModel(orgImage.getImagePixels());
    int givenHeight = orgImage.getHeight();
    int givenWidth = orgImage.getWidth();
    lightTypes type = this.type;
    if (type == lightTypes.brighten) {
      for (int i = 0; i < givenHeight; i++) {
        for (int j = 0; j < givenWidth; j++) {
          Pixel pix = resultImage.getPixelAt(i, j).brighten(increment);
          int red = pix.getRed();
          int green = pix.getGreen();
          int blue = pix.getBlue();
          red = Math.min(255, red);
          green = Math.min(255, green);
          blue = Math.min(255, blue);
          resultImage.setPixelAt(i, j, red, green, blue);
        }
      }
    } else if (type == lightTypes.darken) {
      for (int i = 0; i < givenHeight; i++) {
        for (int j = 0; j < givenWidth; j++) {
          Pixel pix = resultImage.getPixelAt(i, j).brighten(increment * -1);
          int red = pix.getRed();
          int green = pix.getGreen();
          int blue = pix.getBlue();
          red = Math.min(255, red);
          green = Math.min(255, green);
          blue = Math.min(255, blue);
          resultImage.setPixelAt(i, j, red, green, blue);
        }
      }
    }
    return resultImage;
  }
}

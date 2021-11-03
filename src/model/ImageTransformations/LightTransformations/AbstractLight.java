package model.ImageTransformations.LightTransformations;

import model.Image;
import model.ImageModel;
import model.ImageTransformations.ImageProcessor;

/**
 * Abstract class to represent the different lighting transformations.
 * Transformation types included in lightTypes enum. Possible transformations
 * include a brightened or darkened image. Light transformations are constructed with
 * a given increment as well, which determines the amount an image is lightened/darkened by.
 */
public abstract class AbstractLight implements LightTransformations {
  protected int increment;
  protected lightTypes type;

  enum lightTypes {brighten, darken}

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
    switch (type) {
      case brighten:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            resultImage.getImagePixels()[i][j] = resultImage.getPixelAt(i, j).brighten(increment);
          }
        }
        break;
      case darken:
        for (int i = 0; i < givenHeight; i++) {
          for (int j = 0; j < givenWidth; j++) {
            resultImage.getImagePixels()[i][j] = resultImage.getPixelAt(i, j)
                    .brighten(increment * -1);
          }
        }
        break;
    }
    return resultImage;
  }
}

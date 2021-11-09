package model.imagetransformations.fliptransformation;

import model.Image;
import model.ImageModel;
import model.imagetransformations.ImageProcessor;
import model.Pixel;

/**
 * Abstract class to represent the different flipping transformations.
 * Transformation types included in flipTypes enum. Possible transformations
 * include a vertical flip and a horizontal flip.
 */
public abstract class AbstractFlip implements FlipTransformations {
  flipTypes type;

  enum flipTypes { vertical, horizontal }

  /**
   * Abstract constructor for a flip transformation.
   *
   * @param type represents type of flipping transformation to be processed.
   */
  public AbstractFlip(flipTypes type) {
    this.type = type;
  }

  @Override
  public Image process(Image orgImage) {
    ImageProcessor.nullImageException(orgImage);
    Image resultImage = new ImageModel(orgImage.getImagePixels());
    int givenHeight = orgImage.getHeight();
    int givenWidth = orgImage.getWidth();
    flipTypes type = this.type;
    if (type == flipTypes.vertical) {
      for (int i = 0; i < givenHeight/2; i++) {
        for (int j = 0; j < givenWidth; j++) {
          Image result = new ImageModel(orgImage.getImagePixels());
          Pixel temp = result.getPixelAt(i, j);
          int red = result.getPixelAt((givenHeight - i - 1), j).getRed();
          int green = result.getPixelAt((givenHeight - i - 1), j).getGreen();
          int blue = result.getPixelAt((givenHeight - i - 1), j).getBlue();
          result.setPixelAt(i, j, red, green, blue);
          int tempRed = temp.getRed();
          int tempGreen = temp.getGreen();
          int tempBlue = temp.getBlue();
          result.setPixelAt((givenHeight - i - 1), j, tempRed, tempGreen, tempBlue);
        }
      }
    } else if (type == flipTypes.horizontal) {
      for (int i = 0; i < givenHeight; i++) {
        for (int j = 0; j < givenWidth/2; j++) {
          Image result1 = new ImageModel(orgImage.getImagePixels());
          Pixel temp = result1.getPixelAt(i, j);
          int red = result1.getPixelAt(i, (givenWidth - j - 1)).getRed();
          int green = result1.getPixelAt(i, (givenWidth - j - 1)).getGreen();
          int blue = result1.getPixelAt(i, (givenWidth - j - 1)).getBlue();
          result1.setPixelAt(i, j, red, green, blue);
          int tempRed = temp.getRed();
          int tempGreen = temp.getGreen();
          int tempBlue = temp.getBlue();
          result1.setPixelAt(i, (givenWidth - j - 1), tempRed, tempGreen, tempBlue);
        }
      }
    }
    return resultImage;
  }
}
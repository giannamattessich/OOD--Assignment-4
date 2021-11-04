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
      for (int i = 0; i < givenHeight; i++) {
        for (int j = 0; j < givenWidth; j++) {
          Pixel flippedVertPixel = resultImage.getPixelAt(j, ((givenHeight - 1) - i));
          int flippedVerRed = flippedVertPixel.getRed();
          int flippedVerGreen = flippedVertPixel.getGreen();
          int flippedVerBlue = flippedVertPixel.getBlue();
          resultImage.setPixelAt(i, j, flippedVerRed, flippedVerGreen, flippedVerBlue);
        }
      }
    } else if (type == flipTypes.horizontal) {
      for (int i = 0; i < givenHeight; i++) {
        for (int j = 0; j < givenWidth; j++) {
          Pixel flippedHorPixel = resultImage.getPixelAt(((givenWidth - 1) - j), i);
          int flippedHorRed = flippedHorPixel.getRed();
          int flippedHorGreen = flippedHorPixel.getGreen();
          int flippedHorBlue = flippedHorPixel.getBlue();
          resultImage.setPixelAt(i, j, flippedHorRed, flippedHorGreen, flippedHorBlue);
        }
      }
    }
    return resultImage;
  }
}
package model.imagetransformations.greyscaletransformation;

import model.Image;
import model.imagetransformations.ImageProcessor;

/**
 * Represents the interface for color transformation operations. Extends the model-representing
 * class Image Processor. Can be used to represent classes which implement different color
 * transformations.
 */
public interface GreyscaleTransformations extends ImageProcessor {

  @Override
  Image process(Image orgImage);
}

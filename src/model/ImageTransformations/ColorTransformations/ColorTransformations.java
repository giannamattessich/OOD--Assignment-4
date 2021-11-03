package model.ImageTransformations.ColorTransformations;

import model.Image;
import model.ImageTransformations.ImageProcessor;

/**
 * Represents the interface for color transformation operations. Extends the model-representing
 * class Image Processor. Can be used to represent classes which implement different color
 * transformations.
 */
public interface ColorTransformations extends ImageProcessor {

  @Override
  Image process(Image orgImage);
}

package model.ImageTransformations.FlipTransformations;

import model.Image;
import model.ImageTransformations.ImageProcessor;

/**
 * Represents the interface for flipping transformation operations. Extends the model-representing
 * class Image Processor. Can be used to represent classes which implement different flipping
 * transformations.
 */
public interface FlipTransformations extends ImageProcessor {

  @Override
  Image process(Image orgImage);
}

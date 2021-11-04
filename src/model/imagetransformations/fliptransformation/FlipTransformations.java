package model.imagetransformations.fliptransformation;

import model.Image;
import model.imagetransformations.ImageProcessor;

/**
 * Represents the interface for flipping transformation operations. Extends the model-representing
 * class Image Processor. Can be used to represent classes which implement different flipping
 * transformations.
 */
public interface FlipTransformations extends ImageProcessor {

  @Override
  Image process(Image orgImage);
}

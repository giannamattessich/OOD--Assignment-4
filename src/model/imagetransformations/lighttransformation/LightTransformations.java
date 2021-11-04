package model.imagetransformations.lighttransformation;

import model.Image;
import model.imagetransformations.ImageProcessor;

/**
 * Represents the interface for light transformation operations. Extends the model-representing
 * class Image Processor. Can be used to represent classes which implement different lightening
 * transformations (brighten or darken).
 */
public interface LightTransformations extends ImageProcessor {

  @Override
  Image process(Image orgImage);
}

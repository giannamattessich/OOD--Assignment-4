package model.imagetransformations.filters;

import model.Image;
import model.imagetransformations.ImageProcessor;

/**
 * Interface to represent filtering operations.
 */
public interface FilterTransformations extends ImageProcessor {

  @Override
  public Image process(Image orgImage);
}

package model.ImageTransformations.filters;

import model.Image;
import model.ImageTransformations.ImageProcessor;

/**
 * Interface to represent filtering operations.
 */
public interface FilterTransformations extends ImageProcessor {

  @Override
  public Image process(Image orgImage);
}

package model.ImageTransformations.colortransformations;

import model.Image;
import model.ImageTransformations.ImageProcessor;

/**
 * Interface to represent color transformation operations.
 */
public interface ColorTransformations extends ImageProcessor {

  @Override
  public Image process(Image orgImage);
}

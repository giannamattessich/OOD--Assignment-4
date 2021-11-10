package model.imagetransformations.colortransformations;

import model.Image;
import model.imagetransformations.ImageProcessor;

/**
 * Interface to represent color transformation operations.
 */
public interface ColorTransformations extends ImageProcessor {

  @Override
  public Image process(Image orgImage);
}

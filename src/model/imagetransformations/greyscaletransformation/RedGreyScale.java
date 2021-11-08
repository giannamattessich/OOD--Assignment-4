package model.imagetransformations.greyscaletransformation;

/**
 * Class to represent a transformation on an image in which the red-component
 * of each pixel is used to create a corresponding greyscale image, with every pixel's red, green,
 * and blue channels being equal to the red component of the original pixel.
 */
public class RedGreyScale extends AbstractGreyScale {

  /**
   * Constructor to create a red greyscale color transformation.
   */
  public RedGreyScale() {
    super(greyScaleType.red);
  }
}

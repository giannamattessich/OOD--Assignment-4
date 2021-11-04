package model.imagetransformations.colortransformation;

/**
 * Class to represent a transformation on an image in which the blue-component
 * of each pixel is used to create a corresponding greyscale image, with every pixel's red, green,
 * and blue channels being equal to the blue component of the original pixel.
 */
public class BlueGreyScale extends AbstractGreyScale {

  /**
   * Constructor to create a blue greyscale color transformation.
   */
  public BlueGreyScale() {
    super(greyScaleType.blue);
  }
}
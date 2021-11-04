package model.imagetransformations.colortransformation;

/**
 * Class to represent a transformation on an image in which the value
 * of each pixel is used to create a corresponding greyscale image, with every pixel's red, green,
 * and blue channels being equal to the value of the original pixel.
 */
public class ValueGreyScale extends AbstractGreyScale {

  /**
   * Constructor to create a value greyscale color transformation.
   */
  public ValueGreyScale() {
    super(greyScaleType.value);
  }
}
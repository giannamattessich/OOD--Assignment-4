package model.imagetransformations.colortransformation;

/**
 * Class to represent a transformation on an image in which the luma-component
 * of each pixel is used to create a corresponding greyscale image, with every pixel's red, green,
 * and blue channels being equal to the luma of the original pixel.
 */
public class LumaGreyScale extends AbstractGreyScale {

  /**
   * Constructor to create a luma greyscale color transformation.
   */
  public LumaGreyScale() {
    super(greyScaleType.luma);
  }
}


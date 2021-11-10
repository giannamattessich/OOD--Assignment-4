package model.imagetransformations.greyscaletransformation;

/**
 * Class to represent a transformation on an image in which the green-component
 * of each pixel is used to create a corresponding greyscale image, with every pixel's red, green,
 * and blue channels being equal to the green component of the original pixel.
 */
public class GreenGreyScale extends AbstractGreyScale {

  /**
   * Constructor to create a green greyscale color transformation.
   */
  public GreenGreyScale() {
    super(greyScaleType.green);
  }
}
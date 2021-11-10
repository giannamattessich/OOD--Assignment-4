package model.ImageTransformations.greyscaletransformation;

/**
 * Class to represent a transformation on an image in which the intensity
 * of each pixel is used to create a corresponding greyscale image, with every pixel's red, green,
 * and blue channels being equal to the intensity of the original pixel.
 */
public class IntensityGreyScale extends AbstractGreyScale {

  /**
   * Constructor to create a luma greyscale color transformation.
   */
  public IntensityGreyScale() {
    super(greyScaleType.intensity);
  }
}

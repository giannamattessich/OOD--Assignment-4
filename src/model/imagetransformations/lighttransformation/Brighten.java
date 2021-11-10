package model.imagetransformations.lighttransformation;

/**
 * Class to represent a brightening image transformation.
 */
public class Brighten extends AbstractLight {

  /**
   * Constructor for a brightening image transformation.
   *
   * @param increment amount image will be brightened by.
   */
  public Brighten(int increment) {
    super(increment, lightTypes.brighten);
  }
}

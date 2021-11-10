package model.imagetransformations.lighttransformation;

/**
 * Class to represent a darkening image transformation.
 */
public class Darken extends AbstractLight {

  /**
   * Abstract constructor for a darkening transformation.
   *
   * @param increment amount image is lightened/darkened.
   */
  public Darken(int increment) {
    super(increment, lightTypes.darken);
  }
}

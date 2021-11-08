package model.imagetransformations.colortransformations;

/**
 * Class to represent a "sepia" color transformation.
 */
public class Sepia extends AbstractColorTransformation {

  /**
   * Constructor for a sepia transformation, calls super abstract constructor.
   */
  public Sepia() {
    super(inItColorMat());
  }

  /**
   * Initializes the matrix of a sepia color transformation.
   *
   * @return initial double matrix of this color transformation.
   */
  private static double[][] inItColorMat() {
    double[][] colorMat = {{0.393, 0.769, 0.189}, {0.349, 0.686, 0.168}, {0.272, 0.534, 0.131}};
    return colorMat;
  }
}

package model.imagetransformations.colortransformations;

/**
 * Represents a greyscale color transformation.
 */
public class GreyScale extends AbstractColorTransformation {

  /**
   * Constructor for a greyscale color transformation.
   */
  public GreyScale() {
    super(initColorMat());
  }

  /**
   * Method to initialize the color matrix of a greyscale transformation.
   *
   * @return greyscale color matrix.
   */
  private static double[][] initColorMat() {
    double[][] colorMat = new double[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (j == 0) {
          colorMat[i][j] = 0.2126;
        } else if (j == 1) {
          colorMat[i][j] = 0.7152;
        } else if (j == 2) {
          colorMat[i][j] = 0.0722;
        }
      }
    }
    return colorMat;
  }
}

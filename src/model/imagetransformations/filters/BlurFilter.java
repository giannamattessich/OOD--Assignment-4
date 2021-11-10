package model.imagetransformations.filters;

/**
 * Class to represent blur filter on an image.
 */
public class BlurFilter extends AbstractFilterTransformations {

  /**
   * Constructor for blur filter transformation.
   */
  public BlurFilter() {
    super();
  }

  /**
   * Initializes 3 x 3 kernel of blur filter and its associated values.
   *
   * @return kernel of blur filter.
   */
  @Override
  protected double[][] initKernel() {
    double[][] blurKernel = new double[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (((i == 0) || (i == 2)) && ((j == 0) || (j == 2))) {
          blurKernel[i][j] = (1.00 / 16.00);
        } else if (((i == 0) || (i == 2)) && (j == 1)) {
          blurKernel[i][j] = (1.00 / 8.00);
        } else if ((i == 1) && ((j == 0) || (j == 2))) {
          blurKernel[i][j] = (1.00 / 8.00);
        } else if ((i == 1) && (j == 1)) {
          blurKernel[i][j] = (1.00 / 4.00);
        }
      }
    }
    return blurKernel;
  }

  @Override
  protected int getKernelHeight() {
    return 3;
  }

  @Override
  protected int getKernelWidth() {
    return 3;
  }
}
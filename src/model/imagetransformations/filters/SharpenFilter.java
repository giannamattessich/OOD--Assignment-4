package model.imagetransformations.filters;

/**
 * Class to represent sharpen filter.
 */
public class SharpenFilter extends AbstractFilterTransformations {

  /**
   * Constructor for sharpen filter transformation.
   */
  public SharpenFilter() {
    super(initKernel());
  }

  /**
   * Initializes 5 x 5 kernel of sharpen filter and its associated values.
   *
   * @return kernel of sharpen filter.
   */
  private static double[][] initKernel() {
    double[][] sharpenKernel = new double[5][5];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if ((i == 0) || (i == 4)) {
          sharpenKernel[i][j] = (-1.00 / 8.00);
        } else if ((j == 0) || (j == 4)) {
          sharpenKernel[i][j] = (-1.00 / 8.00);
        } else if ((i == 2) && (j == 2)) {
          sharpenKernel[i][j] = 1.00;
        } else if (((i == 1) || (i == 2) || (i == 3)) &&
                ((j == 1) || (j == 2) || (j == 3))) {
          sharpenKernel[i][j] = (1.00 / 4.00);
        }
      }
    }
    return sharpenKernel;
  }

  @Override
  protected int getKernelHeight() {
    return 5;
  }

  @Override
  protected int getKernelWidth() {
    return 5;
  }
}

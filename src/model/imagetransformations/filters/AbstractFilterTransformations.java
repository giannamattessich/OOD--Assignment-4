package model.imagetransformations.filters;

import model.Image;
import model.ImageModel;
import model.Pixel;

/**
 * Abstract class to represent classes that apply filter operations to image.
 */
public abstract class AbstractFilterTransformations implements FilterTransformations {
  protected double[][] kernel;

  /**
   * Constructor for an abstract filter transformation.
   *
   * @param kernel distinct filter kernel of filter type.
   */
  public AbstractFilterTransformations(double[][] kernel) {
    this.kernel = kernel;
  }

  /**
   * Retrieves the kernel value at given row and column position.
   *
   * @param row row of kernel.
   * @param col column of kernel.
   * @return kernel value at (row, column).
   */
  protected double getKernelAt(int row, int col) {
    return kernel[row][col];
  }

  /**
   * Gets height of a filter's kernel.
   *
   * @return height of filter kernel.
   */
  protected abstract int getKernelHeight();

  /**
   * Gets width of a filter's kernel.
   *
   * @return width of filter kernel.
   */
  protected abstract int getKernelWidth();

  /**
   * Gets the pixel matrix from applying the kernel at the center of given pixel.
   *
   * @param row row of pixel at center of kernel.
   * @param col column of pixel at center of kernel.
   * @param img image for filter to be applied to.
   * @return matrix representing pixels that are taken into account when finding the RGB
   * value of a filtered pixel.
   */
  protected Pixel[][] getOverlap(int row, int col, Image img) {
    Pixel[][] overlap = new Pixel[getKernelHeight()][getKernelWidth()];
    int kernMid = getKernelHeight() / 2;
    for (int i = (row - (kernMid - 1)); i < (row + kernMid); i++) {
      for (int j = (col - (kernMid - 1)); j < (col + kernMid); j++) {
        try {
          overlap[i][j] = img.getPixelAt(i, j);
        } catch (ArrayIndexOutOfBoundsException e) {
          overlap[i][j] = new Pixel(0, 0, 0);
          continue;
        }
      }
    }
    return overlap;
  }

  /**
   * Applies filter to a single pixel at given row and column.
   *
   * @param row represents row of pixel.
   * @param col represents column of pixel.
   * @param img represents image of pixel.
   */
  protected void applyFilter(int row, int col, Image img) {
    int newRed = 0;
    int newGreen = 0;
    int newBlue = 0;
    for (int i = 0; i < kernel.length; i++) {
      for (int j = 0; j < kernel[0].length; j++) {
        newRed += (int) (((double) getOverlap(i, j, img)[i][j].getRed()) * getKernelAt(i, j));
        newGreen += (int) (((double) getOverlap(i, j, img)[i][j].getGreen()) * getKernelAt(i, j));
        newBlue += (int) (((double) getOverlap(i, j, img)[i][j].getBlue()) * getKernelAt(i, j));

        if (newRed > 255) {
          newRed = 255;
        } else if (newGreen > 255) {
          newGreen = 255;
        } else if (newBlue > 255) {
          newBlue = 255;
        }
      }
    }
    img.setPixelAt(row, col, newRed, newGreen, newBlue);
  }


  @Override
  public Image process(Image orgImg) {
    Image filteredImg = new ImageModel(orgImg.getImagePixels());
    for (int i = 0; i < filteredImg.getHeight(); i++) {
      for (int j = 0; j < filteredImg.getWidth(); j++) {
        try {
          applyFilter(i, j, filteredImg);
        } catch (ArrayIndexOutOfBoundsException e) {
          break;
        }
      }
    }
    return filteredImg;
  }
}

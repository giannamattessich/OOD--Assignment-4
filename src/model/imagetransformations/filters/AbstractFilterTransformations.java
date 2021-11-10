package model.imagetransformations.filters;

import java.util.ArrayList;

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
   */
  public AbstractFilterTransformations() {
    this.kernel = initKernel();
  }

  /**
   * Initializes kernel in concrete classes.
   *
   * @return kernel of filter.
   */
  protected abstract double[][] initKernel();

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
   * @return matrix representing pixels that are taken into account for rgb.
   */
  protected ArrayList<ArrayList<Pixel>> multiplyKernel(int row, int col, Image img) {
    int kernMid = getKernelHeight() / 2;
    ArrayList<ArrayList<Pixel>> kernOverlap = new ArrayList<ArrayList<Pixel>>();
    for (int i = (row - kernMid); i < (row + (kernMid + 1)); i++) {
      ArrayList<Pixel> width = new ArrayList<>();
      for (int j = (col - kernMid); j < (col + (kernMid + 1)); j++) {
        try {
          width.add(img.getPixelAt(row, col));
        } catch (IndexOutOfBoundsException e) {
          width.add(new Pixel(0, 0, 0));
          continue;
        }
        kernOverlap.add(width);
      }
    }
    return kernOverlap;
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
        newRed += ((multiplyKernel(row, col, img).get(i).get(j).getRed()) * (getKernelAt(i, j)));
        double additionToGreen = ((multiplyKernel(row, col, img).get(i).get(j).getGreen()) * (getKernelAt(i, j)));
        newGreen += additionToGreen;
        newBlue += ((multiplyKernel(row, col, img).get(i).get(j).getBlue()) * (getKernelAt(i, j)));

        newRed = Math.min(255, newRed);
        newGreen = Math.min(255, newGreen);
        newBlue = Math.min(255, newBlue);
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
          continue;
        }
      }
    }
    return filteredImg;
  }
}

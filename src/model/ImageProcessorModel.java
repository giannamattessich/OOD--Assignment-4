package model;

import model.imagetransformations.ImageProcessor;

/**
 * Represents the functionalities of this ImageProcessor model.
 */
public interface ImageProcessorModel {

  /**
   * Sets the image path of this model to the image path from controller.
   *
   * @param filePath file path of this model.
   */
  void setImagePath(String filePath);

  /**
   * Method for helper method to determine successful setting of filepath.
   *
   * @return image path of this model.
   */
  public String getImagePath();

  /**
   * Adds file to set of image files.
   *
   * @param fileName is name to reference image file.
   * @param img      is image to be added to set of image files.
   */
  void addFile(String fileName, Image img);

  /**
   * Retrieves Image from fileName, stored in hashmap.
   *
   * @param fileName stored filename in hashmap.
   * @return image at fileName.
   */
  Image getImage(String fileName);

  /**
   * Returns a new image from a given transformation applied to a given image(from
   * value-key pair obtained from fileName) in hashmap.
   *
   * @param fileName filename in hashmap with corresponding image.
   * @param cmd      represents transformation to be applied.
   * @return transformed image.
   */
  Image getNewImage(String fileName, ImageProcessor cmd);
}

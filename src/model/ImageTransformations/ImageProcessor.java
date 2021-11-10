package model.imagetransformations;

import model.Image;

/**
 * Interface which processes functionality on a given image.
 */
public interface ImageProcessor {

  /**
   * Static method that throws illegal argument exception if a given image is null.
   *
   * @param orgImage given image.
   * @throws IllegalArgumentException if image provided to it is null.
   */
  static void nullImageException(Image orgImage) throws IllegalArgumentException {
    if (orgImage == null) {
      throw new IllegalArgumentException("Image to be transformed cannot be null.");
    }
  }

  /**
   * Applies image processing functionalities to the given image.
   *
   * @param orgImage the image to be processed.
   * @return the resulting Image after being processed by an implementing functionality.
   */
  public Image process(Image orgImage);
}

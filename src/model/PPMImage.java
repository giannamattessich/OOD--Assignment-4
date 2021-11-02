package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to represent an Image constructed from a PPM file, which lists
 * the values associated with pixels of an image.
 */
public class PPMImage extends ImageImpl {

  /**
   * Constructor for a PPMImage.
   * inItImage method is used to initialize all fields other than the provided file.
   *
   * @param filePath is a PPM file provided by user.
   * @param fileName is a reference to PPM file.
   */
  public PPMImage(String fileName) {
    super(fileName);
  }

  // @Override
  // public void saveImage(String filePath, String fileName) {

  // }
}

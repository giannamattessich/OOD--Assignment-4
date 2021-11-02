package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to represent an Image constructed from a PPM file, which lists
 * the values associated with pixels of an image.
 */
public class PPMImage extends AbstractImage {

  /**
   * Constructor for a PPMImage.
   * inItImage method is used to initialize all fields other than the provided file.
   *
   * @param filePath is a PPM file provided by user.
   * @param fileName is a reference to PPM file.
   */
  public PPMImage(String filePath, String fileName) {
    super(filePath, fileName);
  }

  @Override
  protected void initImage(String filePath) {
    Scanner scan = null;
    try {
      scan = new Scanner(new FileInputStream(filePath));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filePath + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string.
    // This will throw away any comment lines
    while (scan.hasNextLine()) {
      String s = scan.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }
    //now set up the scanner to read from the string we just built
    scan = new Scanner(builder.toString());
    String token = scan.next();
    if (!(token.equals("P3"))) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    this.width = scan.nextInt();
    this.height = scan.nextInt();
    this.maxColorVal = scan.nextInt();

    this.imagePixels = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        int r = scan.nextInt();
        int g = scan.nextInt();
        int b = scan.nextInt();
        this.imagePixels[i][j] = new Pixel(r, g, b);
      }
    }
  }

  @Override
  public void loadImage(String filePath, String fileName) {
    Image loadedImage = new PPMImage(filePath, fileName);

  }

  @Override
  public void saveImage(String filePath, String fileName) {

  }
}

package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.Image;
import model.Pixel;

/**
 * Class to represent an model.Image constructed from a PPM file, which lists
 * the values associated with pixels of an image.
 */
public class PPMImage implements Image {
  protected final String fileName;
  protected int width;
  protected int height;
  protected int maxColorVal;
  protected Pixel[][] imagePixels;

  /**
   * Constructor for a model.PPMImage.
   * inItImage method is used to initialize all fields other than the provided file.
   *
   * @param fileName is a PPM file provided by user.
   */
  public PPMImage(String fileName) {
    this.fileName = fileName;
    inItImage(this.fileName);
  }

  /**
   * Initializes an image's width, height, max color value(determined from
   * image bit-depth), and the image's pixels + with their associated RGB values.
   *
   * @param fileName represents file provided by user.
   */
  private void inItImage(String fileName) {
    Scanner scan = null;
    try {
      scan = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileName + " not found!");
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
}

package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.Function;

import model.Pixel;

/**
 * Class to represent an model.Image constructed from a PPM file, which lists
 * the values associated with pixels of an image.
 */
public class Image {
  protected final String fileName;
  protected int width;
  protected int height;
  protected int maxColorVal;
  protected Pixel[][] imagePixels;

  /**
   * Constructor for a model.PPMImage. inItImage method is used to initialize all
   * fields other than the provided file.
   *
   * @param fileName is a PPM file provided by user.
   */
  public Image(String fileName) {
    this.fileName = fileName;
    initImage(this.fileName);
  }

  /**
   * Initializes an image's width, height, max color value(determined from image
   * bit-depth), and the image's pixels + with their associated RGB values.
   *
   * @param fileName represents file provided by user.
   */
  private void initImage(String fileName) {
    Scanner scan = null;
    try {
      scan = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File " + fileName + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    // read the file line by line, and populate a string.
    // This will throw away any comment lines
    while (scan.hasNextLine()) {
      String s = scan.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }
    // now set up the scanner to read from the string we just built
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

  /**
   * Flips the image vertically.
   * 
   * @return void.
   */
  public void flipVertical() {
    Pixel[][] temp = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        temp[i][j] = this.imagePixels[this.height - i - 1][j];
      }
    }
    this.imagePixels = temp;
  }

  /**
   * Flips the image horizontally.
   * 
   * @return void.
   */
  public void flipHorizontal() {
    Pixel[][] temp = new Pixel[this.height][this.width];
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        temp[i][j] = this.imagePixels[i][this.width - j - 1];
      }
    }
    this.imagePixels = temp;
  }

  /**
   * Brightens the image by adding a constant to RGB values within each pixel.
   * Will not exceed 255 for any RGB value once added.
   * 
   * @param constant is the amount to add to each RGB value.
   * @return void.
   */
  public void brighten(int constant) {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j].brighten(constant);
      }
    }
  }

  /**
   * Darkens the image by subtracting a constant from RGB values within each
   * pixel. Will not go below 0 for any RGB value once subtracted.
   * 
   * @param constant is the amount to subtract from each RGB value.
   * @return void.
   */
  public void darken(int constant) {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j].brighten(-1 * constant);
      }
    }
  }

  /**
   * Visualize the red channel of the image in greyscale.
   * 
   * @return void.
   */
  public void redComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeRedChannel();
      }
    }
  }

  /**
   * Visualize the green channel of the image in greyscale.
   * 
   * @return void.
   */
  public void greenComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeGreenChannel();
      }
    }
  }

  /**
   * Visualize the blue channel of the image in greyscale.
   * 
   * @return void.
   */
  public void blueComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeBlueChannel();
      }
    }
  }

  /**
   * Visualize the luma channel of the image in greyscale.
   * 
   * @return void.
   */
  public void lumaComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeLuma();
      }
    }
  }

  /**
   * Visualize the intensity channel of the image in greyscale.
   * 
   * @return void.
   */
  public void intensityComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeIntensity();
      }
    }
  }

  /**
   * Visualize the value channel of the image in greyscale.
   * 
   * @return void.
   */
  public void valueComponent() {
    for (int i = 0; i < this.height; i++) {
      for (int j = 0; j < this.width; j++) {
        this.imagePixels[i][j] = this.imagePixels[i][j].visualizeValue();
      }
    }
  }

}

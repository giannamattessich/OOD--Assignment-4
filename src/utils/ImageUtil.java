package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import model.Image;
import model.ImageImpl;
import model.PPMImage;
import model.Pixel;


/**
 * This class contains utility methods to read a PPM image from file and simply print its
 * contents. Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and print the colors.
   *
   * @param filepath the path of the file.
   */
  public static Image readPPM(String filepath) {
    Scanner sc = null;

    try {
      sc = new Scanner(new FileInputStream(filepath));
    } catch (FileNotFoundException e) {
      System.out.println("File " + filepath + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    //read the file line by line, and populate a string.
    // This will throw away any comment lines
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s).append(System.lineSeparator());
      }
    }
    //now set up the scanner to read from the string we just built
    sc = new Scanner(builder.toString());
    String token = sc.next();
    if (!(token.equals("P3"))) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    System.out.println("Width of image: " + width);
    int height = sc.nextInt();
    System.out.println("Height of image: " + height);
    int maxValue = sc.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);

    Pixel[][] imagePixels = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        imagePixels[i][j] = new Pixel(r, g, b);
      }
    }
    Image i = new ImageImpl(filepath, width, height, maxValue, imagePixels);
    return i;
  }

  //demo main
  public static void main(String[] args) {
    String filename;

    if (args.length > 0) {
      filename = args[0];
    } else {
      filename = "sample.ppm";
    }

    ImageUtil.readPPM(filename);
  }

  /**
   * Writes the ppm files based the given image and the filename to write to.
   *
   * @param filePath     the file name.
   * @param changedImage the image to be written as ppm.
   * @throws IOException exception from the view.
   */
  public static void writePPMFile(String filePath, Image changedImage) throws IOException {
    FileWriter file = new FileWriter(filePath);
    file.append("P3");
    file.append("\n");
    file.append(String.valueOf(changedImage.getWidth())).append(" ")
            .append(String.valueOf(changedImage.getHeight())).append("\n");
    file.append("255" + "\n");
    for (int i = 0; i < changedImage.getHeight(); i++) {
      for (int j = 0; j < changedImage.getWidth(); j++) {
        file.append("").append(String.valueOf(changedImage.getPixelAt(i, j)
                .getRed())).append("\n");
        file.append("").append(String.valueOf(changedImage.getPixelAt(i, j)
                .getGreen())).append("\n");
        file.append("").append(String.valueOf(changedImage.getPixelAt(i, j)
                .getBlue())).append("\n");
      }
    }
  }
}


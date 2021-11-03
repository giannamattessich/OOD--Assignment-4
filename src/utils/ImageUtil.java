package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import model.Image;
import model.ImageModel;
import model.Pixel;

/**
 * This class contains utility methods to read and write images.
 */
public class ImageUtil {

  /**
   * Read an image file in the PPM format and creates new Image model to represent PPM.
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
    while (Objects.requireNonNull(sc).hasNextLine()) {
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
    System.out.println("Width of Image: " + width);
    int height = sc.nextInt();
    System.out.println("Height of Image: " + height);
    int maxValue = sc.nextInt();
    System.out.println("MaxVal of Image: " + maxValue);

    Pixel[][] imagePixels = new Pixel[height][width];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = sc.nextInt();
        int g = sc.nextInt();
        int b = sc.nextInt();
        imagePixels[i][j] = new Pixel(r, g, b);
      }
    }
    return new ImageModel(imagePixels);
  }

  /**
   * Writes the ppm files based the given image and the filename to write to.
   *
   * @param filePath the file name.
   * @param img      the image to be written as ppm.
   * @throws IllegalArgumentException if provided filepath does not have ppm file extension.
   */
  public static void writePPMFile(String filePath, Image img)
          throws IllegalArgumentException {
    if (filePath.endsWith("ppm")) {
      try {
        FileWriter file = new FileWriter(filePath);
        file.append("P3");
        file.append("\n");
        file.append(String.valueOf(img.getWidth())).append(" ")
                .append(String.valueOf(img.getHeight())).append("\n");
        file.append("255" + "\n");
        for (int i = 0; i < img.getHeight(); i++) {
          for (int j = 0; j < img.getWidth(); j++) {
            file.append("").append(String.valueOf(img.getPixelAt(i, j)
                    .getRed())).append("\n");
            file.append("").append(String.valueOf(img.getPixelAt(i, j)
                    .getGreen())).append("\n");
            file.append("").append(String.valueOf(img.getPixelAt(i, j)
                    .getBlue())).append("\n");
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      throw new IllegalArgumentException("FilePath must end in .ppm");
    }
  }
}


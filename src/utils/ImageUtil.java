package utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
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

  /**
   * Method to read image file of all types, including PPM, PNG, and JPEG Files.
   *
   * @param filePath is path of file to be read.
   * @throws IllegalArgumentException thrown if provided with null filepath or invalid
   *                                  file extension.
   */
  public static Image readImageFile(String filePath)
          throws IllegalArgumentException {
    if (filePath == null) {
      throw new IllegalArgumentException("Image to be created cannot be null");
    }
    if (!((filePath.endsWith(".ppm")) || (filePath.endsWith(".jpeg"))
            || (filePath.endsWith(".jpg")) || (filePath.endsWith(".bmp")) ||
            (filePath.endsWith(".png")))) {
      throw new IllegalArgumentException(filePath + " does not a valid file extension");
    }
    if (filePath.endsWith(".jpeg") || filePath.endsWith(".png") || filePath.endsWith(".bmp") ||
            (filePath.endsWith(".jpg"))) {
      File imgFile = new File(filePath);
      Image output = new ImageModel(null);
      try {
        BufferedImage bImg = ImageIO.read(imgFile);
        Pixel[][] pixelMatrix = new Pixel[bImg.getHeight()][bImg.getWidth()];

        for (int coordy = 0; coordy < bImg.getHeight(); coordy++) {
          for (int coordx = 0; coordx < bImg.getWidth(); coordx++) {
            Color pixelColor = new Color(bImg.getRGB(coordx, coordy));
            Pixel setPixel = new
                    Pixel(pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue());
            pixelMatrix[coordy][coordx] = setPixel;
          }
        }
        output.setImagePixels(pixelMatrix);
      } catch (IOException e) {
        e.printStackTrace();
      }
      return output;

    } else {
      return ImageUtil.readPPM(filePath);
    }
  }

  /**
   * Converts an image model to a buffered image to be written as a file.
   *
   * @param image to be converted.
   * @return buffered image version of given image.
   */
  public static BufferedImage convertImage(Image image) {
    BufferedImage bImg = new BufferedImage(image.getWidth(), image.getHeight(),
            BufferedImage.TYPE_INT_RGB);
    for (int height = 0; height < image.getHeight(); height++) {
      for (int width = 0; width < image.getWidth(); width++) {
        int red = image.getPixelAt(height, width).getRed();
        int green = image.getPixelAt(height, width).getGreen();
        int blue = image.getPixelAt(height, width).getBlue();
        Color c = new Color(red, green, blue);
        bImg.setRGB(width, height, c.getRGB());
      }
    }
    return bImg;
  }

  /**
   * Writes an image model to an image file.
   *
   * @param filePath for image to be saved to.
   * @param image    to be saved.
   * @throws IllegalArgumentException if image does not have valid filepath extension.
   */
  public static void writeImageFile(String filePath, Image image) throws
          IllegalArgumentException {
    if (filePath == null) {
      throw new IllegalArgumentException("File Path cannot be null.");
    }
    if (!((filePath.endsWith(".jpeg")) || (filePath.endsWith(".jpg"))
            || (filePath.endsWith(".png")) || (filePath.endsWith(".bmp")) ||
            (filePath.endsWith(".ppm")))) {
      throw new IllegalArgumentException("Invalid FilePath Extension provided.");
    }
    BufferedImage bImg = ImageUtil.convertImage(image);
    File imgFile = new File(filePath);
    if ((filePath.endsWith(".jpeg")) || (filePath.endsWith(".jpg"))) {
      try {
        ImageIO.write(bImg, "jpeg", imgFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (filePath.endsWith(".png")) {
      try {
        ImageIO.write(bImg, "png", imgFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (filePath.endsWith(".bmp")) {
      try {
        ImageIO.write(bImg, "bmp", imgFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else if (filePath.endsWith(".ppm")) {
      ImageUtil.writePPMFile(filePath, image);
    }
  }
}
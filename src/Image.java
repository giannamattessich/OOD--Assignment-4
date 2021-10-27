import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import javax.imageio.ImageIO;
public class Image {
  String filePath;
  String filename;
  int width;
  int height;
  int maxColorValue;
  Pixel[][] imagePixels;
  // public Image(String filename, String filePath) {
  // this.filename = filename;
  // this.filePath = filePath;
  // this.load(filename, filePath);
  // }
  public Image(String filename) {
    this.filename = filename;
    load();
  }
  // find file, read type (either ppm, jpg, png) and call relevant load method
  public void load() {
    Scanner file = null;
    try {
      file = new Scanner(new FileInputStream(filename));
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + e);
    }
    this.width = this.getWidthAndHeightMaxHeight(file)[0];
    this.height = this.getWidthAndHeightMaxHeight(file)[1];
    this.maxColorValue = this.getWidthAndHeightMaxHeight(file)[2];
    this.imagePixels = initPPMImage();
    parsePPMIntoBuilder(file);
  }

  // // load function but using a file path too
  // public void load(String filePath, String filename) { // filename should actually just be the string representation so
  // // its not needed for loading
  // Scanner file = null;
  // try {
  // file = new Scanner(new FileInputStream(filePath));
  // } catch (FileNotFoundException e) {
  // System.out.println("File not found");
  // }
  // String type = file.next();
  // if (type.equals("ppm")) {
  // loadPPM(file);
  // } else if (type.equals("jpg")) {
  // loadJPG(filePath + filename);
  // } else if (type.equals("png")) {
  // loadPNG(filePath + filename);
  // } else {
  // System.out.println("Invalid file type");
  // }
  // }
  //method to instantiate imagePixels that takes in a width and height

  private StringBuilder parsePPMIntoBuilder(Scanner file) {
    StringBuilder builder = new StringBuilder();
    while (file.hasNextLine()) {
      String s = file.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }
    // now set up the scanner to read from the string we just built
    file = new Scanner(builder.toString());
    String token;
    token = file.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = file.nextInt();
    System.out.println("Width of image: " + width);
    int height = file.nextInt();
    System.out.println("Height of image: " + height);
    int maxValue = file.nextInt();
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);
    return builder;
  }

  private Pixel[][] initPPMImage() {
    Pixel[][] image = new Pixel[this.width][this.height];
    for (int i = 0; i < this.width; i++) {
      for (int j = 0; j < this.height; j++) {
        new Pixel(scan.nextInt);
      }
    }
  }

  private void loadPPM(StringBuilder sb) {
    System.out.println("Maximum value of a color in this file (usually 255): " + maxValue);
    //instantiate imagePixels to be an empty array
    imagePixels = new Pixel[width][height];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        int r = file.nextInt();
        int g = file.nextInt();
        int b = file.nextInt();
        Pixel p = new Pixel(r, g, b);
        imagePixels[i][j] = p;
      }
    }
  }

  //help method to return the width and height as a tuple
  public int[] getWidthAndHeightMaxHeight(Scanner wHFile) {
    StringBuilder builder = new StringBuilder();
    int[] widthHeightMax = new int[2];
    String token;
    while (wHFile.hasNextLine()) {
      String s = wHFile.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }
// now set up the scanner to read from the string we just built
    wHFile = new Scanner(builder.toString());
    token = wHFile.next();
    if (!token.equals("P3")) {
      System.out.println("Invalid PPM file: plain RAW file should begin with P3");
    }
    widthHeightMax[0] = wHFile.nextInt();
    widthHeightMax[1] = wHFile.nextInt();
    widthHeightMax[2] = wHFile.nextInt();
    return widthHeightMax;
  }

  private void loadJPG(String jpgFileName) {
    // stub
  }
  private void loadPNG(String pngFileName) {
    // stub
  }
}
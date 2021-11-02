package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Image;
import utils.ImageUtil;
import view.ImageView;

/**
 * Class which implements functionality for an image controller. The controller
 * takes user input and performs commands on the given model based on given user input.
 * The controller also outputs messages to view when an operation is performed on an image.
 */
public class ImageControllerImpl implements ImageController {
  Readable inputStream;
  ImageView view;
  Image model;
  Map<String, Image> allImageNames;


  /**
   * Constructor for image program controller.
   *
   * @param inputStream represents user input stream.
   * @param view        represents program output stream (outputs to view).
   * @param model       represents model for operation to be performed on.
   * @throws IllegalArgumentException if any of the fields provided are null.
   */
  public ImageControllerImpl(Readable inputStream, ImageView view, Image model) throws
          IllegalArgumentException {
    if ((inputStream == null) || (view == null) || (model == null)) {
      throw new IllegalArgumentException("Fields of controller cannot be null.");
    }
    this.inputStream = inputStream;
    this.view = view;
    this.model = model;
    HashMap<String, Image> allImageNames = new HashMap<String, Image>();
  }

  @Override
  public void promptImageCommand() {
    Scanner sc = new Scanner(this.inputStream);
    welcomeMessage();

    while (sc.hasNext()) {
      try {
        this.view.renderMessage("Type Command:");
      } catch (IOException e) {
        e.printStackTrace();
      }
      String userCommand = sc.next();
      switch (userCommand) {
        case "load":
          String loadFilePath = sc.next();
          Image loadImage = ImageUtil.readPPM(loadFilePath);
          String loadFileName = sc.next();
          promptLoad(loadFilePath, loadFileName, loadImage);
          break;
        case "save":
          String saveFilePath = sc.next();
          String saveFileName = sc.next();
          promptSave(saveFilePath, saveFileName);
          break;
        case "red-component":
          String rImageName = sc.next();
          String rDestFile = sc.next();
          createRedGreyscale(rImageName, rDestFile);
          break;
        case "green-component":
          String gImageName = sc.next();
          String gDestFile = sc.next();
          createGreenGreyscale(gImageName, gDestFile);
          break;
        case "blue-component":
          String bImageName = sc.next();
          String bDestFile = sc.next();
          createBlueGreyscale(bImageName, bDestFile);
          break;
        case "value-component":
          String vImageName = sc.next();
          String vDestFile = sc.next();
          createValueGreyscale(vImageName, vDestFile);
          break;
        case "luma-component":
          String lImageName = sc.next();
          String lDestFile = sc.next();
          createLumaGreyscale(lImageName, lDestFile);
          break;
        case "intensity-component":
          String iImageName = sc.next();
          String iDestFile = sc.next();
          createIntensityGreyscale(iImageName, iDestFile);
          break;
        case "horizontal-flip":
          String hfImageName = sc.next();
          String hfDestFile = sc.next();
          createHorizontalFlip(hfImageName, hfDestFile);
          break;
        case "vertical-flip":
          String vfImageName = sc.next();
          String vfDestFile = sc.next();
          createVerticalFlip(vfImageName, vfDestFile);
          break;
        case "brighten":
          int brInc = sc.nextInt();
          String brImageName = sc.next();
          String brDestFile = sc.next();
          createBrighten(brInc, brImageName, brDestFile);
          break;
        default:
          try {
            view.renderMessage("This command could not be understood.");
          } catch (IOException e) {
            e.printStackTrace();
          }
      }
    }
  }

  /**
   * Produces welcome message, outputs to view.
   */
  private void welcomeMessage() {
    try {
      this.view.renderMessage("Welcome to Image Processor Program.\n" +
              "Commands with unique user-provided inputs are specified with <>.");
      this.view.renderMessage("<image-path> refers to file path of image to be operated on.");
      this.view.renderMessage("<image-name> refers to name given to reference an image.");
      this.view.renderMessage("<dest-image-name> refers to name given to reference an image" +
              "once a specified operation has been performed on it.)");
      this.view.renderMessage("load <image-path> <image-name> -> load image");
      this.view.renderMessage("save <image-path> <image-name> -> save image");
      this.view.renderMessage("red-component <image-name> <dest-image-name> -> produce image" +
              "that visualizes red component of pixels using greyscale.");
      this.view.renderMessage("green-component <image-name> <dest-image-name> -> produces image" +
              "that visualizes green component of pixels using greyscale.");
      this.view.renderMessage("blue-component <image-name> <dest-image-name> -> produces image" +
              "that visualizes blue component of pixels using greyscale.");
      this.view.renderMessage("value-component <image-name> <dest-image-name> -> produce image" +
              "that visualizes value component of pixels using greyscale.");
      this.view.renderMessage("luma-component <image-name> <dest-image-name> -> produces image" +
              "that visualizes luma component of pixels using greyscale.");
      this.view.renderMessage("intensity-component <image-name> <dest-image-name> -> produces" +
              " image that visualizes intensity component of pixels using greyscale.");
      this.view.renderMessage("horizontal-flip <image-name> <dest-image-name> -> flips image" +
              "horizontally");
      this.view.renderMessage("vertical-flip <image-name> <dest-image-name> -> flips" +
              "image vertically");
      this.view.renderMessage("brighten <increment> <image-name> <dest-image-name> -> brightens" +
              "image by specified increment(increment is positive).");
      this.view.renderMessage("darken <increment> <image-name> <dest-image-name> -> darkens" +
              "image by specified increment(increment is positive).");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Prompts load command.
   *
   * @param filePath is filepath of image.
   * @param fileName is filename of image.
   * @param i        is image to be loaded.
   */
  private void promptLoad(String filePath, String fileName, Image i) {
    try {
      i.setFileName(fileName);
      allImageNames.put(fileName, i);
      this.view.renderMessage("File " + fileName + "loaded!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Prompts save command.
   *
   * @param filePath filepath of image to be saved.
   * @param fileName file name of image to be saved.
   */
  private void promptSave(String filePath, String fileName) {
    for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
      try {
        if (item.getKey().equals(fileName)) {
          ImageUtil.writePPMFile(filePath, item.getValue());
          item.getValue().setFilePath(filePath);
        } else {
          this.view.renderMessage("Image has not yet been loaded or created.");
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Creates greyscale image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createRedGreyscale(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image redImage = this.model.createRedGreyScale(item.getValue());
          allImageNames.put(destName, redImage);
          redImage.setFileName(destName);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates greyscale image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createGreenGreyscale(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image greenImage = this.model.createGreenGreyScale(item.getValue());
          allImageNames.put(destName, greenImage);
          greenImage.setFileName(destName);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates greyscale image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createBlueGreyscale(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image blueImage = this.model.createBlueGreyScale(item.getValue());
          allImageNames.put(destName, blueImage);
          blueImage.setFileName(destName);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates greyscale image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createValueGreyscale(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image valueImage = this.model.createValueGreyScale(item.getValue());
          allImageNames.put(destName, valueImage);
          valueImage.setFileName(destName);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates greyscale image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createLumaGreyscale(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image lumaImage = this.model.createLumaGreyScale(item.getValue());
          allImageNames.put(destName, lumaImage);
          lumaImage.setFileName(destName);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates greyscale image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createIntensityGreyscale(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image intensityImage = this.model.createIntensityGreyScale(item.getValue());
          allImageNames.put(destName, intensityImage);
          intensityImage.setFileName(destName);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates horizontally flipped image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createHorizontalFlip(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image hfImage = this.model.horizontalFlipImage(item.getValue());
          hfImage.setFileName(destName);
          allImageNames.put(destName, hfImage);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates vertically flipped image.
   *
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createVerticalFlip(String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image vfImage = this.model.verticalFlipImage(item.getValue());
          vfImage.setFileName(destName);
          allImageNames.put(destName, vfImage);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Creates brightened image.
   *
   * @param increment is increment to be brightened by.
   * @param imageName is image name to be converted.
   * @param destName  is new image produced after operation is applied.
   */
  private void createBrighten(int increment, String imageName, String destName) {
    try {
      for (Map.Entry<String, Image> item : allImageNames.entrySet()) {
        if (imageName.equals(item.getKey())) {
          Image bImage = this.model.brightenImage(item.getValue(), increment);
          bImage.setFileName(destName);
          allImageNames.put(destName, bImage);
        } else {
          this.view.renderMessage("Specified image name does not exist.");
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

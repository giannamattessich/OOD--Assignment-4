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
 * takes user input and performs commands on the given model based on given user
 * input. The controller also outputs messages to view when an operation is
 * performed on an image.
 */
public class ImageControllerImpl implements ImageController {
  Readable inputStream;
  ImageView view;
  Image model;

  /**
   * Constructor for image program controller.
   *
   * @param inputStream represents user input stream.
   * @param view        represents program output stream (outputs to view).
   * @param model       represents model for operation to be performed on.
   * @throws IllegalArgumentException if any of the fields provided are null.
   */
  public ImageControllerImpl(Readable inputStream, ImageView view, Image model) throws IllegalArgumentException {
    if ((inputStream == null) || (view == null) || (model == null)) {
      throw new IllegalArgumentException("Fields of controller cannot be null.");
    }
    this.inputStream = inputStream;
    this.view = view;
    this.model = model;
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
        this.model = ImageUtil.readPPM(loadFilePath);
        String loadFileName = sc.next();
        promptLoad(loadFilePath, loadFileName);
        break;
      case "save":
        String saveFilePath = sc.next();
        String saveFileName = sc.next();
        promptSave(saveFilePath, saveFileName);
        break;
      case "red-component":
        createRedGreyscale();
        break;
      case "green-component":
        createGreenGreyscale();
        break;
      case "blue-component":
        createBlueGreyscale();
        break;
      case "value-component":
        createValueGreyscale();
        break;
      case "luma-component":
        createLumaGreyscale();
        break;
      case "intensity-component":
        createIntensityGreyscale();
        break;
      case "horizontal-flip":
        createHorizontalFlip();
        break;
      case "vertical-flip":
        createVerticalFlip();
        break;
      case "brighten":
        int brInc = sc.nextInt();
        createBrighten(brInc);
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
      this.view.renderMessage(
          "Welcome to Image Processor Program.\n" + "Commands with unique user-provided inputs are specified with <>.");
      this.view.renderMessage("<image-path> refers to file path of image to be operated on.");
      this.view.renderMessage("<image-name> refers to name given to reference an image.");
      this.view.renderMessage("<dest-image-name> refers to name given to reference an image"
          + "once a specified operation has been performed on it.)");
      this.view.renderMessage("load <image-path> <image-name> -> load image");
      this.view.renderMessage("save <image-path> <image-name> -> save image");
      this.view.renderMessage("red-component <image-name> <dest-image-name> -> produce image"
          + "that visualizes red component of pixels using greyscale.");
      this.view.renderMessage("green-component <image-name> <dest-image-name> -> produces image"
          + "that visualizes green component of pixels using greyscale.");
      this.view.renderMessage("blue-component <image-name> <dest-image-name> -> produces image"
          + "that visualizes blue component of pixels using greyscale.");
      this.view.renderMessage("value-component <image-name> <dest-image-name> -> produce image"
          + "that visualizes value component of pixels using greyscale.");
      this.view.renderMessage("luma-component <image-name> <dest-image-name> -> produces image"
          + "that visualizes luma component of pixels using greyscale.");
      this.view.renderMessage("intensity-component <image-name> <dest-image-name> -> produces"
          + " image that visualizes intensity component of pixels using greyscale.");
      this.view.renderMessage("horizontal-flip <image-name> <dest-image-name> -> flips image" + "horizontally");
      this.view.renderMessage("vertical-flip <image-name> <dest-image-name> -> flips" + "image vertically");
      this.view.renderMessage("brighten <increment> <image-name> <dest-image-name> -> brightens"
          + "image by specified increment(increment is positive).");
      this.view.renderMessage("darken <increment> <image-name> <dest-image-name> -> darkens"
          + "image by specified increment(increment is positive).");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Prompts load command.
   *
   * @param filePath is filepath of image.
   * @param fileName is filename of image.
   */
  private void promptLoad(String filePath, String fileName) {
    try {
      this.model.setFileName(fileName);
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
    try {
      ImageUtil.writePPMFile(filePath, model);
      this.view.renderMessage("File " + fileName + " saved!");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Makes the current image grescale on the red component.
   *
   */
  private void createRedGreyscale() {
    model.redComponent();
    try {
      this.view.renderMessage("Image red-component created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Makes the current image greyscale on the green component.
   *
   */
  private void createGreenGreyscale() {
    model.greenComponent();
    try {
      this.view.renderMessage("Image green-component created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Makes the current image greyscale on the blue component.
   *
   */
  private void createBlueGreyscale() {
    model.blueComponent();
    try {
      this.view.renderMessage("Image blue-component created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Makes the current image greyscale on the value component.
   *
   */
  private void createValueGreyscale() {
    model.valueComponent();
    try {
      this.view.renderMessage("Image value-component created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Makes the current image greyscale on the luma component.
   *
   */
  private void createLumaGreyscale() {
    model.lumaComponent();
    try {
      this.view.renderMessage("Image luma-component created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Makes the current image greyscale on the intensity component.
   *
   */
  private void createIntensityGreyscale() {
    model.intensityComponent();
    try {
      this.view.renderMessage("Image intensity-component created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * Flips the current image horizontally.
   *
   */
  private void createHorizontalFlip() {
    model.flipHorizontal();
    try {
      this.view.renderMessage("Image horizontal-flip created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Flips the current image vertically.
   *
   */
  private void createVerticalFlip() {
    model.flipVertical();
    try {
      this.view.renderMessage("Image vertical-flip created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * Brightens the current image by the specified increment.
   *
   * @param increment is the amount to brighten the image.
   */
  private void createBrighten(int increment) {
    model.brighten(increment);
    try {
      this.view.renderMessage("Image brighten created!");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}

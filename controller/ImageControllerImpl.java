package controller;

import java.io.IOException;
import java.util.Scanner;

import model.Image;
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
  }

  @Override
  public void promptImageCommand() throws IllegalStateException {
    Scanner sc = new Scanner(this.inputStream);
    String imageName;
    String imagePath;
    String destImageName;
    boolean quit = false;

    welcomeMessage();
    while (! quit) {
        this.view.renderMessage("Type Command:");
        String userCommand = sc.next();
        switch(userCommand) {
          case "load":
            String loadFilePath = sc.next();
            String loadFileName = sc.next();
            this.model.loadImage(loadFilePath, loadFileName);
            break;
          case "save":
            String saveFilePath = sc.next();
            String saveFileName = sc.next();
            this.model.saveImage(saveFilePath, saveFileName);
            break;
          case "red-component":
            imageName = sc.next();
            destImageName = sc.next();
            this.model.red
            this.model.saveImage()

          case "green-component":
          case "blue-component":
          case "value-component":
          case "luma-component":
          case "intensity-component":
          case "horizontal-flip":
          case "vertical-flip":
          case "brighten":
          case "darken":
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
  /*

  public void makeSpreadSheet() throws IllegalStateException {
    Scanner sc = new Scanner(this.readable);
    boolean quit = false;
    int row;
    int col;
    double value;

    //print the welcome message
    this.welcomeMessage();

    while (!quit) { //continue until the user quits
      writeMessage("Type instruction: "); //prompt for the instruction name
      String userInstruction = sc.next(); //take an instruction name
      switch (userInstruction) {
        case "assign-value": //assign a value to a cell
          try {
            row = getRowNum(sc.next()); //get in the row string
            col = sc.nextInt(); //get in the column number, starting with 1
            sheet.set(row, col - 1, sc.nextDouble()); //use the spreadsheet
          } catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "bulk-assign":
          try {
            row = getRowNum(sc.next());
            col = sc.nextInt();
            int row2 = getRowNum(sc.next());
            int col2 = sc.nextInt();
            value = sc.nextDouble();
            sheet.setBulkAssign(row, col, row2, col2, value);
          } catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "print-value": //print a value from the cell
          try {
            row = getRowNum(sc.next()); //get the row string
            col = sc.nextInt(); //get the column number, starting with 1
            writeMessage("Value: " + this.sheet.get(row, col - 1) + System.lineSeparator());
          } catch (IllegalArgumentException e) {
            writeMessage("Error: " + e.getMessage() + System.lineSeparator());
          }
          break;
        case "menu": //print the menu of supported instructions
          welcomeMessage();
          break;
        case "q": //quit
        case "quit": //quit
          quit = true;
          break;
        default: //error due to unrecognized instruction
          writeMessage("Undefined instruction: " + userInstruction + System.lineSeparator());
      }
    }

    //after the user has quit, print farewell message
    this.farewellMessage();

  }*/


}

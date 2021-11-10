package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import model.Image;
import model.ImageProcessorModel;
import model.ImageTransformations.colortransformations.GreyScale;
import model.ImageTransformations.colortransformations.Sepia;
import model.ImageTransformations.filters.BlurFilter;
import model.ImageTransformations.filters.SharpenFilter;
import model.ImageTransformations.fliptransformation.HorizontalFlip;
import model.ImageTransformations.fliptransformation.VerticalFlip;
import model.ImageTransformations.greyscaletransformation.BlueGreyScale;
import model.ImageTransformations.greyscaletransformation.GreenGreyScale;
import model.ImageTransformations.greyscaletransformation.IntensityGreyScale;
import model.ImageTransformations.greyscaletransformation.LumaGreyScale;
import model.ImageTransformations.greyscaletransformation.RedGreyScale;
import model.ImageTransformations.greyscaletransformation.ValueGreyScale;
import model.ImageTransformations.lighttransformation.Brighten;
import model.ImageTransformations.lighttransformation.Darken;
import utils.ImageUtil;
import view.ImageProcessorView;

/**
 * Class to implement controller of program. Controller takes in user input and
 * integrates that user input with commands performed by the model.
 */
public class ImageProcessorControllerImpl implements ImageProcessorController {
  private final ImageProcessorModel model;
  private final ImageProcessorView view;
  private final Readable reader;

  /**
   * Constructor for controller.
   *
   * @param model  uses input from controller.
   * @param view   transmits information to user.
   * @param reader creates input stream for user input.
   */
  public ImageProcessorControllerImpl(ImageProcessorModel model, ImageProcessorView view,
                                      Readable reader) {
    if (model == null) {
      throw new IllegalArgumentException("Model cannot be null.");
    }
    if (view == null) {
      throw new IllegalArgumentException("View cannot be null.");
    }
    if (reader == null) {
      throw new IllegalArgumentException("Input cannot be null.");
    }
    this.model = model;
    this.view = view;
    this.reader = reader;
  }

  @Override
  public void promptImageCommands() {
    Scanner sc = new Scanner(reader);
    promptWelcome();
    while (sc.hasNext()) {
      String userCmd = sc.next();
      switch (userCmd) {
        case "load":
          String loadFilePath = sc.next();
          String loadFileName = sc.next();
          promptLoadImage(loadFilePath, loadFileName);
          break;
        case "red-component":
          String rFileName = sc.next();
          String rFileDest = sc.next();
          Image rNewImage = this.model.getNewImage(rFileName, new RedGreyScale());
          this.model.addFile(rFileDest, rNewImage);
          includeTryCatchMessage("Red GreyScale " + rFileDest + " successfully created!");
          break;
        case "green-component":
          String gFileName = sc.next();
          String gFileDest = sc.next();
          Image gNewImage = this.model.getNewImage(gFileName, new GreenGreyScale());
          this.model.addFile(gFileDest, gNewImage);
          includeTryCatchMessage("Green GreyScale " + gFileDest + " successfully created!");
          break;
        case "blue-component":
          String bFileName = sc.next();
          String bFileDest = sc.next();
          Image bNewImage = this.model.getNewImage(bFileName, new BlueGreyScale());
          this.model.addFile(bFileDest, bNewImage);
          includeTryCatchMessage("Blue GreyScale " + bFileDest + " successfully created!");
          break;
        case "value-component":
          String vFileName = sc.next();
          String vFileDest = sc.next();
          Image vNewImage = this.model.getNewImage(vFileName, new ValueGreyScale());
          this.model.addFile(vFileDest, vNewImage);
          includeTryCatchMessage("Value GreyScale " + vFileDest + " successfully created!");
          break;
        case "intensity-component":
          String iFileName = sc.next();
          String iFileDest = sc.next();
          Image iNewImage = this.model.getNewImage(iFileName, new IntensityGreyScale());
          this.model.addFile(iFileDest, iNewImage);
          includeTryCatchMessage("Intensity GreyScale " + iFileDest + " successfully created!");
          break;
        case "luma-component":
          String lFileName = sc.next();
          String lFileDest = sc.next();
          Image lNewImage = this.model.getNewImage(lFileName, new LumaGreyScale());
          this.model.addFile(lFileDest, lNewImage);
          includeTryCatchMessage("Luma GreyScale " + lFileDest + " successfully created!");
          break;
        case "vertical-flip":
          String vfFileName = sc.next();
          String vfFileDest = sc.next();
          Image vfNewImage = this.model.getNewImage(vfFileName, new VerticalFlip());
          this.model.addFile(vfFileDest, vfNewImage);
          includeTryCatchMessage("Vertically flipped image, " + vfFileDest +
                  " successfully created!");
          break;
        case "horizontal-flip":
          String hfFileName = sc.next();
          String hfFileDest = sc.next();
          Image hfNewImage = this.model.getNewImage(hfFileName, new HorizontalFlip());
          this.model.addFile(hfFileDest, hfNewImage);
          includeTryCatchMessage("Horizontally flipped image, " + hfFileDest +
                  " successfully created!");
          break;
        case "brighten":
          int bIncrement = sc.nextInt();
          String brFileName = sc.next();
          String brFileDest = sc.next();
          Image brNewImage = this.model.getNewImage(brFileName, new Brighten(bIncrement));
          this.model.addFile(brFileDest, brNewImage);
          includeTryCatchMessage("Brightened image " + brFileDest +
                  " successfully created!");
          break;
        case "darken":
          int dIncrement = sc.nextInt();
          String dFileName = sc.next();
          String dFileDest = sc.next();
          Image dNewImage = this.model.getNewImage(dFileName, new Darken(dIncrement));
          this.model.addFile(dFileDest, dNewImage);
          includeTryCatchMessage("Darkened image " + dFileDest +
                  " successfully created!");
          break;
        case "sharpen":
          String sFileName = sc.next();
          String sFileDest = sc.next();
          Image sNewImage = this.model.getNewImage(sFileName, new SharpenFilter());
          this.model.addFile(sFileDest, sNewImage);
          includeTryCatchMessage("Sharpened image " + sFileDest +
                  " successfully created!");
          break;
        case "blur":
          String blFileName = sc.next();
          String blFileDest = sc.next();
          Image blNewImage = this.model.getNewImage(blFileName, new BlurFilter());
          this.model.addFile(blFileDest, blNewImage);
          includeTryCatchMessage("Blurred image " + blFileDest +
                  " successfully created!");
          break;
        case "greyscale":
          String grFileName = sc.next();
          String grFileDest = sc.next();
          Image grNewImage = this.model.getNewImage(grFileName, new GreyScale());
          this.model.addFile(grFileDest, grNewImage);
          includeTryCatchMessage("Greyscale image " + grFileDest +
                  " successfully created!");
          break;
        case "sepia":
          String seFileName = sc.next();
          String seFileDest = sc.next();
          Image seNewImage = this.model.getNewImage(seFileName, new Sepia());
          this.model.addFile(seFileDest, seNewImage);
          includeTryCatchMessage("Sepia image " + seFileDest +
                  " successfully created!");
          break;
        case "save":
          String saveImagePath = sc.next();
          String saveImageName = sc.next();
          promptSaveImage(saveImagePath, saveImageName);
          break;
        default:
          includeTryCatchMessage("This command does not exist.");
      }
    }
  }

  /**
   * Transmits welcome message to view.
   */
  private void promptWelcome() {
    try {
      this.view.renderWelcome();
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Transmission to Appendable failed.");
    }
  }

  /**
   * Loads image from given filepath.
   *
   * @param filePath file-path of image to be loaded.
   * @param fileName file-name used to reference this image.
   */
  private void promptLoadImage(String filePath, String fileName) {
    File temp = new File(filePath);
    if ((temp.exists()) && ((filePath.endsWith("ppm")) || (filePath.endsWith("png")) ||
            (filePath.endsWith("jpeg")) || (filePath.endsWith("jpg"))
            || (filePath.endsWith("bmp")))) {
      this.model.setImagePath(filePath);
      this.model.addFile(fileName, ImageUtil.readImageFile(filePath));
      includeTryCatchMessage("File " + fileName + " successfully loaded!");
    } else if (!temp.exists()) {
      includeTryCatchMessage("File " + fileName + " cannot be loaded because file-path " +
              filePath + " does not exist.");
    }
  }

  /**
   * Saves image from specified filename of image to specified filepath.
   *
   * @param filePath file-path to be saved to.
   * @param fileName file-name of image to be saved.
   */
  private void promptSaveImage(String filePath, String fileName) {
    if (filePath.contains(fileName)) {
      Image savedImg = model.getImage(fileName);
      ImageUtil.writeImageFile(filePath, savedImg);
      includeTryCatchMessage("Image " + fileName + " successfully saved to file "
              + filePath + "!");
    } else {
      includeTryCatchMessage("FilePath must include filename and end in PPM. Try again.");
    }
  }

  /**
   * Used to avoid nested try catch blocks. Attempts to render message, and handles transmission
   * failure accordingly.
   *
   * @param message is error message to be transmitted to view.
   */
  private void includeTryCatchMessage(String message) {
    try {
      this.view.renderMessage(message);
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("View Transmission failed.");
    }
  }
}

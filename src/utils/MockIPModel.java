package utils;

import java.io.IOException;

import model.Image;
import model.ImageProcessorModel;
import model.ImageTransformations.ImageProcessor;

/**
 * Class to represent mock ImageProcessorModel.
 */
public class MockIPModel implements ImageProcessorModel {
  Appendable log;

  /**
   * Constructor for a mock model.
   *
   * @param log keeps track of input given to model.
   */
  public MockIPModel(Appendable log) {
    this.log = log;
  }

  @Override
  public void setImagePath(String filePath) {
    try {
      log.append("Set image path is -> ").append(filePath).append("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getImagePath() {
    return "";
  }

  @Override
  public void addFile(String fileName, Image img) {
    try {
      log.append("Saved fileName is -> ").append(fileName).append("\n");
      log.append("Image ").append("is saved as ").append(fileName).append("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Image getImage(String fileName) {
    try {
      log.append("Retrieving key -> ").append(fileName).append("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public Image getNewImage(String fileName, ImageProcessor cmd) {
    try {
      log.append("Creating a transformed image of -> ").append(fileName).append("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}

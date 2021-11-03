package model;

import java.util.HashMap;

import model.ImageTransformations.ImageProcessor;

/**
 * Implementation of ImageProcessorModel. Model is constructed image
 * as well as a filepath. Model holds a hash map which holds filenames as
 * key values and their corresponding saved images.
 */
public class ImageProcessorModelImpl implements ImageProcessorModel {
  private String imagePath;
  private final HashMap<String, Image> imageNames;

  /**
   * Constructor to create an image processor model.
   * Fields have not yet been set until an image is loaded.
   */
  public ImageProcessorModelImpl() {
    this.imagePath = null;
    imageNames = new HashMap<String, Image>();
  }

  @Override
  public void setImagePath(String filePath) {
    this.imagePath = filePath;
  }

  @Override
  public String getImagePath() {
    return this.imagePath;
  }

  @Override
  public void addFile(String fileName, Image img) {
    this.imageNames.put(fileName, img);
  }

  @Override
  public Image getImage(String fileName) {
    if (this.imageNames.containsKey(fileName)) {
      return this.imageNames.get(fileName);
    } else {
      throw new IllegalArgumentException(fileName + "does not exist.");
    }
  }

  @Override
  public Image getNewImage(String fileName, ImageProcessor cmd) {
    if (this.imageNames.containsKey(fileName)) {
      return this.imageNames.get(fileName).changeImage(cmd);
    } else {
      throw new IllegalArgumentException(fileName + "does not exist.");
    }
  }

}

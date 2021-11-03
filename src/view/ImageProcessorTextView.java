package view;

import java.io.IOException;

/**
 * Class that implements functionality for the view. Allows messages
 * to be outputted to user via controller.
 */
public class ImageProcessorTextView implements ImageProcessorView {
  private final Appendable out;

  /**
   * The constructor for this ImageTextView.
   *
   * @param out the Appendable which transmits information to the user.
   */
  public ImageProcessorTextView(Appendable out) {
    this.out = out;
  }

  /**
   * Receives a message from the controller and outputs it to the user.
   *
   * @param message a String message to be outputted to the user.
   * @throws IOException thrown if transmission to view fails.
   */
  @Override
  public void renderMessage(String message) throws IOException {
    try {
      out.append(message);
      out.append("\n");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Transmission to view failed.");
    }
  }

  @Override
  public void renderWelcome() throws IOException {
    try {
      out.append("Welcome to Image Processor Program.\n\n");
      out.append("User commands are: \n");
      out.append("load <image-path> <image-name> -> load image\n");
      out.append("save <image-path> <image-name> -> save image\n");
      out.append("red-component <image-name> <dest-image-name> -> produce image" +
              " that visualizes red component of pixels using greyscale.\n");
      out.append("green-component <image-name> <dest-image-name> -> produces image" +
              " that visualizes green component of pixels using greyscale.\n");
      out.append("blue-component <image-name> <dest-image-name> -> produces image" +
              " that visualizes blue component of pixels using greyscale.\n");
      out.append("value-component <image-name> <dest-image-name> -> produce image" +
              " that visualizes value component of pixels using greyscale.\n");
      out.append("intensity-component <image-name> <dest-image-name> -> produces" +
              " image that visualizes intensity component of pixels using greyscale.\n");
      out.append("luma-component <image-name> <dest-image-name> -> produces image" +
              " that visualizes luma component of pixels using greyscale.\n");
      out.append("horizontal-flip <image-name> <dest-image-name> -> flips image" +
              " horizontally\n");
      out.append("vertical-flip <image-name> <dest-image-name> -> flips" +
              " image vertically\n");
      out.append("brighten <increment> <image-name> <dest-image-name> -> brightens" +
              " image by specified increment.\n");
      out.append("darken <increment> <image-name> <dest-image-name> -> darkens" +
              " image by specified increment.\n\n");
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Transmission to view failed.");
    }
  }
}
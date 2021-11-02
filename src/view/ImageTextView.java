package view;

import java.io.IOException;

/**
 * Class that implements functionality for the view. Allows messages
 * to be outputted to user via controller.
 */
public class ImageTextView implements ImageView {
  private final Appendable out;

  /**
   * The constructor for this ImageTextView.
   *
   * @param out the Appendable which transmits information to the user.
   */
  public ImageTextView(Appendable out) {
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

  /**
   * Appends the options that are available to the user in the controller.
   *
   * @throws IOException thrown if transmission to view fails.
   */
  public void showOptions() throws IOException {
    try {
      out.append(printUserOptions());
    } catch (IOException e) {
      e.printStackTrace();
      throw new IllegalStateException("Transmission to view failed.");
    }
  }

  private static String printUserOptions() {
    return "";
  }
}
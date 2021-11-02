package view;

import java.io.IOException;

/**
 * Represents the view to user using image processor program.
 * Allows user to view messages after performing commands on images.
 */
public interface ImageView {

  /**
   * Receives a message from the controller and outputs it to the user.
   *
   * @param message a String message outputted to the user.
   */
  public void renderMessage(String message) throws IOException;

  /**
   * Outputs the options for this ImageProcessor program to the user.
   */
  public void showOptions() throws IOException;
}

package view;

import java.io.IOException;

/**
 * Represents the view to user using image processor program.
 * Allows user to view messages after performing commands on images.
 */
public interface ImageProcessorView {

  /**
   * Receives a message from the controller and outputs it to the user.
   *
   * @param message a String message outputted to the user.
   * @throws IOException if transmission to this view fails.
   */
  public void renderMessage(String message) throws IOException;

  /**
   * Outputs welcome message.
   * @throws IOException if transmission to this view fails.
   */
  public void renderWelcome() throws IOException;
}

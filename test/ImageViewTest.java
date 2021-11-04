import org.junit.Test;

import java.io.IOException;

import utils.MockAppendable;
import view.ImageProcessorTextView;
import view.ImageProcessorView;

import static org.junit.Assert.assertEquals;

/**
 * Class to test view.
 */
public class ImageViewTest {
  Appendable ap = new StringBuilder();
  ImageProcessorView view = new ImageProcessorTextView(ap);
  ImageProcessorView fakeview = new ImageProcessorTextView(new MockAppendable());

  @Test(expected = IllegalStateException.class)
  public void testRenderMessageFail() {
    try {
      fakeview.renderMessage("This transmission fails");
    } catch (IOException e) {
      throw new IllegalStateException("Failed transmission");
    }
  }

  @Test
  public void testRenderMessage() {
    try {
      view.renderMessage("Message");
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("Message\n", ap.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void testRenderWelcomeFail() {
    try {
      fakeview.renderWelcome();
    } catch (IOException e) {
      throw new IllegalStateException("Failed transmission");
    }
  }

  @Test
  public void testRenderWelcome() {
    try {
      view.renderWelcome();
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertEquals("Welcome to Image Processor Program.\n" +
            "\n" +
            "User commands are: \n" +
            "load <image-path> <image-name> -> load image\n" +
            "save <image-path> <image-name> -> save image\n" +
            "red-component <image-name> <dest-image-name> -> produce image that visualizes " +
            "red component of pixels using greyscale.\n" +
            "green-component <image-name> <dest-image-name> -> produces image that visualizes" +
            " green component of pixels using greyscale.\n" +
            "blue-component <image-name> <dest-image-name> -> produces image that visualizes " +
            "blue component of pixels using greyscale.\n" +
            "value-component <image-name> <dest-image-name> -> produce image that " +
            "visualizes value component of pixels using greyscale.\n" +
            "intensity-component <image-name> <dest-image-name> -> produces image " +
            "that visualizes intensity component of pixels using greyscale.\n" +
            "luma-component <image-name> <dest-image-name> -> produces image that " +
            "visualizes luma component of pixels using greyscale.\n" +
            "horizontal-flip <image-name> <dest-image-name> -> flips image horizontally\n" +
            "vertical-flip <image-name> <dest-image-name> -> flips image vertically\n" +
            "brighten <increment> <image-name> <dest-image-name> -> brightens image by " +
            "specified increment.\ndarken <increment> <image-name> <dest-image-name> -> " +
            "darkens image by specified increment.\n\n", ap.toString());
  }
}

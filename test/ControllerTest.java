import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.io.StringWriter;

import javax.swing.text.html.ImageView;

import org.junit.Test;

import controller.ImageController;
import controller.ImageControllerImpl;
import model.Image;
import model.ImageMock;
import utils.ImageUtil;
import view.ImageTextView;

public class ControllerTest {
  /**
   * Test method for redComponent.
   */
  @Test
  public void testController() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("red-component");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("redComponent()", mock.getLog());
  }

  /**
   * Test method for greenComponent.
   */
  @Test
  public void testController2() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("green-component");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("greenComponent()", mock.getLog());
  }

  /**
   * Test method for valueComponent.
   */
  @Test
  public void testController3() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("value-component");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("valueComponent()", mock.getLog());
  }

  /**
   * Test method for lumaComponent.
   */
  @Test
  public void testController4() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("luma-component");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("lumaComponent()", mock.getLog());
  }

  /**
   * Test method for intensityComponent.
   */
  @Test
  public void testController5() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("intensity-component");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("intensityComponent()", mock.getLog());
  }

  /**
   * Test method for horizontalFlip.
   */
  @Test
  public void testController6() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("horizontal-flip");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("flipHorizontal()", mock.getLog());
  }

  /**
   * Test method for verticalFlip.
   */
  @Test
  public void testController7() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("vertical-flip");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("flipVertical()", mock.getLog());
  }

  /**
   * Test method for brighten by a constant.
   */
  @Test
  public void testController8() {
    Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");
    // feed image into the mock so that the command is not executed.
    ImageMock mock = new ImageMock(image);
    // stream view model
    Readable r = new StringReader("brighten 10");
    Appendable a = new StringWriter();
    ImageTextView iv = new ImageTextView(a);
    ImageController ic = new ImageControllerImpl(r, iv, mock);
    ic.promptImageCommand();
    // check if the command was passed to the mock
    assertEquals("brighten(10)", mock.getLog());
  }

}

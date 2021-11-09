import org.junit.Test;

import java.io.StringReader;
import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import model.ImageProcessorModel;
import model.ImageProcessorModelImpl;
import utils.MockIPModel;
import view.ImageProcessorTextView;
import view.ImageProcessorView;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class to test ImageProcessorController. Checks whether correct inputs are being sent to model
 * using model mock.
 */
public class ImageControllerTest {
  StringBuilder log = new StringBuilder();
  Appendable out = new StringBuilder();
  ImageProcessorModel mockMod = new MockIPModel(log);
  ImageProcessorView viewTest = new ImageProcessorTextView(out);

  @Test(expected = IllegalArgumentException.class)
  public void testContructConExcept() {
    Readable input = new StringReader("load res/TestPPM.ppm test");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, null, input);
  }

  @Test
  public void testLoadImage() {
    Readable input = new StringReader("load res/TestPPM.ppm test");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n", log.toString());
  }

  @Test
  public void testLoadImageBadPath() {
    //this will throw an exception and therefore nothing is sent to controller
    Readable input = new StringReader("load res/TestPRRRRRRPM.ppm test");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("", log.toString());
  }

  @Test
  public void saveImage() {
    Readable input = new StringReader("load images/koala.ppm koala " +
            "save res/koala.ppm koala");
    ImageProcessorController con = new ImageProcessorControllerImpl(new ImageProcessorModelImpl()
            , viewTest, input);
    con.promptImageCommands();
    assertTrue(out.toString().contains("File koala successfully loaded!\n" +
            "Image koala successfully saved to file res/koala.ppm!"));
  }

  @Test (expected = IllegalArgumentException.class)
  public void saveImageBadPath() {
    Readable input = new StringReader("load res/TestPPM.ppm test " +
            "save res/test.phe test");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n", log.toString());
  }

  @Test
  public void testWelcome() {
    Readable input = new StringReader("load res/TestPPM.ppm test ");
    ImageProcessorController con = new ImageProcessorControllerImpl(new ImageProcessorModelImpl(),
            viewTest, input);
    con.promptImageCommands();
    assertEquals("Welcome to Image Processor Program.\n" +
            "\n" +
            "User commands are: \n" +
            "load <image-path> <image-name> -> load image\n" +
            "save <image-path> <image-name> -> save image\n" +
            "red-component <image-name> <dest-image-name> -> produce image that visualizes " +
            "red component of pixels using greyscale.\n" +
            "green-component <image-name> <dest-image-name> -> produces image that visualizes " +
            "green component of pixels using greyscale.\n" +
            "blue-component <image-name> <dest-image-name> -> produces image that visualizes" +
            " blue component of pixels using greyscale.\n" +
            "value-component <image-name> <dest-image-name> -> produce image that visualizes" +
            " value component of pixels using greyscale.\n" +
            "intensity-component <image-name> <dest-image-name> -> produces image that " +
            "visualizes intensity component of pixels using greyscale.\n" +
            "luma-component <image-name> <dest-image-name> -> produces image that visualizes " +
            "luma component of pixels using greyscale.\n" +
            "horizontal-flip <image-name> <dest-image-name> -> flips image horizontally\n" +
            "vertical-flip <image-name> <dest-image-name> -> flips image vertically\n" +
            "brighten <increment> <image-name> <dest-image-name> -> brightens image by " +
            "specified increment.\n" +
            "darken <increment> <image-name> <dest-image-name> -> darkens image by " +
            "specified increment.\nsharpen <image-name> <dest-image-name> -> " +
            "produces sharpened image\nblur <image-name> <dest-image-name> -> produces blurred" +
            " image\ngreyscale <image-name> <dest-image-name> -> produces image with greyscale " +
            "filter applied\nsepia <image-name> <dest-image-name> -> produces image with sepia " +
            "filter applied\nFile test successfully loaded!\n", out.toString());
  }

  @Test
  public void testRedImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test red-component test testRed");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testRed\n" +
            "Image is saved as testRed\n", log.toString());
  }

  @Test
  public void testBlueImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test blue-component test testBlue");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testBlue\n" +
            "Image is saved as testBlue\n", log.toString());
  }

  @Test
  public void testGreenImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test " +
            "green-component test testGreen");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testGreen\n" +
            "Image is saved as testGreen\n", log.toString());
  }

  @Test
  public void testValueImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test value-component " +
            "test testVal");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testVal\n" +
            "Image is saved as testVal\n", log.toString());
  }

  @Test
  public void testIntensityImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test intensity-component " +
            "test testIntensity");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testIntensity\n" +
            "Image is saved as testIntensity\n", log.toString());
  }

  @Test
  public void testLumaImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test luma-component test testLuma");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testLuma\n" +
            "Image is saved as testLuma\n", log.toString());
  }

  @Test
  public void testFlipVImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test vertical-flip test testFlipV");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testFlipV\n" +
            "Image is saved as testFlipV\n", log.toString());
  }

  @Test
  public void testFlipHImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test horizontal-flip test" +
            " testFlipH");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testFlipH\n" +
            "Image is saved as testFlipH\n", log.toString());
  }

  @Test
  public void testBrightImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test brighten 300 test" +
            " testBrighten");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testBrighten\n" +
            "Image is saved as testBrighten\n", log.toString());
  }

  @Test
  public void testDarkImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test darken 20 test" +
            " testDarken");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testDarken\n" +
            "Image is saved as testDarken\n", log.toString());
  }

  @Test
  public void testGreyscaleImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test greyscale test testGreyscale " +
            "horizontal-flip testGreyscale testGreyscaleHor");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testGreyscale\n" +
            "Image is saved as testGreyscale\n" +
            "Creating a transformed image of -> testGreyscale\n" +
            "Saved fileName is -> testGreyscaleHor\n" +
            "Image is saved as testGreyscaleHor\n", log.toString());
  }

  @Test
  public void testSepiaImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test sepia test testSepia");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testSepia\n" +
            "Image is saved as testSepia\n", log.toString());
  }

  @Test
  public void testBlurImg() {
    Readable input = new StringReader("load res/TestPPM.ppm test blur test testBlur blur " +
            "testBlur testBlur2 blur testBlur2 testBlur3");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\nImage is saved as test\n" +
            "Creating a transformed image of -> test\nSaved fileName is -> testBlur\n" +
            "Image is saved as testBlur\nCreating a transformed image of -> testBlur\n" +
            "Saved fileName is -> testBlur2\nImage is saved as testBlur2\n" +
            "Creating a transformed image of -> testBlur2\nSaved fileName is -> testBlur3\n" +
            "Image is saved as testBlur3\n", log.toString());
  }

  @Test
  public void testSharpen() {
    Readable input = new StringReader("load res/TestPPM.ppm test sharpen test testSharpen" +
            " red-component testSharpen testSharpenRed");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n" +
            "Creating a transformed image of -> test\n" +
            "Saved fileName is -> testSharpen\n" +
            "Image is saved as testSharpen\n" +
            "Creating a transformed image of -> testSharpen\n" +
            "Saved fileName is -> testSharpenRed\n" +
            "Image is saved as testSharpenRed\n", log.toString());
  }

  @Test
  public void testDefaultCommand() {
    Readable input = new StringReader("load res/TestPPM.ppm test darkEEen 20 test" +
            " testDarken");
    ImageProcessorController con = new ImageProcessorControllerImpl(mockMod, viewTest, input);
    con.promptImageCommands();
    assertEquals("Set image path is -> res/TestPPM.ppm\n" +
            "Saved fileName is -> test\n" +
            "Image is saved as test\n", log.toString());
  }
}

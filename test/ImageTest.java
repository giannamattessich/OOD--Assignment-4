import org.junit.Test;

import model.Image;
import model.Pixel;
import utils.ImageUtil;

import static org.junit.Assert.assertEquals;

public class ImageTest {
  Image image = ImageUtil.readPPM("/Users/oliversilverstein/Documents/GitHub/OOD--Assignment-4/src/images/Koala.ppm");

  /**
   * Test the height of the image.
   */
  @Test
  public void testHeight() {
    assertEquals(768, image.getHeight());
  }

  /**
   * Test the width of the image.
   */
  @Test
  public void testWidth() {
    assertEquals(1024, image.getWidth());
  }

  /**
   * Tests the contents of the photo were loaded. Also tests getPixelAt. Checks
   * the value of the first pixel at (0, 0). Known to be 101.
   */
  @Test
  public void testGetPixelAt() {
    assertEquals(101, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Tests fileName setter/getters.
   */
  @Test
  public void testFileName() {
    image.setFileName("test");
    assertEquals("test", image.getFileName());
  }

  /**
   * Tests the setPixelAt method.
   */
  @Test
  public void testSetPixelAt() {
    image.setPixelAt(0, 0, new Pixel(1, 2, 3));
    assertEquals(1, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Tests the getImagePixels method. They work with Pixel[][].
   */
  @Test
  public void testGetImagePixels() {
    Pixel[][] pixels = image.getImagePixels();
    assertEquals(768, pixels.length);
    assertEquals(1024, pixels[0].length);
  }

  /**
   * Tests the setImaePixels method. They work with Pixel[][].
   */
  @Test
  public void testSetImagePixels() {
    Pixel[][] pixels = new Pixel[2][2];
    image.setImagePixels(pixels);
    assertEquals(2, image.getImagePixels().length);
  }

  /**
   * Test flipVertical which flips the image's pixels.
   */
  @Test
  public void testFlipVertical() {
    image.flipVertical();
    assertEquals(218, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Test flipHorizontal which flips the image's pixels.
   */
  @Test
  public void testFlipHorizontal() {
    image.flipHorizontal();
    assertEquals(92, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Test the brighten method which brightens the image a certain amount.
   */
  @Test
  public void testBrighten() {
    image.brighten(10);
    assertEquals(68, image.getPixelAt(0, 0).getBlue());
  }

  /**
   * Test the darken method which darkens the image a certain amount.
   */
  @Test
  public void testDarken() {
    image.darken(10);
    assertEquals(48, image.getPixelAt(0, 0).getBlue());
  }

  /**
   * Test the redComponent method.
   */
  @Test
  public void testRedComponent() {
    image.redComponent();
    //blue has now been set to red
    assertEquals(101, image.getPixelAt(0, 0).getBlue());
  }

  /**
   * Test the greenComponent method.
   */
  @Test
  public void testGreenComponent() {
    image.greenComponent();
    //blue has now been set to green
    assertEquals(90, image.getPixelAt(0, 0).getBlue());
  }

  /**
   * Test the blueComponent method.
   */
  @Test
  public void testBlueComponent() {
    image.blueComponent();
    //red has now been set to blue
    assertEquals(58, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Test the lumaComponent method.
   */
  @Test
  public void testLumaComponent() {
    image.lumaComponent();
    //red has now been set to luma
    assertEquals(90, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Test the intensityComponent method.
   */
  @Test
  public void testIntensityComponent() {
    image.intensityComponent();
    //red has now been set to intensity
    assertEquals(83, image.getPixelAt(0, 0).getRed());
  }

  /**
   * Test the valueComponent method.
   */
  @Test
  public void testValueComponent() {
    image.valueComponent();
    //red has now been set to value
    assertEquals(101, image.getPixelAt(0, 0).getRed());
  }
}

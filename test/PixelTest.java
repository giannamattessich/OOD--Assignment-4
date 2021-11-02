import org.junit.Test;

import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to test methods which operate on pixel objects.
 */
public class PixelTest {

  @Test
  public void testConstructPixel() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(24, 38, 119);
    assertNotEquals(test, test2);
    assertEquals(test, test3);
    assertEquals(test.hashCode(), test3.hashCode());
    assertNotEquals(test2.hashCode(), test3.hashCode());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testConstructPixelException() {
    Pixel badTest = new Pixel(-2, 1, 233);
    Pixel badTest2 = new Pixel(-255, 1, 3);
  }

  @Test
  public void testGetPixelValue() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0,0,0);
    assertEquals(119, test.getPixelValue());
    assertEquals(254, test2.getPixelValue());
    assertEquals(0, test3.getPixelValue());
  }

  @Test
  public void testGetPixelIntensity() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0,0,0);
    assertEquals(60, test.getPixelIntensity());
    assertEquals(224, test2.getPixelIntensity());
    assertEquals(0, test3.getPixelIntensity());
  }

  @Test
  public void testGetPixelLuma() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0,0,0);
  }

  @Test
  public void testVisualizeRedChannel() {

  }

  @Test
  public void testVisualizeGreenChannel() {

  }

  @Test
  public void testVisualizeBlueChannel() {

  }




}

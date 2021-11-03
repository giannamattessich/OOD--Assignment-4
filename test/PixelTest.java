import org.junit.Test;

import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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

  @Test(expected = IllegalArgumentException.class)
  public void testConstructPixelException() {
    Pixel badTest = new Pixel(-2, 1, 233);
    Pixel badTest2 = new Pixel(-255, 1, 3);
  }

  @Test
  public void testGetPixelValue() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    assertEquals(119, test.getPixelValue());
    assertEquals(254, test2.getPixelValue());
    assertEquals(0, test3.getPixelValue());
  }

  @Test
  public void testGetPixelIntensity() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    assertEquals(60, test.getPixelIntensity());
    assertEquals(223, test2.getPixelIntensity());
    assertEquals(0, test3.getPixelIntensity());
  }

  @Test
  public void testGetPixelLuma() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    assertEquals(40, test.getPixelLuma());
    assertEquals(242, test2.getPixelLuma());
    assertEquals(0, test3.getPixelLuma());
  }

  @Test
  public void testBrighten() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    Pixel p = new Pixel(44, 58, 139);
    Pixel pr = test.brighten(20);
    Pixel p2 = new Pixel(255, 255, 255);
    Pixel pr2 = test2.brighten(100);
    Pixel p3 = new Pixel(208, 244, 189);
    Pixel pr3 = test3.brighten(-2);
    Pixel pr4 = test3.brighten(280);
    assertTrue(pr.equals(p));
    assertTrue(pr2.equals(p2));
    assertTrue(pr3.equals(test3));
    assertTrue(pr4.equals(p2));
  }

  @Test
  public void testGetRed() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    assertEquals(24, test.getRed());
    assertEquals(218, test2.getRed());
    assertEquals(0, test3.getRed());
  }

  @Test
  public void testGetGreen() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    assertEquals(38, test.getGreen());
    assertEquals(254, test2.getGreen());
    assertEquals(0, test3.getGreen());
  }

  @Test
  public void testGetBlue() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(218, 254, 199);
    Pixel test3 = new Pixel(0, 0, 0);
    Pixel p2 = test2.brighten(400);
    assertEquals(119, test.getBlue());
    assertEquals(199, test2.getBlue());
    assertEquals(255, p2.getBlue());
    assertEquals(0, test3.getBlue());
  }

  @Test
  public void testSetRed() {
    Pixel test = new Pixel(24, 38, 119);
    test.setRed(38);
    Pixel test2 = new Pixel(218, 254, 199);
    test2.setRed(200);
    Pixel test3 = new Pixel(0, 0, 0);
    test3.setRed(0);
    assertEquals(38, test.getRed());
    assertEquals(200, test2.getRed());
    assertEquals(0, test3.getRed());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetNegativeException() {
    Pixel test = new Pixel(0, 0, 0);
    test.setRed(-100);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testSetLimitExceptions() {
    Pixel test = new Pixel(0, 0, 0);
    test.setGreen(300);
  }

  @Test
  public void testSetGreen() {
    Pixel test = new Pixel(24, 38, 119);
    test.setGreen(38);
    Pixel test2 = new Pixel(218, 254, 199);
    test2.setGreen(200);
    Pixel test3 = new Pixel(0, 0, 0);
    test3.setGreen(0);
    assertEquals(38, test.getGreen());
    assertEquals(200, test2.getGreen());
    assertEquals(0, test3.getGreen());
  }

  @Test
  public void testSetBlue() {
    Pixel test = new Pixel(24, 38, 119);
    test.setBlue(38);
    Pixel test2 = new Pixel(218, 254, 199);
    test2.setBlue(200);
    Pixel test3 = new Pixel(0, 0, 0);
    test3.setBlue(0);
    assertEquals(38, test.getBlue());
    assertEquals(38, test.getGreen());
    assertEquals(200, test2.getBlue());
    assertEquals(0, test3.getBlue());
  }

  @Test
  public void testPixelEquals() {
    Pixel test = new Pixel(24, 38, 119);
    Pixel test2 = new Pixel(24, 38, 119);
    Pixel test3 = new Pixel(4, 3, 3);
    assertEquals(test, test2);
    assertNotEquals(test, test3);
  }

  @Test
  public void testPixelHash() {
    Pixel test = new Pixel(24, 38, 119);
    int h = test.hashCode();
    Pixel test2 = new Pixel(24, 38, 119);
    int h2 = test2.hashCode();
    Pixel test3 = new Pixel(4, 3, 3);
    int h3 = test3.hashCode();
    assertEquals(h, h2);
    assertNotEquals(h2, h3);
  }
}

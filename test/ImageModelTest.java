import org.junit.Test;

import java.util.Arrays;

import model.Image;
import model.ImageModel;
import model.imagetransformations.colortransformation.BlueGreyScale;
import model.imagetransformations.colortransformation.GreenGreyScale;
import model.imagetransformations.colortransformation.RedGreyScale;
import model.imagetransformations.fliptransformation.VerticalFlip;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

/**
 * Class to test an image model, which is constructed with image pixels.
 */
public class ImageModelTest {
  private final Pixel[][] imgpixels;
  private final Pixel[][] imgpixels2;
  private final Pixel[][] imgpixels3;
  private final Image test;
  private final Image test2;
  private final Image test3;

  /**
   * Constructor for an image model test.
   */
  public ImageModelTest() {
    this.imgpixels = new Pixel[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.imgpixels[i][j] = new Pixel(0, 0, 0);
      }
    }
    this.test = new ImageModel(this.imgpixels);
    this.imgpixels2 = new Pixel[4][4];
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        this.imgpixels2[i][j] = new Pixel(255, 255, 255);
      }
    }
    this.test2 = new ImageModel(this.imgpixels2);

    this.imgpixels3 = new Pixel[3][3];
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        this.imgpixels3[i][j] = new Pixel(0, 0, 0);
      }
    }
    this.test3 = new ImageModel(this.imgpixels3);
  }

  @Test
  public void testGetPixelAt() {
    Pixel p1 = new Pixel(255, 255, 255);
    Pixel p2 = test.getPixelAt(2,2);
    Pixel p3 = new Pixel(0,0,0);
    Pixel p4 = test2.getPixelAt(1,0);
    Pixel p5 = test3.getPixelAt(1,2);
    assertEquals(p2, p5);
    assertEquals(p4, p1);
    assertEquals(p5, p3);
  }

  @Test
  public void testSetPixelAt() {
    Pixel p = new Pixel(1, 2, 3);
    Pixel p2 = new Pixel(0,0,0);
    assertEquals(p2, test.getPixelAt(2, 2));
    test.setPixelAt(2, 2, 1, 2, 3);
    assertEquals(p, test.getPixelAt(2, 2));
  }

  @Test
  public void testGetImagePixels() {
    assertTrue(Arrays.deepEquals(imgpixels, test.getImagePixels()));
    assertTrue(Arrays.deepEquals(imgpixels2, test2.getImagePixels()));
    assertTrue(Arrays.deepEquals(imgpixels, test3.getImagePixels()));
    assertTrue(Arrays.deepEquals(imgpixels3, test3.getImagePixels()));
  }

  @Test
  public void testGetWidth() {
    assertEquals(3, test.getWidth());
    assertEquals(4, test2.getWidth());
    assertEquals(3, test.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(3, test.getHeight());
    assertEquals(4, test2.getHeight());
    assertEquals(3, test.getHeight());
  }

  @Test
  public void testChangeImage() {
    assertEquals(test.changeImage(new RedGreyScale()), test3.changeImage(new BlueGreyScale()));
    assertNotEquals(test, test.changeImage(new VerticalFlip()));
    assertEquals(test2.changeImage(new GreenGreyScale()), test2);
  }

  @Test
  public void testEquals() {
    assertEquals(test, test3);
    assertNotEquals(test, test2);
  }

  @Test
  public void testHashCode() {
    assertEquals(test.hashCode(), test3.hashCode());
    assertNotEquals(test.hashCode(), test2.hashCode());
  }
}

import org.junit.Test;

import model.Image;
import model.ImageProcessorModel;
import model.ImageProcessorModelImpl;
import model.imagetransformations.colortransformation.RedGreyScale;
import utils.ImageUtil;

import static org.junit.Assert.assertEquals;

/**
 * Class to test Image Processor Model.
 */
public class ImageProcessorModelTest {
  ImageProcessorModel test = new ImageProcessorModelImpl();
  ImageProcessorModel test2 = new ImageProcessorModelImpl();
  Image img = ImageUtil.readPPM("res/TestPPM.ppm");
  Image redImg = ImageUtil.readPPM("res/TestPPM.ppm").changeImage(new RedGreyScale());


  @Test
  public void testSetImagePath() {
    this.test.setImagePath("res/TestPPM.ppm");
    this.test2.setImagePath("res/TestPPM.ppm");
    assertEquals(test.getImagePath(), test2.getImagePath());
  }

  @Test
  public void testAddFileAndGetImage() {
    test.addFile("test", ImageUtil.readPPM("res/TestPPM.ppm"));
    assertEquals(ImageUtil.readPPM("res/TestPPM.ppm"), test.getImage("test"));
  }

  @Test
  public void testGetRed() {
    test.addFile("test", ImageUtil.readPPM("res/TestPPM.ppm"));
    test.addFile("testRed", test.getNewImage("test", new RedGreyScale()));
    assertEquals(redImg, test.getImage("testRed"));
  }
}

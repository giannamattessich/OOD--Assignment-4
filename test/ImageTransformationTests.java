import org.junit.Test;
import java.util.Arrays;
import model.Image;
import model.ImageModel;
import model.Pixel;
import model.imagetransformations.colortransformations.GreyScale;
import model.imagetransformations.colortransformations.Sepia;
import model.imagetransformations.filters.BlurFilter;
import model.imagetransformations.filters.SharpenFilter;
import model.imagetransformations.fliptransformation.HorizontalFlip;
import model.imagetransformations.fliptransformation.VerticalFlip;
import model.imagetransformations.greyscaletransformation.BlueGreyScale;
import model.imagetransformations.greyscaletransformation.GreenGreyScale;
import model.imagetransformations.greyscaletransformation.IntensityGreyScale;
import model.imagetransformations.greyscaletransformation.LumaGreyScale;
import model.imagetransformations.greyscaletransformation.RedGreyScale;
import model.imagetransformations.greyscaletransformation.ValueGreyScale;
import model.imagetransformations.lighttransformation.Brighten;
import model.imagetransformations.lighttransformation.Darken;
import static org.junit.Assert.assertTrue;

/**
 * Class to test image transformations.
 */
public class ImageTransformationTests {
  Pixel[][] pixels = {
    {
      new Pixel(181, 39, 34),
        new Pixel(181, 88, 34),
        new Pixel(204, 167, 20)
    },
    {
      new Pixel(24, 201, 39),
      new Pixel(22, 148, 201),
      new Pixel(79, 24, 199)
    }
  };

  @Test
  public void testRedTransform() {
    Pixel[][] redPixels = {
      {
        new Pixel(181, 181, 181), new Pixel(181, 181, 181), new Pixel(204, 204, 204)
      },
      {
        new Pixel(24, 24, 24),
        new Pixel(22, 22, 22),
        new Pixel(79, 79, 79)
      }
    };
    Image redImage = new ImageModel(redPixels);
    Image testRedTransform = new ImageModel(pixels);
    testRedTransform.changeImage(new RedGreyScale());
    assertTrue(Arrays.deepEquals(redImage.getImagePixels(), testRedTransform.getImagePixels()));
  }

  @Test
  public void testGreenTransform() {
    Pixel[][] greenPixels = {
      {
        new Pixel(39, 39, 39), new Pixel(88, 88, 88), new Pixel(167, 167, 167)
      },
      {
        new Pixel(201, 201, 201),
        new Pixel(148, 148, 148),
        new Pixel(24, 24, 24)
      }
    };
    Image testGTransform = new ImageModel(pixels);
    testGTransform = testGTransform.changeImage(new GreenGreyScale());
    assertTrue(Arrays.deepEquals(greenPixels, testGTransform.getImagePixels()));
  }

  @Test
  public void testBlueTransform() {
    Pixel[][] bluePixels = {
      {
        new Pixel(34, 34, 34), new Pixel(34, 34, 34), new Pixel(20, 20, 20)
      },
      {
        new Pixel(39, 39, 39),
        new Pixel(201, 201, 201),
        new Pixel(199, 199, 199)
      }
    };
    Image testBTransform = new ImageModel(pixels);
    testBTransform = testBTransform.changeImage(new BlueGreyScale());
    assertTrue(Arrays.deepEquals(bluePixels, testBTransform.getImagePixels()));
  }

  @Test
  public void testValueTransform() {
    Pixel[][] valuePixels = {
      {
        new Pixel(181, 181, 181), new Pixel(181, 181, 181), new Pixel(204, 204, 204)
      },
      {
        new Pixel(201, 201, 201),
        new Pixel(201, 201, 201),
        new Pixel(199, 199, 199)
      }
    };
    Image testVTransform = new ImageModel(pixels);
    testVTransform = testVTransform.changeImage(new ValueGreyScale());
    assertTrue(Arrays.deepEquals(valuePixels, testVTransform.getImagePixels()));
  }

  @Test
  public void testIntensityTransform() {
    Pixel[][] intensityPixels = {
      {
        new Pixel(84, 84, 84), new Pixel(101, 101, 101), new Pixel(130, 130, 130)
      },
      {
        new Pixel(88, 88, 88),
        new Pixel(123, 123, 123),
        new Pixel(100, 100, 100)
      }
    };
    Image testITransform = new ImageModel(pixels);
    testITransform = testITransform.changeImage(new IntensityGreyScale());
    assertTrue(Arrays.deepEquals(intensityPixels, testITransform.getImagePixels()));
  }

  @Test
  public void testLumaTransform() {
    Pixel[][] lumaPixels = {
      {
        new Pixel(68, 68, 68), new Pixel(103, 103, 103), new Pixel(164, 164, 164)
      },
      {
        new Pixel(151, 151, 151),
        new Pixel(125, 125, 125),
        new Pixel(48, 48, 48)
      }
    };
    Image testLTransform = new ImageModel(pixels);
    testLTransform = testLTransform.changeImage(new LumaGreyScale());
    assertTrue(Arrays.deepEquals(lumaPixels, testLTransform.getImagePixels()));
  }

  @Test
  public void testBrightenTransform() {
    Pixel[][] brightPixels = {
      {
        new Pixel(241, 99, 94), new Pixel(241, 148, 94), new Pixel(255, 227, 80)
      },
      {
        new Pixel(84, 255, 99),
        new Pixel(82, 208, 255),
        new Pixel(139, 84, 255)
      }
    };
    Image testBTransform = new ImageModel(pixels);
    Image test = testBTransform.changeImage(new Brighten(60));
    assertTrue(Arrays.deepEquals(brightPixels, test.getImagePixels()));
  }

  @Test
  public void testDarkenTransform() {
    Pixel[][] darkPixels = {
      {
        new Pixel(121, 0, 0), new Pixel(121, 28, 0), new Pixel(144, 107, 0)
      },
      {
        new Pixel(0, 141, 0),
        new Pixel(0, 88, 141),
        new Pixel(19, 0, 139)
      }
    };
    Image testDTransform = new ImageModel(pixels);
    Image test = testDTransform.changeImage(new Darken(60));
    assertTrue(Arrays.deepEquals(darkPixels, test.getImagePixels()));
  }

  @Test
  public void testVertFlip() {
    Pixel[][] vertPixels = {
      {
        new Pixel(24, 201, 39), new Pixel(22, 148, 201), new Pixel(79, 24, 199)
      },
      {
        new Pixel(181, 39, 34),
        new Pixel(181, 88, 34),
        new Pixel(204, 167, 20)
      }
    };
    Image testVTransform = new ImageModel(pixels);
    testVTransform.changeImage(new VerticalFlip());
    assertTrue(Arrays.deepEquals(vertPixels, testVTransform.getImagePixels()));

  }

  @Test
  public void testHorFlip() {
    Pixel[][] horPixels = {
      {
        new Pixel(204, 167, 20), new Pixel(181, 88, 34), new Pixel(181, 39, 34)
      },
      {
        new Pixel(79, 24, 199),
        new Pixel(22, 148, 201),
        new Pixel(24, 201, 39)
      }
    };
    Image testHTransform = new ImageModel(pixels);
    testHTransform.changeImage(new HorizontalFlip());
    assertTrue(Arrays.deepEquals(horPixels, testHTransform.getImagePixels()));
  }

  @Test
  public void testPixels() {
    try {
      Pixel[][] pixels = {
        {
          new Pixel(181, 39, 34), new Pixel(181, 88, 34), new Pixel(204, 167, 20)
        },
        {
          new Pixel(24, 201, 39),
          new Pixel(22, 148, 201),
          new Pixel(79, 24, 199)
        }
      };
      Image img = new ImageModel(pixels);
      Image redImg = img.changeImage(new SharpenFilter());
      for (int i = 0; i < pixels.length; i++) {
        for (int j = 0; j < pixels[0].length; j++) {
          assertEquals(redImg.getPixelAt(i, j).getRed(), pixels[i][j].getRed());
        }
      }
    }
    catch (Exception e) {
      System.out.println(e.getMessage());
    }
    
  }

  @Test
  public void testSharpen() {
    Pixel[][] sharpPixel = {
      {
        new Pixel(117, 40, 28), new Pixel(117, 88, 28), new Pixel(99, 129, 19)
      },
      {
        new Pixel(24, 99, 40),
        new Pixel(23, 141, 99),
        new Pixel(81, 24, 105)
      }
    };
    Image testSTransform = new ImageModel(pixels);
    Image newS = testSTransform.changeImage(new SharpenFilter());
    assertTrue(Arrays.deepEquals(sharpPixel, newS.getImagePixels()));
  }

  @Test
  public void testBlur() {
    Pixel[][] blurPixel = {
      {
        new Pixel(177, 33, 32), new Pixel(177, 86, 32), new Pixel(199, 161, 17)
      },
      {
        new Pixel(22, 198, 33),
        new Pixel(17, 145, 198),
        new Pixel(71, 22, 193)
      }
    };
    Image testBTransform = new ImageModel(pixels);
    testBTransform.changeImage(new BlurFilter());
    assertTrue(Arrays.deepEquals(blurPixel, testBTransform.getImagePixels()));
  }

  @Test
  public void testGreyscale() {
    Pixel[][] greyScalePixel = {
      {
        new Pixel(68, 137, 206), new Pixel(103, 207, 255), new Pixel(164, 255, 255)
      },
      {
        new Pixel(151, 255, 255),
        new Pixel(125, 250, 255),
        new Pixel(48, 96, 144)
      }
    };
    Image testGTransform = new ImageModel(pixels);
    Image test = testGTransform.changeImage(new GreyScale());
    assertTrue(Arrays.deepEquals(greyScalePixel, test.getImagePixels()));
  }

  @Test
  public void testSepia() {
    Pixel[][] sepiaPixel = {
      {
        new Pixel(107, 203, 255), new Pixel(145, 255, 255), new Pixel(212, 255, 255)
      },
      {
        new Pixel(171, 255, 255),
        new Pixel(160, 255, 255),
        new Pixel(87, 164, 224)
      }
    };
    Image testSTransform = new ImageModel(pixels);
    Image test = testSTransform.changeImage(new Sepia());
    assertTrue(Arrays.deepEquals(sepiaPixel, test.getImagePixels()));
  }
}
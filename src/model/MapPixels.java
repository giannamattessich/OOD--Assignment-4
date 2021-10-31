package model;

import java.util.function.Function;

/**
 * This class represents a function that can be applied to a pixel.
 */
public class MapPixels implements Function<Pixel, Pixel> {

  /**
   * The function to apply to a pixel.
   */
  private Function<Pixel, Pixel> function;

  /**
   * Constructor.
   *
   * @param function the function to apply to a pixel.
   */
  public MapPixels(Function<Pixel, Pixel> function) {
    this.function = function;
  }

  /**
   * Applies the function to a pixel.
   *
   * @param pixel the pixel to apply the function to.
   * @return the result of the function.
   */
  @Override
  public Pixel apply(Pixel pixel) {
    return function.apply(pixel);
  }

}

package utils;

import java.io.IOException;

/**
 * Class used for testing the view.
 * Utilized in order to check view behavior when transmission to the view fails.
 */
public class MockAppendable implements Appendable {

  @Override
  public Appendable append(CharSequence csq) throws IOException {
    throw new IOException("Transmission to view fails.");
  }

  @Override
  public Appendable append(CharSequence csq, int start, int end) throws IOException {
    throw new IOException("Transmission to view fails.");
  }

  @Override
  public Appendable append(char c) throws IOException {
    throw new IOException("Transmission to view fails.");
  }
}

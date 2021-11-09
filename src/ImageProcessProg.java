import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Scanner;

import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import model.ImageProcessorModel;
import model.ImageProcessorModelImpl;
import view.ImageProcessorTextView;
import view.ImageProcessorView;

/**
 * Class with main method.
 */
public class ImageProcessProg {

  /**
   * Main method of image processor program.
   *
   * @param args command-line args.
   */
  public static void main(String[] args) {
    try {
      Scanner scn = new Scanner(new File(args[0]));
    } catch (FileNotFoundException f) {
      System.out.println("Provide text file or load image.");
    }
    Readable input = new BufferedReader(new InputStreamReader(System.in));
    ImageProcessorModel model = new ImageProcessorModelImpl();
    ImageProcessorView view = new ImageProcessorTextView(System.out);
    ImageProcessorController controller = new ImageProcessorControllerImpl(model, view, input);
    controller.promptImageCommands();
  }
}

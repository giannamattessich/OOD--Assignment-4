import java.io.BufferedReader;
import java.io.InputStreamReader;

import controller.ImageProcessorController;
import controller.ImageProcessorControllerImpl;
import model.ImageProcessorModel;
import model.ImageProcessorModelImpl;
import view.ImageProcessorTextView;
import view.ImageProcessorView;

public class ImageProcessProg {

  public static void main(String[] args) {
    Readable input = new BufferedReader(new InputStreamReader(System.in));
    ImageProcessorModel model = new ImageProcessorModelImpl();
    ImageProcessorView view = new ImageProcessorTextView(System.out);
    ImageProcessorController controller = new ImageProcessorControllerImpl(model, view, input);
    controller.promptImageCommands();
  }
}

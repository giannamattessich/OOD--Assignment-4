# Image Processor in Java

For this Java assignment, we are implementing a CLI image processor. To start, we represent the general `ImageModel` type as an interface. This interface contains methods to observe implementation and also a way to send in a transformation.

  

The model, view and controller are separated with classes pertaining to each in their respective folders. At the most basic level, an Image model is just the original image path the image is loaded from. The controller just initializes that path into a map of Path and Image pairs so that model remembers where an image belongs and the current state of that image. The model can work with one or more images.

  

Transformations are performed under implementations of the ImageProcessor which returns a new Image. This allows the complete abstraction of different transformation. The new image returned from a transformation is saved to an area previously specified during the transformation initialization. Every transformation is an implementation of the `ImageProcessor` interface which simply allows an action to be applied and a new image returned. The feeding of transformations and intake of commands is all done by the controller.

  

The view has the ability to render messages and the welcome message to provide CLI instructions to the user. Since an image cannot effectively be represented as a string, the text view implementation we have right now does not allow the user to meaningfully interact with the image. However, it does allow the user to see how the image is transformed.

  

To enable insight into the behvaiour of the MVC components, we used mocks for the image (`ImageMock`), appendable (`MockAppendable`), image processor (`MockIPModel`). The `MockAppendable` is used to capture the output of the view. The `ImageMock` class is used to log commands sent to the model by the controller. The `MockIPModel` is used to log the controller's use of commands associated with file management (loading, saving etc.).

  

To get started, look in the `utils` folder. There you will see a file called `userScript` of parameters that must be added to command line arguments in order to run every command as requested in the specs.

List of commands and how to use them:

 - load *image-path*  *image-name* -> load image
 - save *image-path*  *image-name* -> save image
 - red-component *image-name*  *dest-image-name* -> produce image that visualizes red component of pixels using greyscale.
 - green-component *image-name*  *dest-image-name* -> produces image that visualizes green component of pixels using greyscale.
 - blue-component *image-name*  *dest-image-name* -> produces image that visualizes blue component of pixels using greyscale.
 - value-component *image-name*  *dest-image-name* -> produce image that visualizes value component of pixels using greyscale.
 - luma-component *image-name*  *dest-image-name* -> produces image that visualizes luma component of pixels using greyscale.
 - intensity-component *image-name*  *dest-image-name* -> produces image that visualizes intensity component of pixels using greyscale.
 - horizontal-flip *image-name*  *dest-image-name* -> flips image horizontally
 - vertical-flip *image-name*  *dest-image-name* -> flips image vertically
 - brighten *increment*  *image-name*  *dest-image-name* -> brightens image by specified increment(increment is positive).
 - darken *increment*  *image-name*  *dest-image-name* -> darkens image by specified increment(increment is positive).

# Image Processor in Java

For this Java assignment, we are implementing a CLI image processor. To start, we represent the general `ImageProcessorModel` type as the model interface. This interface contains methods to observe basic model implementation. The 'ImageProcessorView' interface serves as view of this program. The view presents data to the user. The 'ImageProcessorController' interface serves as the controller of our program, whch integrates both the user input into operations performed by the model, and executes events of the view.  

  
The model, view and controller are separated with classes pertaining to each in their respective packages. At the most basic level, our model is the image path of 
a loaded file, and a hashmap with key-value pairs representing a user defined filename and its corresponding image. Because of this structure, this allows users to create multiple images at once, and overwrite files if needed. 


Transformations are performed under implementations of the 'ImageProcessor' interface, whose main method takes in an image and transforms the image accordingly. Every possible transformation is represented as an implementing class of this interface. Because of the similarity between certain image transformations, most transformations extend one of 3 abstract classes(which implement 'ImageProcessor'). Under the hood, concrete classes are preset to its corresponding enumerated type from an enumeration defined in the abstract class. The abstract class then implements the main 'ImageProcessor' method, process, according to the enum type of the instantiated concrete class. This design is illustrative of the command design pattern, and the use of function objects.

This allows the complete abstraction of different transformations. The new image returned from a transformation is saved to the hashmap within the 'ImageProcessorModel', with the key-value pair being the fileName of the transformed image(provided by user) and the tranformed image created by the process method. 
The feeding of transformations to the model and intake of commands is done by the controller.


The view has the ability to render messages and the welcome message to provide CLI instructions to the user. Since an image cannot effectively be represented as a string, the text view implementation we have right now does not allow the user to meaningfully interact with the image. However, it does allow the user to see how the image is transformed based on messages outputed by the view.

  
To enable insight into the behvaiour of the MVC components, we used mocks for the appendable (`MockAppendable`, to test view behavior when transmission fails) and image processor model (`MockIPModel`). The `MockIpModel` class is used to log commands sent to the model by the controller. The `MockIPModel` is used to log the controller's use of commands associated with file management (loading, saving etc.).

Included within our project is a res folder, which contains example images that were written and saved after calling the save command-line argument. Tests on our model and controller utilize this folder to save images to. Most of our saved images are transformations of a basic ASCII PPM file. This file was written by us, and 
is a very simple 3 by 3 pixel image. 

To get started, look in the `utils` folder. There you will see a file called `SampleUserScript`, which provides examples of user provided command-line arguments and what they mean.

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

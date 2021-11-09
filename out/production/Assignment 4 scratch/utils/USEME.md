**Commands:
*LOADS ASCII PPM from image file-path and gives name to be referenced later
-in this case, image path is res/test1.ppm and image name is test -> this image
name is referenced later on in the program to apply transformations to this image and create
new images.
*USERS CAN load .bmp, .jpeg, .jpg, and .png as well.

load res/test1.ppm test

*CREATES RED GREYSCALE, PROVIDE image-name and new image-name for the image that is transformed

red-component test testRed

*SAVES RED GREYSCALE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testRed.png testRed

*CREATES GREEN GREYSCALE, PROVIDE image-name and new image-name for the image that is transformed

green-component test testGreen

*SAVES GREEN GREYSCALE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testGreen.png testGreen

*CREATES BLUE GREYSCALE, PROVIDE image-name and new image-name for the image that is transformed

blue-component test testBlue

*SAVES BLUE GREYSCALE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testBlue.jpeg testBlue

*CREATES VALUE GREYSCALE, PROVIDE image-name and new image-name for the image that is transformed

value-component test testValue

*SAVES VALUE GREYSCALE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testValue.ppm testValue

*CREATES INTENSITY GREYSCALE, PROVIDE image-name and new image-name for the
image that is transformed

intensity-component test testIntensity

*SAVES INTENSITY GREYSCALE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testIntensity.png testIntensity

*CREATES LUMA GREYSCALE, PROVIDE image-name and new image-name for the image that is transformed

luma-component test testLuma

*SAVES LUMA GREYSCALE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testLuma.jpeg testLuma

*CREATES VERTICALLY FLIPPED IMAGE, PROVIDE image-name and new image-name for the image
that is transformed

vertical-flip test testVF

*SAVES VERTICALLY FLIPPED IMAGE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testVF.png testVF

*CREATES HORIZONTALLY FLIPPED IMAGE, PROVIDE image-name and new image-name for the image
that is transformed

horizontal-flip test testHF

*SAVES HORIZONTALLY FLIPPED IMAGE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testHF.ppm testHF

*CREATES BRIGHTENED IMAGE, PROVIDE increment to be brightened by, image-name, and new image-name
for the image that is transformed

brighten 10 test testBright

*SAVES BRIGHTENED IMAGE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testBright.jpeg testBright

*CREATES DARKENED IMAGE, PROVIDE increment to be darkened by, image-name, and new image-name
for the image that is transformed

darken 100 test testDark

*SAVES DARKENED IMAGE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testDark.ppm testDark

*CREATES SHARPENED IMAGE, PROVIDE image-name and new image-name for the image
that is transformed

vertical-flip test testVF

*SAVES VERTICALLY FLIPPED IMAGE, PROVIDE image-path and image-name
*image-path must end in a valid file format and include the image-name

save res/testVF.png testVF
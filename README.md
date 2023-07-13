This project has two apps developed during learning about layouts in Android. View styling, vector drawables, data binding, constrain layout, etc have been used following best practices.

# App 1 - About Me #
This app displays my name and gives a basic introduction about me. It also takes an input nickname that you can give to me.

### App Preview ###



### More about the app ###
1. The app shows the use of LinearLayout to arrange views on the screen vertically.
2. It also uses TextView, EditText, ImageView, Button and ScrollView.
3. A style is created to apply common properties like padding, fontFamily, textColor, etc. to all TextViews.
4. Attributes like `content_description` and `hint` are added to ImageView and EditText respectively to improve accessibilty.
5. All dimensions like padding, margins, and  text_size are extracted to `dimens.xml` file.
6. All strings constants like button are extracted to `strings.xml` file.
7. The app also uses vector drawables and Vector drawable support provided by Android Support Library is enabled to supports drawables below API Level 19.
8. Data Binding has been used to bind data directly to views. 

## Views and View Groups ## 
In Android every Activity that is visible on the screen needs a layout, defined in a xml layout file. All visual elements on the screen are views and they are children of View Class. Example of views are TextView, ImageView, Buttons, EditText, LinearLayout, etc. We can also implement our own custom views. Views can also contain other views and they are called View groups, for example LinearLayou, ConstraintLayout and ScrollView. 

## dp and sp ##
**Density Independent Pixel (dp)** is the unit to express width and height of these views. It is based on physical pixel density of screen. For example :
 * On a 160 dpi screen, 1 dp == 1 pixel
 * On a 480- dpi screen, 1 dp  == 3 pixels
where dpi stands for dots per inches

**Scale Independent Pixel (sp)** is the unit to express font-size of the text. It is same as dp unit, but it not only scaled by pixel density but also by font-size preference of the user in its phone settings. This makes text to automatically scale based on phone settings. 

Android devices automatically covert dp to pixel values, hence the layout remains consistent across multiple screen resolutions.

## View Hierarchy ##
The views are inflated to created a hierarchy of view objects. Android system then traverses this hierarchy to draw views on screen. Complex and deeper view hierachies takes longer time to draw and affects performance and apps may load and respond slowly. Constraints layout provides flat hierarchy and is recommeded for complex layouts.

## Layout Editor ##
Layout editor has bunch of toolbars and screens to create and maintain layouts. However the same can also be done directly via xml code. Layout Editor has various screens mentioned below : 

1. Project View : Shows the project hierarchy and xml layouts in `\res\layouts` folder.
2. Design and Text tab : They can be used to switch between layout editor and the xml code.
3. Palette : It has commonly used UI elements and Views that can directly be added to the design.
4. Component Tree : It shows the layout hierarchy and is useful in selecting small and hidden views in complex and overlapping layout designs.
5. Attributes Pane : Shows attributes of currently selected view.
6. Design Editor : Shows preview of the screen and a blueprint version. Lines are easier to see in blueprint version.

## Creating a style ##
To use same formatting across the whole app to make it look consistent a style can be created. Instead of repeating the same properties for multiple views, all formatting of a view can be extracted into a style and then set the style to the views. We can create the style on our own of extract it from an existing view. Styles lie in `\res\values\styles.xml` file.

## Data Binding ##
When we use `findViewById` to reference views, Android has to traverse the view hierarchy to find the view at runtime. For large and deep view hierarchy this can slow down the app. Data Binding helps to connect layout to an activity or fragment at compile time. A binding class is generated by the compiler when the activity is created, the binding instance helps to access views without any extra overhead. Data binding also provides null safety and type safety. Data binding helps to bind data directly to views with the help of a data class. This reduces the effort of first updating the data and then updating the data displayed in views and separates data and presentation.

## View Binding ##
View Binding is similar to Data Binding with less features. View binding also provides type safety and null safety. However, Data binding has advanced features like ways to write short logical expressions in XML code and enhanced functionality with Jetpack libraries. Whereas, View binding is ideal for simpler use casees and provides faster compilation.

## Quick Tips ##
* Don't use hardcoded text in layout files, instead extract all string constants as a string resource in `\res\values\strings.xml` file.
* It is also recommeded to extract all dimensions like text sizes, margins and paddings into `\res\values\dimens.xml` file.
* We can also add font files in `res\font` folder to support fonts the are not part of Android Studio.
* The `content_description` attribute should be added to ImageView as it is used by screen readers to describe images.
* Use vector drawable support library to support vector drawables below API level 19. In the app module gradle file add the following:
  ```
  defaultConfig {
        vectorDrawables.useSupportLibrary = true
    }
  ```
* We can give `id` to ScrollView, this gives the Android system an identifier for the view and it helps in preserving the scroll position when the device screen is rotated.
* Use `start` and `end` for giving margins and padding instead of `left` and `right`, because `start` and `end` adpat to right to left screens, for RTL languages like Arabic.
* We can specify `inputType` for EditText, which makes Android System to automatically validate the input based on the inputType. For example, for age we can set `inputType` to `number` or for email address we can set it to `email`.

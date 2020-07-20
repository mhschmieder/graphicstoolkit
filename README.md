# GraphicsToolkit
The GraphicsToolkit library is an open source project for Java 8 that serves as a small collection of basic utilities and custom classes for stuff that is needed by a lot of AWT oriented code bases.

This library was initially composed mostly of code that supports my EpsToolkit library but which is equally relevant to PDF, SVG, and other graphics file formats that may rely on AWT's Graphics2D class as a redirection of screen painting functions (invoked from the paintComponent() loop) to paper-oriented output.

Additionally, I have pulled in a lot of legacy functions that had fallen out of use once I switched to mostly JavaFX based development, and they have been improved to be more up-to-date with Java 8 standards, but I do not have the ability at the moment to rigorously retest them. This includes AWT printer support, PostScript export, etc.

The initial release of Version 1 will require Java 8 as the JDK/JRE target, due to its use of newer language features. I will check to see if it might be made less restrictive as it may only need Java 7, but anything earlier than that introduces unpleasantires on macOS in terms of independent standalone builds.

There will be a modularized version soon, that supports Java 14+. If I find a way to make it compatible with other still-supported versions of Java (I think Java 11 is still supported by Oracle, but not Java 12 or Java 10, and maybe not Java 9 either), I will do what I can, but may have trouble finding an appropriate JDK still available to download and test against.

Maven support will hopefully be added within the next day or two.

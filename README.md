# BasicGraphics2D
The BasicGraphics2D library is an open source project for Java 8 that serves as a small collection of basic utilities and custom classes for stuff that is needed by a lot of AWT oriented code bases.

This library is primarily composed of code that supports the EpsGraphics2D library but which is equally relevant to PDF, SVG, and other graphics file formats that may rely on AWT's Graphics2D class as a redirection of screen painting functions (invoke from the paintComponent() loop) to paper-oriented output. As even many of those functions pertain to other contexts as well, this library will also include some other simple functions that help most AWT and Swing based windows (with the main emphasis on AWT Graphics vs. Swing or AWT GUI).

The initial release of Version 1 will require Java 8 as the JDK/JRE target, due to its use of newer language features. I will check to see if it might be made less restrictive as it may only require Java 7, but anything earlier than that introduces unpleasantires on macOS in terms of independent standalone builds.

There will be a modularized version soon, that supports Java 14+. If I find a way to make it compatible with other still-supported versions of Java (I think Java 11 is still supported by Oracle, but not Java 12 or Java 10, and maybe not Java 9 either), I will do what I can, but may have trouble finding an appropriate JDK still available to download and test against.

The licensing is under review. I'm not a fan of licensing restrictions for open source code and am also not a lawyer, so I am trying to avoid choosing something that precludes using this library with code that follows a different license model. As GPL2+ and GPL3+ are the most common in AWT oriented libraries for graphics export and the like, I am hoping that GPL2+ will be satisfactory for most people.

/**
 * MIT License
 *
 * Copyright (c) 2020 Mark Schmieder
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 * This file is part of the GraphicsToolkit Library
 *
 * You should have received a copy of the MIT License along with the
 * FxConverterToolkit Library. If not, see
 * <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/graphicstoolkit
 */
package com.mhschmieder.graphicstoolkit.color;

/**
 * {@code ColorConstants} is a container for constants related to color
 * handling, such as lookup indices for individual color components of HSB.
 *
 * @version 1.0
 *
 * @author Mark Schmieder
 */
public final class ColorConstants {

    /**
     * The default constructor is disabled, as this is a static constants class.
     */
    private ColorConstants() {}

    /**
     * This is the two-character hexadecimal representation of Absolute Black.
     */
    @SuppressWarnings("nls") public static final String BLACK_HEX                 = "00";

    /**
     * This is the two-character hexadecimal representation of Absolute White.
     */
    @SuppressWarnings("nls") public static final String WHITE_HEX                 = "ff";

    /**
     * The invariant spec-mandated RGB index for the red component.
     */
    public static final int                             RGB_RED_INDEX             = 0;

    /**
     * The invariant spec-mandated RGB index for the green component.
     */
    public static final int                             RGB_GREEN_INDEX           =
                                                                        RGB_RED_INDEX + 1;

    /**
     * The invariant spec-mandated RGB index for the blue component.
     */
    public static final int                             RGB_BLUE_INDEX            =
                                                                       RGB_GREEN_INDEX + 1;

    /**
     * The number of specified individual RGB components, which is invariant.
     */
    public static final int                             NUMBER_OF_RGB_COMPONENTS  = 3;

    /**
     * The invariant spec-mandated HSB index for the hue component.
     */
    public static final int                             HSB_HUE_INDEX             = 0;

    /**
     * The invariant spec-mandated HSB index for the saturation component.
     */
    public static final int                             HSB_SATURATION_INDEX      =
                                                                             HSB_HUE_INDEX + 1;

    /**
     * The invariant spec-mandated HSB index for the brightness component.
     */
    public static final int                             HSB_BRIGHTNESS_INDEX      =
                                                                             HSB_SATURATION_INDEX
                                                                                     + 1;

    /**
     * The number of specified individual HSB components, which is invariant.
     */
    public static final int                             NUMBER_OF_HSB_COMPONENTS  = 3;

    /**
     * The invariant spec-mandated CMYK index for the cyan component.
     */
    public static final int                             CMYK_CYAN_INDEX           = 0;

    /**
     * The invariant spec-mandated CMYK index for the magenta component.
     */
    public static final int                             CMYK_MAGENTA_INDEX        =
                                                                           CMYK_CYAN_INDEX + 1;

    /**
     * The invariant spec-mandated CMYK index for the yellow component.
     */
    public static final int                             CMYK_YELLOW_INDEX         =
                                                                          CMYK_MAGENTA_INDEX + 1;

    /**
     * The invariant spec-mandated CMYK index for the black component.
     */
    public static final int                             CMYK_BLACK_INDEX          =
                                                                         CMYK_YELLOW_INDEX + 1;

    /**
     * The number of specified individual CMYK components, which is invariant.
     */
    public static final int                             NUMBER_OF_CMYK_COMPONENTS = 4;

}
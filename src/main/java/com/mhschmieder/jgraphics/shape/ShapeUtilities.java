/**
 * MIT License
 *
 * Copyright (c) 2020, 2025 Mark Schmieder
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
 * GraphicsToolkit Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/graphicstoolkit
 */
package com.mhschmieder.jgraphics.shape;

import java.awt.Graphics;
import java.awt.geom.GeneralPath;

/**
 * {@code ShapeUtilities} is a utility class for Graphics2D based methods
 * that are often needed when batching large numbers of graphics primitives,
 * when it may be more efficient to append to a single {@link GeneralPath}
 * repetitively than to make large numbers of individual graphics primitives.
 *
 * @version 1.0
 *
 * @author Mark Schmieder
 */
public final class ShapeUtilities {

    /**
     * The default constructor is disabled, as this is a static utilities class.
     */
    private ShapeUtilities() {}

    /**
     * Draws an Arrow on the given graphics canvas.
     * <p>
     * NOTE: To clarify, the provided percent is presumed to have already been
     *  converted from the { 0, 100 } range to a decimal number between zero and
     *  one that is ready as a multiplier.
     *
     * @param g the Graphics context to use as the canvas
     * @param startX the point-end of the arrow, x-coordinate
     * @param startY the point-end of the arrow, y-coordinate
     * @param endX the head end of the arrow, x-coordinate
     * @param endY the head end of the arrow, y-coordinate
     * @param headDecimalPercent the decimal percent by which to multiply the
     *                           arrow length, to determine the head length
     */
    public static void drawArrow( final Graphics g,
                                  final int startX,
                                  final int startY,
                                  final int endX,
                                  final int endY,
                                  final double headDecimalPercent ) {
        final double xDiff = endX - startX;
        final double yDiff = endY - startY;

        final int xArrowButt = endX - ( int ) ( xDiff * headDecimalPercent );
        final int yArrowButt = endY - ( int ) ( yDiff * headDecimalPercent );

        final int[] arrowHeadX = new int[ 3 ];
        final int[] arrowHeadY = new int[ 3 ];

        arrowHeadX[ 0 ] = endX;
        arrowHeadY[ 0 ] = endY;

        arrowHeadX[ 1 ] = xArrowButt - ( int ) ( ( yDiff / 2 ) * headDecimalPercent );
        arrowHeadY[ 1 ] = yArrowButt + ( int ) ( ( xDiff / 2 ) * headDecimalPercent );

        arrowHeadX[ 2 ] = xArrowButt + ( int ) ( ( yDiff / 2 ) * headDecimalPercent );
        arrowHeadY[ 2 ] = yArrowButt - ( int ) ( ( xDiff / 2 ) * headDecimalPercent );

        g.fillPolygon( arrowHeadX, arrowHeadY, 3 );

        g.drawLine( startX, startY, endX, endY );
    }

    /**
     * Returns an integer-based polyline represented as a {@link GeneralPath},
     * compensating for this being a missing geometric primitive in AWT. Returns
     * {@code null} if the input arguments are not consistent, as AWT does not
     * provide a mechanism for determining an empty Path.
     * <p>
     * This method provides a {@link GeneralPath} implementation of polylines
     * using integers, for efficient rendering of large collections of
     * contiguous line segments.
     * <p>
     * The xPoints and yPoints arrays must be the same effective size, as
     * indicated by the supplied number of points. It is OK for either array to
     * be larger, but neither can be smaller than this size.
     *
     * @param xPoints
     *            An integer array of x coordinates for the polyline
     * @param yPoints
     *            An integer array of x coordinates for the polyline
     * @param numberOfPoints
     *            The number of integer-based points to make for this polyline
     * @return A {@link GeneralPath} that represents an integer-based polyline,
     *         or {@code null} to indicate that no valid polyline could be
     *         created due to inconsistent input arguments
     *
     * @since 1.0
     */
    public static GeneralPath makePolyline( final int[] xPoints,
                                            final int[] yPoints,
                                            final int numberOfPoints ) {
        // If no points are requested, or either coordinate array is smaller
        // than the expected number of points, return the empty path.
        if ( ( numberOfPoints <= 0 ) || ( xPoints.length < numberOfPoints )
                || ( yPoints.length < numberOfPoints ) ) {
            return null;
        }

        final GeneralPath path = new GeneralPath();
        path.moveTo( xPoints[ 0 ], yPoints[ 0 ] );

        for ( int i = 1; i < numberOfPoints; i++ ) {
            path.lineTo( xPoints[ i ], yPoints[ i ] );
        }

        return path;
    }

    /**
     * Returns a single-precision polyline represented as a {@link GeneralPath},
     * compensating for this being a missing geometric primitive in AWT. Returns
     * {@code null} if the input arguments are not consistent, as AWT does not
     * provide a mechanism for determining an empty Path.
     * <p>
     * This method provides a {@link GeneralPath} implementation of polylines
     * using single-precision floating-point, for efficient rendering of large
     * collections of contiguous line segments.
     * <p>
     * The xPoints and yPoints arrays must be the same effective size, as
     * indicated by the supplied number of points. It is OK for either array to
     * be larger, but neither can be smaller than this size.
     *
     * @param xPoints
     *            A single-precision array of x coordinates for the polyline
     * @param yPoints
     *            A single-precision array of x coordinates for the polyline
     * @param numberOfPoints
     *            The number of single-precision points to make for this
     *            polyline
     * @return A {@link GeneralPath} that represents a single-precision
     *         polyline, or {@code null} to indicate that no valid polyline
     *         could be created due to inconsistent input arguments
     *
     * @since 1.0
     */
    public static GeneralPath makePolyline( final float[] xPoints,
                                            final float[] yPoints,
                                            final int numberOfPoints ) {
        // If no points are requested, or either coordinate array is smaller
        // than the expected number of points, return the empty path.
        if ( ( numberOfPoints <= 0 ) || ( xPoints.length < numberOfPoints )
                || ( yPoints.length < numberOfPoints ) ) {
            return null;
        }

        final GeneralPath path = new GeneralPath();
        path.moveTo( xPoints[ 0 ], yPoints[ 0 ] );

        for ( int i = 1; i < numberOfPoints; i++ ) {
            path.lineTo( xPoints[ i ], yPoints[ i ] );
        }

        return path;
    }

    /**
     * Returns a double-precision polyline represented as a {@link GeneralPath},
     * compensating for this being a missing geometric primitive in AWT. Returns
     * {@code null} if the input arguments are not consistent, as AWT does not
     * provide a mechanism for determining an empty Path.
     * <p>
     * This method provides a {@link GeneralPath} implementation of polylines
     * using double-precision floating-point, for efficient rendering of large
     * collections of contiguous line segments.
     * <p>
     * The xPoints and yPoints arrays must be the same effective size, as
     * indicated by the supplied number of points. It is OK for either array to
     * be larger, but neither can be smaller than this size.
     *
     * @param xPoints
     *            A double-precision array of x coordinates for the polyline
     * @param yPoints
     *            A double-precision array of x coordinates for the polyline
     * @param numberOfPoints
     *            The number of double-precision points to make for this
     *            polyline
     * @return A {@link GeneralPath} that represents a double-precision
     *         polyline, or {@code null} to indicate that no valid polyline
     *         could be created due to inconsistent input arguments
     *
     * @since 1.0
     */
    public static GeneralPath makePolyline( final double[] xPoints,
                                            final double[] yPoints,
                                            final int numberOfPoints ) {
        // If no points are requested, or either coordinate array is smaller
        // than the expected number of points, return the empty path.
        if ( ( numberOfPoints <= 0 ) || ( xPoints.length < numberOfPoints )
                || ( yPoints.length < numberOfPoints ) ) {
            return null;
        }

        final GeneralPath path = new GeneralPath();
        path.moveTo( xPoints[ 0 ], yPoints[ 0 ] );

        for ( int i = 1; i < numberOfPoints; i++ ) {
            path.lineTo( xPoints[ i ], yPoints[ i ] );
        }

        return path;
    }

}

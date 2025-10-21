/**
 * MIT License
 *
 * Copyright (c) 2020, 2022 Mark Schmieder
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
 * This file is part of the JCommons Library
 *
 * You should have received a copy of the MIT License along with the
 * JCommons Library. If not, see <https://opensource.org/licenses/MIT>.
 *
 * Project: https://github.com/mhschmieder/jcommons
 */
package com.mhschmieder.graphicstoolkit.undo;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class UndoableActionUtilities {

    /**
     * The default constructor is disabled, as this is a static utilities class.
     */
    private UndoableActionUtilities() {}

    @SuppressWarnings("nls")
    public static String getUndoableActionPresentationName( final String undoableActionName,
                                                            final ResourceBundle resourceBundle ) {
        // Each undoable action must have an action name in order to find its
        // locale-specific presentation name.
        if ( ( undoableActionName == null ) || undoableActionName.trim().isEmpty() ) {
            return null;
        }

        // Generate the resource lookup key for the undoable action presentation
        // name.
        final String resourceKey = "undoableAction." + undoableActionName + ".presentationName";

        try {
            final String undoableActionPresentationName = resourceBundle.getString( resourceKey );
            return undoableActionPresentationName;
        }
        catch ( final MissingResourceException | ClassCastException | NullPointerException e ) {
            e.printStackTrace();
            return null;
        }
    }

}

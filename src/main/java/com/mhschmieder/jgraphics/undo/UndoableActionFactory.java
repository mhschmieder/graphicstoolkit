/*
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
package com.mhschmieder.jgraphics.undo;

import com.mhschmieder.jcommons.util.ClientProperties;
import com.mhschmieder.jcommons.util.GlobalUtilities;

import javax.swing.undo.StateEdit;
import javax.swing.undo.StateEditable;
import java.util.ResourceBundle;

public final class UndoableActionFactory {

    /**
     * The default constructor is disabled, as this is a static utilities class.
     */
    private UndoableActionFactory() {}

    // NOTE: We must substitute "." for resource directory tree delimiters.
    public static final String BUNDLE_NAME = "properties.UndoableActions";

    public static StateEdit getUndoableActionInstance( final StateEditable editableObject,
                                                       final String undoableActionName,
                                                       final ClientProperties pClientProperties ) {
        final ResourceBundle resourceBundle = GlobalUtilities
                .getResourceBundle( pClientProperties, BUNDLE_NAME, false );

        final String presentationName = UndoableActionUtilities
                .getUndoableActionPresentationName( undoableActionName, resourceBundle );
        return new StateEdit( editableObject, presentationName );
    }

}

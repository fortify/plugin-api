/*
 * Copyright 2017-2023 Open Text
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.fortify.plugin.api;

/**
 * The {@link com.fortify.plugin.spi.ParserPlugin} implementation is expected to raise {@link ScanParsingException}
 * if an error occurs during scan parsing. Execution is assumed to halt when this exception is raised.
 * Pure I/O related errors should not be wrapper by this exception, but should be raised as is.
 */
public class ScanParsingException extends Exception {

    /**
     * Construct ScanParsingException object.
     * @param message the detail message that can be retrieved later by the {@link #getMessage()} method.
     */
    public ScanParsingException(final String message) {
        super(message);
    }

    /**
     * Construct ScanParsingException object.
     * @param message the detail message that can be retrieved later by the {@link #getMessage()} method.
     * @param cause Throwable that caused this exception.
     */
    public ScanParsingException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

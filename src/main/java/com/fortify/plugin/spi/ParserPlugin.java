/*
 * (c) Copyright 2017 Micro Focus or one of its affiliates.
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
package com.fortify.plugin.spi;

import com.fortify.plugin.api.ScanBuilder;
import com.fortify.plugin.api.ScanData;
import com.fortify.plugin.api.ScanParsingException;
import com.fortify.plugin.api.VulnerabilityHandler;

import java.io.IOException;

/**
 * {@link Plugin} contract extension to identify parser plugin types
 */

public interface ParserPlugin<T extends Enum & VulnerabilityAttribute> extends Plugin {

    /**
     * Used to retrieve attribute mapping to client data model
     * <p>
     * Implementation should return an Enum implementation of {@link com.fortify.plugin.spi.VulnerabilityAttribute}
     * </p>
     * <p>
     * <b>Note:</b> This method may be called before {@link Plugin#start()} method.
     * </p>
     *
     * @return an vulnerability attributes class
     */
    Class<T> getVulnerabilityAttributesClass();

    /**
     * Used to retrieve scan metadata by plugin client
     * <p>
     * Implementation should use {@link com.fortify.plugin.api.ScanData} to retrieve scan data and
     * {@link com.fortify.plugin.api.ScanBuilder} to build scan metadata required by plugin client
     * </p>
     *
     * @param scanData holds reference to scan input stream
     * @param scanBuilder to build scan metadata
     * @throws ScanParsingException when scan has wrong format
     * @throws IOException when general i/o error occurs during parsing
     */
    void parseScan(ScanData scanData, ScanBuilder scanBuilder) throws ScanParsingException, IOException;

    /**
     * Used to retrieve set of scan vulnerabilities
     * <p>
     * Implementation should use {@link com.fortify.plugin.api.ScanData} to retrieve scan data and
     * {@link com.fortify.plugin.api.VulnerabilityHandler} to build individual vulnerabilities for client
     * </p>
     *
     * @param scanData holds reference to scan input stream
     * @param vulnerabilityHandler to build and send individual vulnerabilities to client
     * @throws ScanParsingException when scan has wrong format
     * @throws IOException when general i/o error occurs during parsing
     */
    void parseVulnerabilities(ScanData scanData, VulnerabilityHandler vulnerabilityHandler) throws ScanParsingException, IOException;
}

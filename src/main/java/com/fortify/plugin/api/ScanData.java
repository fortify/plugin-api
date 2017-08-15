/*
 * (c) Copyright [2017] EntIT Software LLC
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

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.function.Predicate;

/**
 * Interface for access to scan stream and parsing session
 */
public interface ScanData {

    /**
     * Returns a unique ID associated with this scan for the purpose of parsing. This ID is kept over calls
     * to both {@link com.fortify.plugin.spi.ParserPlugin#parseScan(ScanData, ScanBuilder)}
     * and {@link com.fortify.plugin.spi.ParserPlugin#parseVulnerabilities(ScanData, VulnerabilityHandler)}.
     *
     * @return a string representing the session ID
     */
    String getSessionId();

    /**
     * Get list of all entries (files), included in the scan result, except for scan format specific
     * metadata files, e.g. scan.info.
     * @return list of all entries (files), included in the scan result.
     */
    List<ScanEntry> getScanEntries();

    /**
     * Returns input stream based on scan entry (@link com.fortify.plugin.api.ScanEntry}
     * @param scanEntry for which to retrieve input stream
     * @return input stream of scan entry
     * @throws IOException when failed to open the stream
     */
    InputStream getInputStream(ScanEntry scanEntry) throws IOException;

    /**
     * Returns input stream based on string matcher {@link java.util.function.Predicate}
     * @param matcher to identify entry
     * @return input stream of scan entry identified by matcher
     * @throws IOException when failed to open the stream
     */
    InputStream getInputStream(Predicate<String> matcher) throws IOException;

}

/*
 * Copyright 2017-2023 Open Text
 */
/*
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

import java.util.Date;

/**
 * Interface that allows parser plugins to build scan metadata.
 * Almost all methods are optional here except {@link #completeScan()} that must be called when all used
 * attributes are set.
 *
 * This builder does not really follow the GOF builder pattern. Build result is not returned to the client,
 * but passed to the builder implementation to handle the build result (Scan instance).
 */
public interface ScanBuilder {

    /**
     * Set GUID of the scan that is being built.
     * This GUID is a natural unique identifier of the current scan along all the scans that are parsed by the plugin.
     * @param guid GUID value. Value is mandatory. Max length is 255 characters.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setGuid(String guid);

    /**
     * Set date of the creation of the scan that is being parsed. It is <b>not</b> the scan parse date, it is the date
     * when scan file was created by the vulnerability analyser produced this scan file.
     * Scan date is quite important attribute of the scan that is used by SSC for checking is this specific scan has
     * already been processed in the past and for calculation the status (new, fixed, reintroduced, updated) of
     * vulnerabilities in the application version where this scan is going to be uploaded.
     * @param scanDate date when scan. Value is mandatory and cannot be null.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setScanDate(Date scanDate);

    /**
     * Set scan label.
     * If scan was created during a build session (on Jenkins / TeamCity / VSTS / etc) some build identifier should be
     * placed here. Value is optional.
     * @param buildId build ID associated with the parsed scan. Value is optional. Max length is 255.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setBuildId(String buildId);

    /**
     * Set label of the scan.
     * @param scanLabel Typically this is a version control identifier to indicate which exact revision is being scanned.
     * Value is optional. Max length is 2000.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setScanLabel(String scanLabel);

    /**
     * Set the host name of the machine that ran the scan.
     * @param hostName host name of the machine that ran the scan. Value is optional. Max length is 255.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setHostName(String hostName);

    /**
     * Set time (number of seconds) that was needed to complete the scan.
     * @param elapsedTime How long the scan took, in seconds. Value is optional.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setElapsedTime(Integer elapsedTime);

    /**
     * Set number of files that have been scanned during the scan.
     * @param numFiles number of files that have been scanned during the scan.
     * it can be treated in more general way. If it is dynamic scan that was performed against some web application,
     * it can be number of URLs that have been tested by analyser.
     * Value is optional.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setNumFiles(Integer numFiles);

    /**
     * Set number of executable lines of code that have been scanned during the scan.
     * Value is valid for static analysers that scan actual source files.
     * @param executableLOC number of executable lines of code that have been scanned during the scan.
     * Value is optional.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setExecutableLOC(Integer executableLOC);

    /**
     * Set full number of lines of code in the files that have been scanned by analyser.
     * Value is valid for static analysers that scan actual source files.
     * @param totalLOC full number of lines of code in the files that have been scanned by analyser.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setTotalLOC(Integer totalLOC);

    /**
     * Set version of the scanner (or engine) that generated scan file.
     * @param engineVersion version of the scanner (or engine) that generated scan file.
     * Value is optional. Max length is 80.
     * @return reference to this ScanBuilder instance.
     */
    ScanBuilder setEngineVersion(String engineVersion);

    /**
     * Set the ScanEntry of the SBOM file in the scan file.
     * @param scanEntry scanEntry of the SBOM file.
     * @param sbomType format and serialization of the SBOM file.
     * @return reference to this ScanBuilder instance.
     * @since 1.2.2320.0 (SSC 23.2.0)
     */
    ScanBuilder setSBOMEntry(ScanEntry scanEntry, SbomType sbomType);

    /**
     * Complete scan build process and notify plugin framework that scan is ready to be passed to SSC.
     */
    void completeScan();
}

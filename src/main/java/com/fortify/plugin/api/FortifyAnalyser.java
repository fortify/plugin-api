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

/**
 * List of all analysers supported by fortify products.
 */
public enum FortifyAnalyser {

    /**
     * Analyzer detects buffer overflow vulnerabilities that caused by reading or writing more data than a buffer can hold.
     */
    BUFFER("Buffer"),

    /**
     * Analyzer detects mistakes, defects, and policy violations in an application's deployment configuration files
     */
    CONFIGURATION("Configuration"),

    /**
     * Analyser detects vulnerabilities caused by not validated content passed to application.
     * Examples:
     * - misusing hidden fields of web-forms that can hold sensitive data that can be replaced by attacker in runtime;
     * - using session cookies and acting on an HTTP request without verifying that the request was made with the
     *   user's consent.
     *
     */
    CONTENT("Content"),

    /**
     * Analyzer detects potentially dangerous sequences of operations. By analyzing control flow paths in a program,
     * the control flow analyzer determines whether a set of operations are executed in a certain order. For example,
     * the control flow analyzer detects time of check/time of use issues and uninitialized variables, and checks whether
     * utilities, such as XML readers, are configured properly before being used.
     */
    CONTROL_FLOW("Control Flow"),

    /**
     * Analyzer detects potential vulnerabilities that involve tainted data (user-controlled input) put to potentially
     * dangerous use. The data flow analyzer uses global, inter-procedural taint propagation analysis to detect the flow
     * of data between a source (site of user input) and a sink (dangerous function call or operation). For example,
     * the data flow analyzer detects whether a user-controlled input string of unbounded length is being copied into
     * a statically sized buffer, and detects whether a user controlled string is being used to construct SQL query text.
     */
    DATA_FLOW("Data Flow"),

    /**
     * Open source static code analyser created by Bill Pugh and David Hovemeyer which detects possible bugs in
     * Java programs.
     */
    FINDBUGS("Findbugs"),

    /**
     * Analyzer detects vulnerabilities that can be exposed / exploited through open interfaces or APIs of application.
     * This type of analysis is usually performed against web-application.
     */
    PENTEST("Pentest"),

    /**
     * Analyzer detects vulnerabilities in runtime by executing protected application in a sendbox and analysing all the
     * application's input and output.
     */
    RUNTIME("Runtime"),

    /**
     * Analyzer detects potentially dangerous usages of functions and APIs at the intraprocedural level.
     */
    SEMANTIC("Semantic"),

    /**
     * Analyzer detects vulnerabilities by matching specifyc program constructs in source code.	It is not designed
     * to find problems arising from flow of execution or data. Rather, it specializes in detecting vulnerabilities
     * which can be detected by identifying certain patterns of code.
     * Example: this kind of analyzer detects assignments to member variables in Java classes whose instances are used
     * by multiply threads, identifies the use of loggers that are not declared static final, and flags instances of
     * dead code that will never be executed because of a predicate that is always false.
     */
    STRUCTURAL("Structural");

    private String analyserName;

    FortifyAnalyser(String analyserName) {
        this.analyserName = analyserName;
    }

    public String getAnalyserName() {
        return analyserName;
    }
}

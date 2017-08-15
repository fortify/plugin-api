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
 * List of all supported Kingdoms (or high level categories) of the vulnerabilities.
 */
public enum FortifyKingdom {

    /**
     * An API is a contract between a caller and a callee. The most common forms of API abuse are caused by the caller
     * failing to honor its end of this contract. For example, if a program fails to call chdir() after calling chroot(),
     * it violates the contract that specifies how to change the active root directory in a secure fashion. Another
     * good example of library abuse is expecting the callee to return trustworthy DNS information to the caller.
     * In this case, the caller abuses the callee API by making certain assumptions about its behavior
     * (that the return value can be used for authentication purposes). One can also violate the caller-callee contract
     * from the other side. For example, if a coder subclasses SecureRandom and returns a non-random value,
     * the contract is violated.
     */
    API_ABUSE("API Abuse"),

    /**
     * Poor code quality leads to unpredictable behavior. From a user's perspective that often manifests itself as poor
     * usability. For an attacker it provides an opportunity to stress the system in unexpected ways.
     */
    CODE_QUALITY("Code Quality"),

    /**
     * Encapsulation is about drawing strong boundaries. In a web browser that might mean ensuring that your mobile code
     * cannot be abused by other mobile code. On the server it might mean differentiation between validated data and
     * unvalidated data, between one user's data and another's, or between data users are allowed to see and data that
     * they are not.
     */
    ENCAPSULATION("Encapsulation"),

    /**
     * This section includes everything that is outside of the source code but is still critical to the security of the
     * product that is being created. Because the issues covered by this kingdom are not directly related to source code,
     * we separated it from the rest of the kingdoms.
     */
    ENVIRONMENT("Environment"),

    /**
     * Errors and error handling represent a class of API. Errors related to error handling are so common that they
     * deserve a special kingdom of their own. As with "API Abuse," there are two ways to introduce an error-related
     * security vulnerability: the most common one is handling errors poorly (or not at all). The second is producing
     * errors that either give out too much information (to possible attackers) or are difficult to handle.
     */
    ERRORS("Errors"),

    /**
     * Input validation and representation problems ares caused by metacharacters, alternate encodings and numeric
     * representations. Security problems result from trusting input. The issues include: "Buffer Overflows,"
     * "Cross-Site Scripting" attacks, "SQL Injection," and many others.
     */
    INPUT_VALIDATION_AND_REPRESENTATION("Input Validation and Representation"),

    /**
     * This kingdom covers topics like authentication, access control, confidentiality, cryptography, and privilege management.
     */
    SECURITY_FEATURES("Security Features"),

    /**
     * Distributed computation is about time and state. That is, in order for more than one component to communicate,
     * state must be shared, and all that takes time.
     */
    TIME_AND_STATE("Time and State");

    private String kingdomName;

    FortifyKingdom(String kingdomName) {
        this.kingdomName = kingdomName;
    }

    public String getKingdomName() {
        return kingdomName;
    }
}

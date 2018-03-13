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

/**
 * The root of Fortify's plugin implementation contract.
 * Must be implemented as a service provider, and the corresponding service descriptor included in the
 * library's {@code META-INF/services} location. See {@link java.util.ServiceLoader}.
 * <p>
 * This interface is not to be directly implemented by plugins. Implement some other interfaces extending from this one.
 * @see ParserPlugin
 */
public interface Plugin {

    /**
     * Perform any global state state initialization needed by plugin.
     * Once this method returns, plugin should be ready to process requests.
     * Implementing this method is optional.
     */
    default void start() throws Exception {}

    /**
     * Signal plugin to halt any undergoing work and free resources held by the plugin.
     * Implementing this method is optional.
     */
    default void stop() throws Exception {}
}

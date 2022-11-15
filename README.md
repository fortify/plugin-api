# Fortify Software Security Center Plugin API

## Version 1.1.2220
- Add optional ParserType element to IssueParser
- Bump schema and plugin-api version to 1.1
- The plugin-api version 1.1 is only supported since SSC version 22.2.0

## Version 1.0.1.1
- Publish to Maven Central
- Document additional resources

## Version 1.0.1
- support for parser plugins
- custom parser implementations can implement `com.fortify.plugin.spi.ParserPlugin`
- plugin implementations need to bundle valid plugin.xml descriptor based on  `src/main/resources/schema/pluginmanifest-1.0.xsd`
- plugin implementation JAR has to contain all plugin dependencies - be self-contained

* If a plugin has any dependencies on javaEE packages, the plugin developer must bundle the necessary javaEE jars into the plugin's own library path, and must not rely on these packages being available from the JRE.  The JavaEE modules have been removed from current versions of Java post-Java8 and will not be available in SSC versions after 18.20. 
 
  * Such packages include JAXB api and implementation, javax.activation, javax.annotation, javax.transaction, javax.xml.ws, and CORBA-related packages."
  * In particular, the “Bundle-ClassPath” of their plugin bundle manifest should include the dependency javaEE jars and the jars themselves must be stored inside the bundle (typically in a “libs” folder along with any other libraries their plugin depends on). 

## Resources

* The main [parser example project](https://github.com/fortify/sample-parser "Sample Parser") provides detailed instructions for developing parser plugins
* Following links point to some parser implementations that could serve as further examples:
    * https://github.com/sonatype-nexus-community/iq-fortify-parser
	* https://github.com/topics/fortify-parser-plugin
* The [fortify-ssc-parser-util](https://github.com/fortify-ps/fortify-ssc-parser-util) project may be useful for developing parser plugins that need to parse JSON or XML data, however please note that this project is not officially endorsed or supported in any way

## Information for Developers

* `./gradlew build`: Build the plugin
* `./gradlew publishToMavenLocal`: Publish the plugin to local Maven repository
    * Add `mavenLocal()` repository to a parser plugin to use a locally built version for testing
* `./gradlew publishToOSSRH closeOSSRHStagingRepository`: Publish the plugin to OSSRH/Maven Central
    * [.github/workflows/ci.yml](.github/workflows/ci.yml) automatically runs this on every push to the master branch
    * Can be run manually to test the publishing process from other branches
    * Requires the following Gradle properties to be set (use `ORG_GRADLE_PROJECT_` prefix to set these properties through environment variables):
        * `signingKey`: Used to sign the artifacts
        * `signingPassword`: Used to sign the artifacts
        * `OSSRHUsername`: Used to publish to OSSRH
        * `OSSRHPassword`: Used to publish to OSSRH
    * If project.version ends with `-SNAPSHOT`, the artifacts will end up at https://s01.oss.sonatype.org/content/repositories/snapshots/
    * Release versions are published to an OSSRH staging repository and checked for Maven Central requirements
        * Log in to https://s01.oss.sonatype.org/ with the same account used during publishing to verify the artifacts and release them to Maven Central

## Open Source Issues in Fortify Software Security Center

* For SSC to consider issues as "Open Source" issues, the parser plugin must add the element "&lt;parser-type&gt;DEPENDENCY_SCAN&lt;/parser-type&gt;" to the &lt;issue-parser&gt; element in the plugin's plugin.xml file.

* The parser plugin must also include these custom attributes for the vulnerabilities:
	- externalId: An ID, such as a CVE ID, for the issue
	- cwes: Comma-separated list of CWE IDs (numbers only)
	- externalUrl: External URL for the vulnerability
	- componentPurl: Package URL for the vulnerable component in the form "pkg:type/namespace/name@version"
	- componentNamespace: Namespace of the vulnerable component.  This should match the namespace in the package URL
	- componentName: Name of the vulnerable component.  This should match the name in the packge URL
	- componentVersion: Version of the vulnerable component.  This should match the name in the package URL
	- componentPackageType: Package type of the vulnerable component.  This should match the type in the package URL
	- componentLicenses: Type of licenses for the vulnerable component
	- invoked:  true/false/&lt;null&gt;(unknown) value for whether or not the analyzed code calls this specific issue
	- controllable: true/false/&lt;null&gt;(unknown) value for whether or not the analyzed code calls this specific issue with user-controlled data
	- evidence: Any supporting evidence that the analyzed code is susceptible to this specific issue

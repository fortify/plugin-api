# Fortify Software Security Center Plugin API

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


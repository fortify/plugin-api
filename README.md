# Fortify Software Security Center Plugin API
## Version 1.0.1
- support for parser plugins
- custom parser implementations can implement `com.fortify.plugin.spi.ParserPlugin`
- plugin implementations need to bundle valid plugin.xml descriptor based on  `src/main/resources/schema/pluginmanifest-1.0.xsd`
- plugin implementation JAR has to contain all plugin dependencies - be self-contained

Please see [parser example project](https://github.com/fortify/sample-parser "Sample Parser")


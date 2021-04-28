# m2e-axistools

This m2e connector for the [Axis Tools Maven Plugin](http://mojo.codehaus.org/axistools-maven-plugin/)
will execute axistools-maven-plugin:wsdl2java on Eclipse incremental builds,
if a change is detected on a WSDL file under axistools-maven-plugin's
sourceDirectory (${basedir}/src/main/wsdl by default).

In order for this connector to be enabled, projects in Eclipse must be
Maven-enabled with m2e (right-click on project > Configure > Convert to Maven...)


## Installation

To install this m2e connector, use the following P2 update site:

https://theit.github.io/m2e-lifecycle-axistools


## License

See [LICENSE](https://github.com/theit/m2e-lifecycle-axistools/blob/master/LICENSE-2.0.txt).

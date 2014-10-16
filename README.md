m2e-axistools
=============

This m2e connector for the [Axis Tools Maven Plugin](http://mojo.codehaus.org/axistools-maven-plugin/)
will execute axistools-maven-plugin:wsdl2java on Eclipse incremental builds,
if a change is detected on a WSDL file under axistools-maven-plugin's
sourceDirectory (${basedir}/src/main/wsdl by default).

In order for this connector to be enabled, projects in Eclipse must be
Maven-enabled with m2e (right-click on project > Configure > Convert to Maven...)

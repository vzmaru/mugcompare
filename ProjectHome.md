# Introduction #
Mug Compare is a java application for database comparing. The application uses native JDBC connection to explore and compare databases.

![http://mugcompare.googlecode.com/svn/wiki/img/mugcompare.png](http://mugcompare.googlecode.com/svn/wiki/img/mugcompare.png)

# Features #

The main planned features are:
  * Simple configuration (see DatabaseXmlDocs and DriverXmlDocs)
  * JDBC integration (See JdbcStrings examples)
  * ANT integration (soon))
  * Export results in TXT or XML (soon)

You can see a full list (and status) in FeaturesPlanning page.

# Using #
## Command line ##
```
Usage: java -jar mugcompare.jar

   Parameters
    --driverConfigFile=mydriverconfigfile.xml
    --databaseCompareFile=mydatabasefile.xml
    --outputFile=myoutputfile.txt
    --outputFileType=txt (or xml)
```

# Credits #
This tool is being created by [Leandro Nunes](http://www.leandronunes.org)
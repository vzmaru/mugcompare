# Introduction #

This page describes database.xml file. This file is used to configure databases that will be compared and output settings.


# Details #

```
    <mugcompare>

        <database_source>
            <driver></driver> <!-- references driver_config.xml -->
            <connection_str></connection_str> <!-- JDBC standard -->
            <username>idontknow</username>
            <password>idontknow</password>
        </database_source>

        <database_target>
            <driver></driver> <!-- references driver_config.xml -->
            <connection_str></connection_str> <!-- JDBC standard -->
            <username>idontknow</username>
            <password>idontknow</password>
        </database_target>

        (not being used yet)
        <output_settings>
            <format></format> <!-- [optional] txt* or xml -->
        </output_settings>

    </mugcompare>
```
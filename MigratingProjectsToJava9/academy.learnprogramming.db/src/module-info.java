module academy.learnprogramming.db
{
    // Automatic modules are modules that are created when the jar is added to the module path.
    // The name of automatic modules is the name of the jar file without the version, such as below.
    requires java.sql;
    requires sqlite.jdbc;

    // Using "transitive" here, so we don't have to require the common module in other modules, since it's only the
    // db module that uses it directly. So now the ui module can have access to all the exported packages by the common
    // module because of this keyword.
    requires transitive academy.learnprogramming.common;

    // We must export packages to be able to use them outside its module's project.
    exports academy.learnprogramming.db;
}
module academy.learnprogramming.db
{
    // Automatic modules are modules that are created when the jar is added to the module path.
    // The name of automatic modules is the name of the jar file without the version, such as below.
    requires java.sql;
    requires sqlite.jdbc;
    requires academy.learnprogramming.common;

    // We must export packages to be able to use them outside its module's project.
    exports academy.learnprogramming.db;
}
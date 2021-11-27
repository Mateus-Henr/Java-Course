module academy.learnprogramming.ui
{
    // The "requires" statement is used to tell Java what are the requirements of your project, in other words what
    // "projects" will be necessary to run the project.
    // A circular dependency is a relation between two or more modules which either directly or indirectly depend
    // on each other to function properly.

    // We can optimize our requirements by looking module by module and se if any of them are using the "transitive"
    // keyword to require any module that we are currently requiring and if that's happening we can delete the
    // module that is being "transitive" required.
//    requires javafx.base; // Being used by a transitive statement somewhere else.
//    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    // Using transitive dependency for this module.
//    requires academy.learnprogramming.common;
    requires academy.learnprogramming.db;

    // Using the "to" we export to a specific module.
    exports academy.learnprogramming.ui to javafx.graphics;
    opens academy.learnprogramming.ui to javafx.fxml;
}
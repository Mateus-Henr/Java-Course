module academy.learnprogramming.ui
{
    // The "requires" statement is used to tell Java what are the requirements of your project, in other words what
    // "projects" will be necessary to run the project.
    // A circular dependency is a relation between two or more modules which either directly or indirectly depend
    // on each other to function properly.
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires academy.learnprogramming.common;
    requires academy.learnprogramming.db;

    // Using the "to" we export to a specific module.
    exports academy.learnprogramming.ui to javafx.graphics;
    opens academy.learnprogramming.ui to javafx.fxml;
}
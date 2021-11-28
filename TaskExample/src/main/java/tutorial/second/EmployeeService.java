package tutorial.second;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

// The Server class is used to help developers to use background threads correctly in a UI application.
// We can start and cancel a service and differently from a thread we can restart a service.
// Instead of creating our task in the "initialize()" method we will be creating it in the "Server.createTask()" method.
// When we start the service, the JVM will call the "createTask()" method.
public class EmployeeService extends Service<ObservableList<String>>
{
    @Override
    protected Task<ObservableList<String>> createTask()
    {
        return new Task<ObservableList<String>>()
        {
            @Override
            protected ObservableList<String> call() throws Exception
            {
                String[] names = {
                        "Tim Buchalka",
                        "Bill Rogers",
                        "Jack Jill",
                        "Joan Andrews",
                        "Mary Johnson",
                        "Bob McDonald"};

                ObservableList<String> employees = FXCollections.observableArrayList();

                for (int i = 0; i < 6; i++)
                {
                    employees.add(names[i]);
                    updateMessage("Added " + names[i] + " to the list");
                    updateProgress(i + 1, 6);
                    Thread.sleep(200);
                }

                return employees;
            }
        };
    }

}

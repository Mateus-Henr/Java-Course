package tutorial.second;

import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;

// THE RECOMMENDED WAY FOR WORKING WITH TASKS IN JAVAFX IS BY CREATING A SERVICE AND LETTING IT MANAGE THE
// TASKS / THREADS.
public class HelloController
{
    @FXML
    private ListView<String> listView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label progressLabel;

    private Service<ObservableList<String>> service;

    public void initialize()
    {
        // Using Service instead of Task
        service = new EmployeeService();
        listView.itemsProperty().bind(service.valueProperty());
        progressBar.progressProperty().bind(service.progressProperty());
        progressLabel.textProperty().bind(service.messageProperty());

        // The Server class has got methods that allow us to run code everytime the Service.State changes.
        // Managing the visibility of the progress bar during the service using these methods.
//        service.setOnRunning(workerStateEvent ->
//                             {
//                                 progressBar.setVisible(true);
//                                 progressLabel.setVisible(true);
//                             });
//
//        service.setOnSucceeded(workerStateEvent ->
//                               {
//                                   progressBar.setVisible(false);
//                                   progressLabel.setVisible(false);
//                               });

        // Code that will be executed when the program is run for the first time.
//        progressBar.setVisible(false);
//        progressLabel.setVisible(false);

        // Using data binding for the visibility of the progress bar, which is a LOT better.
        // Binding of properties is a lot cleaner and elegant when its usage is possible.
        progressBar.visibleProperty().bind(service.runningProperty());
        progressLabel.visibleProperty().bind(service.runningProperty());

        // If you want to pass parameters to the tasks that the server runs we have to expose those parameters as
        // properties of the Service subclass. Basically by creating fields in the Server subclass and using contractors
        // or setters to populate these properties, so they can be used in the tasks.
    }

    @FXML
    public void buttonPressed()
    {
        // We can only use a Service once, if we try to click on the button again we will get an exception telling us
        // that the state of the service has already changed (to "SUCCEEDED", in this case), therefore it can't be used
        // again. The service must be in the "READY" state to be restarted.

        if (service.getState() == Service.State.SUCCEEDED)
        {
            service.reset();
            service.start(); // Starting our service
        }
        else if (service.getState() == Service.State.READY)
        {
            service.start();
        }
    }

}
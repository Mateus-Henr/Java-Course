package challenge;

import challenge.datamodel.Contact;
import challenge.datamodel.ContactData;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Optional;

public class Controller
{
    @FXML
    private BorderPane mainPanel;
    @FXML
    private TableView<Contact> tableView;

    private ContactData data;

    public void initialize()
    {
        data = new ContactData();
        data.loadContacts(); // Loading contacts into the class after creating the instance.
        tableView.setItems(data.getContacts());
//        tableView.getSelectionModel().selectFirst();
    }

    @FXML
    public void showAddContactDialog()
    {
        // Configuring the dialog
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("New Contact");

        // Configuring the dialog's fxml (loading the fxml content with the content in the "contactdialog.fxml" file)
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));

        try
        {
            // Setting the content loaded into the Dialog window
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch (IOException e)
        {
            System.out.println("Couldn't load the dialog.");
            e.printStackTrace();
            return;
        }

        // Our Buttons
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        // The result of the button
        Optional<ButtonType> result = dialog.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            ContactController contactController = fxmlLoader.getController();
            Contact newContact = contactController.getNewContact();
            data.addContact(newContact);

            // As it's a small app, everytime the user modifies a contact we are going to save it in the file.
            data.saveContacts();
        }
    }

    @FXML
    public void showEditContactDialog()
    {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

        if (selectedContact == null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected.");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit.");
            alert.showAndWait();
            return; // Returning the event handler since the user made an invalid operation.
        }

        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainPanel.getScene().getWindow());
        dialog.setTitle("Edit Contact");

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("contactdialog.fxml"));

        try
        {
            dialog.getDialogPane().setContent(fxmlLoader.load());
        }
        catch (IOException e)
        {
            System.out.println("Couldn't load the dialog.");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        ContactController contactController = fxmlLoader.getController();
        // Using this method to populate the dialog with the data of the selected contact
        contactController.editContact(selectedContact);

        // DISPLAYING THE DIALOG ONLY AFTER HAVING SET ITS DEFAULT VALUE (that's the contact information).
        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            // Updating the contact object
            contactController.updateContact(selectedContact);
            data.saveContacts();
        }
    }

    @FXML
    public void deleteContact()
    {
        Contact selectedContact = tableView.getSelectionModel().getSelectedItem();

        if (selectedContact == null)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No contact selected.");
            alert.setHeaderText(null);
            alert.setContentText("Please select the contact you want to edit.");
            alert.showAndWait();
            return;
        }

        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setHeaderText(null);
        confirmationAlert.setTitle("Are you sure?");

        StringBuilder sb = new StringBuilder();
        sb.append("\nFirst Name: ").append(selectedContact.getFirstName());
        sb.append("\nLast Name: ").append(selectedContact.getLastName());
        sb.append("\nPhone Number: ").append(selectedContact.getPhoneNumber());
        sb.append("\nNotes: ").append(selectedContact.getNotes());

        confirmationAlert.setContentText("Delete contact with the following data:" + sb);
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK)
        {
            data.removeContact(selectedContact);
            data.saveContacts();
        }
    }

}
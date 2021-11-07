package challenge;

import challenge.datamodel.Contact;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ContactController
{
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private TextField notesField;

    // As we need this contact information in our main controller we are using this method to "export" this information.
    public Contact getNewContact()
    {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String phoneNumber = phoneNumberField.getText();
        String notes = notesField.getText();

        // Bear in mind, in a real world application the input would need to be verified.
        return new Contact(firstName, lastName, phoneNumber, notes);
    }

    // FINALLY, WHAT I'VE BEEN LOOKING FOR. Here we are populating the dialog with the contact information to be
    // modified.
    public void editContact(Contact oldContact)
    {
        firstNameField.setText(oldContact.getFirstName());
        lastNameField.setText(oldContact.getLastName());
        phoneNumberField.setText(oldContact.getPhoneNumber());
        notesField.setText(oldContact.getNotes());
    }

    // Here we are getting the data that has been populated before and modified by the user and passing it to the
    // contact object that we are modifying.
    public void updateContact(Contact contactToUpdate)
    {
        contactToUpdate.setFirstName(firstNameField.getText());
        contactToUpdate.setLastName(lastNameField.getText());
        contactToUpdate.setPhoneNumber(phoneNumberField.getText());
        contactToUpdate.setNotes(notesField.getText());
    }

}

package challenge;

import challenge.datamodel.Contact;
import challenge.datamodel.ContactData;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class Controller
{
    @FXML
    private TableView<Contact> tableView;

    public void initialize()
    {
        ContactData contactData = new ContactData();
        tableView.setItems(contactData.getContacts());
    }

    @FXML
    public void showAddContactDialog()
    {
    }

}
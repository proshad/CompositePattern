package sample.com.cefalo.school.controls;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.responses.CustomResponse;

/**
 * Created by proshad on 10/25/16.
 */
public class PhoneNumberField extends HBox implements Component {
    private Label label;
    private TextField textField;

    public PhoneNumberField(String labelText) {
        this.label = new Label(labelText);
        this.textField = new TextField();
        getChildren().addAll(this.label, this.textField);
    }

    public void add(Component component) {
        throw new UnsupportedOperationException();
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException();
    }

    public CustomResponse validate() {
        String name = this.label.getText().trim();
        String value = this.textField.getText().trim();
        CustomResponse response = new CustomResponse("1");
        if (value.equals(null) || value.isEmpty()) {
            String msg = "Invalid: field " + name + " cannot be empty.";
            response.setStatus("0");
            response.addMessage(msg);
        } else {
            if (!validatePhoneAndFaxNumber(value)) {
                String msg = "Invalid: field " + name + " is not a correct format. Correct format 191-128-7205 or 1911287205 or 191 128 7205";
                response.setStatus("0");
                response.addMessage(msg);
            }
        }
        return response;
    }

    private boolean validatePhoneAndFaxNumber(String phoneNo) {
        //validate phone numbers of format "1234567890"
        if (phoneNo.matches("\\d{10}")) return true;
            //validating phone number with -, . or spaces
        else if(phoneNo.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
            //validating phone number with extension length from 3 to 5
        else if(phoneNo.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
            //validating phone number where area code is in braces ()
        else if(phoneNo.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
            //return false if nothing matches the input
        else return false;

    }


}

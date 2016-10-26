package sample.com.cefalo.school.controls;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.responses.CustomResponse;

import javax.mail.internet.InternetAddress;

/**
 * Created by proshad on 10/25/16.
 */
public class EmailField extends HBox implements Component {
    private Label label;
    private TextField textField;

    public EmailField(String labelText) {
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
            if (!isValidEmailAddress(value)) {
                String msg = "Invalid: field "+name+ " is not a correct format for email address.";
                response.setStatus("0");
                response.addMessage(msg);
            }
        }
        return response;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

}
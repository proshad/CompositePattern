package sample.com.cefalo.school.controls;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.responses.CustomResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by proshad on 10/25/16.
 */
public class EmailField extends HBox implements Component {
    private static final String VALID_EMAIL_PATTERN = "^[_A-Za-z0-9]+([_A-Za-z0-9]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,6})$";
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

        String name = this.label.getText();
        String value = this.textField.getText();
        CustomResponse response = new CustomResponse("1");
        if (value.equals(null) || value.isEmpty()) {
            String msg = "Invalid: field " + name + " cannot be empty.";
            response.setStatus("0");
            response.addMessage(msg);
        } else {
            if (!validateRegEx(value)) {
                String msg = "Invalid: field "+name+ " is not a correct format for email address.";
                response.setStatus("0");
                response.addMessage(msg);
            }
        }
        return response;
    }


    private boolean validateRegEx(String str) {
        Matcher matcher = Pattern.compile(VALID_EMAIL_PATTERN).matcher(str);
        return matcher.matches();
    }

}
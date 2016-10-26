package sample.com.cefalo.school.controls;

import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.responses.CustomResponse;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by proshad on 10/26/16.
 */
public class WebField extends HBox implements Component {
    private Label label;
    private TextField textField;

    public WebField(String labelText) {
        this.label = new Label(labelText);
        this.textField = new javafx.scene.control.TextField();
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
            if (!isValidURL(value)) {
                String msg = "Invalid: field " + name + " is not a correct format for web url";
                response.setStatus("0");
                response.addMessage(msg);
            }
        }
        return response;
    }

    private boolean isValidURL(String url) {
        URL u = null;
        try {
            u = new URL(url);
        } catch (MalformedURLException e) {
            return false;
        }
        try {
            u.toURI();
        } catch (URISyntaxException e) {
            return false;
        }
        return true;
    }

}

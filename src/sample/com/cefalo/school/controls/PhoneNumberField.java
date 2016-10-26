package sample.com.cefalo.school.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.validators.CustomResponse;
import sample.com.cefalo.school.validators.CustomValidator;

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
        return CustomValidator.validatePhone(this.label.getText(), this.textField.getText());
    }

}

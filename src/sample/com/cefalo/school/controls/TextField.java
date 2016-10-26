package sample.com.cefalo.school.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.validators.CustomResponse;
import sample.com.cefalo.school.validators.CustomValidator;

/**
 * Created by proshad on 10/25/16.
 */
public class TextField extends HBox implements Component {
    private Label label;
    private javafx.scene.control.TextField textField;

    public TextField(String labelText) {
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
        return CustomValidator.checkForEmptyField(this.label.getText(), this.textField.getText());
    }

}
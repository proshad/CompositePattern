package sample.com.cefalo.school.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.validators.FieldValidator;
import sample.com.cefalo.school.validators.ValidationResponse;

/**
 * Created by proshad on 10/25/16.
 */
public class EmailField extends HBox implements Component {
    private Label label;
    private TextField textField;

    private EmailField() {

    }

    public EmailField(String labelText) {
        this.label = new Label(labelText);
        this.textField = new TextField();
        getChildren().addAll(this.label, this.textField);

        setDefaultConfigs();
    }

    public String getEmail() {
        return this.textField.getText();
    }

    public void add(Component component) {
        throw new UnsupportedOperationException("Can not add component.");
    }

    public void remove(Component component) {
        throw new UnsupportedOperationException("Nothing to remove.");
    }

    public void getChild(int index) {
        throw new UnsupportedOperationException("No child associated with leaf component.");
    }

    public ValidationResponse validate() {
        return FieldValidator.validateEmail(this.label.getText(), this.textField.getText());
    }

    private void setDefaultConfigs() {
        setSpacing(5);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(5, 5, 5, 5));

        this.textField.setPrefSize(250, 30);
        this.textField.setStyle("-fx-font-size: 15pt;");

        this.label.setStyle("-fx-font-size: 15pt;");
    }
}
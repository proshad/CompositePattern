package sample.com.cefalo.school.controls;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import sample.com.cefalo.school.validators.FieldValidator;
import sample.com.cefalo.school.validators.ValidationResponse;

/**
 * Created by proshad on 10/25/16.
 */
public class PasswordField extends VBox implements Component {
    private HBox hBoxPassword;
    private Label labelPassword;
    private javafx.scene.control.PasswordField passwordField;

    private HBox hBoxConfirmPassword = new HBox();
    private Label labelConfirmPassword;
    private javafx.scene.control.PasswordField confirmPasswordField;

    public PasswordField() {
        this("Password*", "Confirm Password*");
    }

    public PasswordField(String passwordLabel, String confirmPasswordLabel) {
        this.hBoxPassword = new HBox();
        this.labelPassword = new Label(passwordLabel);
        this.passwordField = new javafx.scene.control.PasswordField();
        this.hBoxPassword.getChildren().addAll(this.labelPassword, this.passwordField);

        this.hBoxConfirmPassword = new HBox();
        this.labelConfirmPassword = new Label(confirmPasswordLabel);
        this.confirmPasswordField = new javafx.scene.control.PasswordField();
        this.hBoxConfirmPassword.getChildren().addAll(this.labelConfirmPassword, this.confirmPasswordField);

        getChildren().addAll(this.hBoxPassword, this.hBoxConfirmPassword);
        setDefaultConfigs();
    }

    public String getPassword() {
        return this.passwordField.getText();
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
        return FieldValidator.validatePassword(this.passwordField.getText(), this.confirmPasswordField.getText());
    }

    private void setDefaultConfigs() {
        setStyle("-fx-alignment: center-left;-fx-spacing: 5;-fx-padding: 5");
        this.hBoxPassword.setStyle("-fx-alignment: center-left;-fx-spacing: 5;-fx-padding: 5");
        this.hBoxConfirmPassword.setStyle("-fx-alignment: center-left;-fx-spacing: 5;-fx-padding: 5");


        this.passwordField.setPrefSize(250, 30);
        this.passwordField.setStyle("-fx-font-size: 15pt;");

        this.labelPassword.setStyle("-fx-font-size: 15pt;");

        this.confirmPasswordField.setPrefSize(250, 30);
        this.confirmPasswordField.setStyle("-fx-font-size: 15pt;");

        this.labelConfirmPassword.setStyle("-fx-font-size: 15pt;");
    }
}

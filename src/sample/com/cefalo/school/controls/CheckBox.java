package sample.com.cefalo.school.controls;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.validators.ValidationResponse;
import sample.com.cefalo.school.validators.ValidationStatus;

/**
 * Created by proshad on 10/25/16.
 */
public class CheckBox extends HBox implements Component {
    private Label label;
    private javafx.scene.control.CheckBox checkBox;

    private CheckBox() {

    }

    public CheckBox(String labelText) {
        this.label = new Label(labelText);
        this.checkBox = new javafx.scene.control.CheckBox();
        getChildren().addAll(this.label, this.checkBox);

        setDefaultConfigs();
    }

    public boolean isSelected() {
        return this.checkBox.isSelected();
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
        return new ValidationResponse(ValidationStatus.SUCCESS);
    }

    private void setDefaultConfigs() {
        setSpacing(5);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(5, 5, 5, 5));

        this.label.setStyle("-fx-font-size: 15pt;");
    }
}
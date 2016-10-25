package sample.com.cefalo.school.controls;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.models.ComboItem;
import sample.com.cefalo.school.validators.FieldValidator;
import sample.com.cefalo.school.validators.ValidationResponse;

/**
 * Created by proshad on 10/25/16.
 */
public class ComboBox extends HBox implements Component {
    private Label label;
    private javafx.scene.control.ComboBox<ComboItem> comboBox;

    private ComboBox() {

    }

    public ComboBox(String labelText) {
        this.label = new Label(labelText);
        this.comboBox = new javafx.scene.control.ComboBox<ComboItem>();
        getChildren().addAll(label, this.comboBox);

        setDefaultConfigs();
    }

    public ComboBox(String labelText, ObservableList<ComboItem> data) {
        this.label = new Label(labelText);
        this.comboBox = new javafx.scene.control.ComboBox<ComboItem>(data);
        getChildren().addAll(this.label, this.comboBox);

        setDefaultConfigs();
    }

    public ComboItem getSelectedItem() {
        return this.comboBox.getSelectionModel().getSelectedItem();
    }

    public void addItem(ComboItem item) {
        this.comboBox.getItems().add(item);
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
        return FieldValidator.validateComboEntry(this.label.getText(), getSelectedItem().getKey());
    }

    private void setDefaultConfigs() {
        setSpacing(5);
        setAlignment(Pos.CENTER_LEFT);
        setPadding(new Insets(5, 5, 5, 5));

        this.label.setStyle("-fx-font-size: 15pt;");

        this.comboBox.setPrefSize(250, 30);
        this.comboBox.getSelectionModel().selectFirst();
    }
}
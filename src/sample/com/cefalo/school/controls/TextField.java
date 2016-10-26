package sample.com.cefalo.school.controls;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import sample.com.cefalo.school.responses.CustomResponse;

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
        String name = this.label.getText();
        String value = this.textField.getText();
        CustomResponse response = new CustomResponse("1");
        if(value.equals(null) || value.isEmpty()){
            String msg = "Invalid: field "+name+ " cannot be empty.";
            response.setStatus("0");
            response.addMessage(msg);
        }

        return response;
    }

}
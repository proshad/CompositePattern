package sample.com.cefalo.school.containers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import sample.com.cefalo.school.controls.Component;
import sample.com.cefalo.school.validators.ValidationResponse;
import sample.com.cefalo.school.validators.ValidationStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proshad on 10/25/16.
 */
public class FieldGroup extends VBox implements Component {
    List<Component> components = new ArrayList<Component>();

    public void add(Component component) {
        this.components.add(component);
        getChildren().add((Node) component);

        setDefaultConfigs();
    }

    public void remove(Component component) {
        this.components.remove(component);
    }

    public void getChild(int index) {
        this.components.get(index);
    }

    public ValidationResponse validate() {
        ValidationResponse response = new ValidationResponse(ValidationStatus.SUCCESS);
        for (Component component : components) {
            ValidationStatus status = component.validate().getStatus();
            List<String> messages = component.validate().getMessages();
            if (status == ValidationStatus.ERROR) {
                response.setStatus(status);//Overriding same value inside iteration. Need to find a better solution
                response.getMessages().addAll(messages);
            }
        }

        return response;
    }

    private void setDefaultConfigs() {
        setStyle("-fx-border-color: black;");
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(5);
    }
}
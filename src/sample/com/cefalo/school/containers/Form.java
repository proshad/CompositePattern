package sample.com.cefalo.school.containers;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.com.cefalo.school.controls.Component;
import sample.com.cefalo.school.validators.ValidationResponse;
import sample.com.cefalo.school.validators.ValidationStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proshad on 10/25/16.
 */
public class Form extends VBox implements Component {
    List<Component> components = new ArrayList<Component>();

    public Form() {

    }

    public void add(Component component) {
        this.components.add(component);
        getChildren().add((Node) component);
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

}
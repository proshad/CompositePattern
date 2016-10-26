package sample.com.cefalo.school.containers;

import javafx.scene.Node;
import javafx.scene.layout.VBox;
import sample.com.cefalo.school.controls.Component;
import sample.com.cefalo.school.responses.CustomResponse;

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

    public CustomResponse validate() {
        CustomResponse response = new CustomResponse("1");
        for (Component component : components) {
            String status = component.validate().getStatus();
            List<String> messages = component.validate().getMessages();
            if (status.equals("0")) {
                response.setStatus(status);
                response.getMessages().addAll(messages);
            }
        }

        return response;
    }

}
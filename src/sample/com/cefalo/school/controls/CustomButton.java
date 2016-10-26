package sample.com.cefalo.school.controls;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;

/**
 * Created by proshad on 10/25/16.
 */
public class CustomButton extends HBox {
    private Button button;

    public CustomButton(String label) {
        this.button = new Button(label);
        getChildren().add(this.button);
        setAlignment(Pos.BOTTOM_RIGHT);
    }

    public void onClickHandler(EventHandler<ActionEvent> eventHandler) {
        this.button.setOnAction(eventHandler);
    }
}
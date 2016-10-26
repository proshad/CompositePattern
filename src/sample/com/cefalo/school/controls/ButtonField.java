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
public class ButtonField extends HBox {
    private Button button;

    public ButtonField(String label) {
        this.button = new Button(label);
        getChildren().add(this.button);
        setAlignment(Pos.BOTTOM_LEFT);
        setPadding(new Insets(10,10,10,10));
    }

    public void onClickHandler(EventHandler<ActionEvent> eventHandler) {
        this.button.setOnAction(eventHandler);
    }
}
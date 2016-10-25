package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import sample.com.cefalo.school.containers.FieldGroup;
import sample.com.cefalo.school.containers.Form;
import sample.com.cefalo.school.controls.*;
import sample.com.cefalo.school.models.ComboItem;
import sample.com.cefalo.school.validators.ValidationResponse;

public class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Form Validation Using Composite Design Pattern");

        VBox layout = new VBox();
        layout.autosize();
        layout.setStyle("-fx-background-color: #2f4f4f");

        Scene scene = new Scene(layout, Color.GRAY);
        stage.setScene(scene);

    /*Custom Form Component*/
        final Component form = new Form("Form");

    /*Custom Login Field Group Component*/
        Component loginFieldGroup = new FieldGroup();
        Component email = new EmailField("Email*");
        loginFieldGroup.add(email);

        Component password = new PasswordField();
        loginFieldGroup.add(password);
        form.add(loginFieldGroup);

    /*Custom Basic Info Field Group Component*/
        Component basicInfoFieldGroup = new FieldGroup();
        final Component firstName = new TextField("First Name*");
        basicInfoFieldGroup.add(firstName);

        Component lastName = new TextField("Last Name*");
        basicInfoFieldGroup.add(lastName);

        ObservableList<ComboItem> data =
                FXCollections.observableArrayList(
                        new ComboItem(-1, "Select Gender"),
                        new ComboItem(0, "Male"),
                        new ComboItem(1, "Female"),
                        new ComboItem(2, "Other"));
        Component gender = new ComboBox("Gender", data);
        basicInfoFieldGroup.add(gender);

        Component maritalStatus = new CheckBox("Married");
        basicInfoFieldGroup.add(maritalStatus);

        form.add(basicInfoFieldGroup);

    /*Custom Address Field Group Component*/
        Component addressFieldGroup = new FieldGroup();
        Component address = new TextField("Address*");
        addressFieldGroup.add(address);

        Component city = new TextField("City*");
        addressFieldGroup.add(city);

        Component state = new TextField("State*");
        addressFieldGroup.add(state);

        Component zipCode = new TextField("ZIP Code*");
        addressFieldGroup.add(zipCode);
        form.add(addressFieldGroup);

    /*Custom Contacts Field Group Component*/
        Component contactFieldGroup = new FieldGroup();
        Component phone = new PhoneNumberField("Phone*");
        contactFieldGroup.add(phone);

        Component mobilePhone = new PhoneNumberField("Mobile Phone*");
        contactFieldGroup.add(mobilePhone);

        form.add(contactFieldGroup);
        layout.getChildren().add((Node) form);

        FxButton button = new FxButton("Save", Pos.BOTTOM_LEFT);
        button.onClickHandler(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ValidationResponse response = form.validate();
                FxDialog.show(stage, response);
            }
        });

        layout.getChildren().add(button);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

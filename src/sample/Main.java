package sample;

import javafx.application.Application;
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
import sample.com.cefalo.school.validators.ValidationResponse;

public class Main extends Application {

    @Override
    public void start(final Stage stage) throws Exception {
        stage.setTitle("Form Validation Using Composite Design Pattern");

        VBox layout = new VBox();
        layout.setMinWidth(700.0);
        layout.setMinHeight(800.0);
        layout.setMaxWidth(800.0);
        layout.setMaxHeight(1000.0);
        Scene scene = new Scene(layout, Color.GRAY);
        stage.setScene(scene);

        //   main form
        final Component myForm = new Form();

        //    email and website component
        Component emailWebGroup = new FieldGroup();
        Component email = new EmailField("Email Address");
        emailWebGroup.add(email);
        Component website = new TextField("Personal Website");
        emailWebGroup.add(website);
        myForm.add(emailWebGroup);

        //    Name group component
        Component nameGroup = new FieldGroup();
        Component firstName = new TextField("First Name");
        nameGroup.add(firstName);
        Component lastName = new TextField("Last Name");
        nameGroup.add(lastName);
        myForm.add(nameGroup);

        //    Address field group
        Component addressGroup = new FieldGroup();
        Component address = new TextField("Address");
        addressGroup.add(address);
        Component city = new TextField("City");
        addressGroup.add(city);
        Component state = new TextField("State");
        addressGroup.add(state);
        Component zipCode = new TextField("ZIP Code");
        addressGroup.add(zipCode);
        myForm.add(addressGroup);

        //    Contacts Field Group
        Component contactsGroup = new FieldGroup();
        Component dayPhone = new PhoneNumberField("Day Phone");
        contactsGroup.add(dayPhone);
        Component eveningPhone = new PhoneNumberField("Evening Phone");
        contactsGroup.add(eveningPhone);
        Component mobilePhone = new PhoneNumberField("Mobile Phone");
        contactsGroup.add(mobilePhone);
        Component fax = new PhoneNumberField("Fax");
        contactsGroup.add(fax);
        myForm.add(contactsGroup);

//        Add form to layout
        layout.getChildren().add((Node) myForm);

        CustomButton button = new CustomButton("Save", Pos.BOTTOM_RIGHT);
        button.onClickHandler(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ValidationResponse response = myForm.validate();
                CustomDialog.show(stage, response);
            }
        });

        layout.getChildren().add((Node) button);


        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

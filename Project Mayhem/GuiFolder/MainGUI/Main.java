package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ToolBar;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane gamegui = new GridPane();
        gamegui.setAlignment(Pos.TOP_CENTER);
        gamegui.setHgap(10);
        gamegui.setVgap(10);
        gamegui.setGridLinesVisible(false);

        Scene scene = new Scene(gamegui, 550, 300);


        Label nameLabel = new Label("Enter Your Name");
        TextField nameField = new TextField();
        gamegui.add(nameLabel, 0, 0);
        gamegui.add(nameField, 1, 0);


        Label classLabel = new Label("Select a college");
        ChoiceBox collegeChoice = new ChoiceBox(FXCollections.observableArrayList("Argyros", "College of the Performing Arts", "Crean",
                "Dodge", "Schmid"));
        gamegui.add(collegeChoice, 1, 1);
        gamegui.add(classLabel, 0, 1);

        Label readyLabel = new Label("Click to begin");
        Button readyButton = new Button ("Ready");
        gamegui.add(readyLabel, 0, 2);
        gamegui.add(readyButton, 1, 2);

        Button move1 = new Button("Move 1");
        Button move2 = new Button("Move 2");
        Button move3 = new Button("Move 3");
        Button move4 = new Button("Move 4");
        ToolBar moveSet = new ToolBar(move1, move2, move3, move4);

        gamegui.add(moveSet, 0, 4);



        Label chatLabel = new Label("Server Chat");
        TextArea chatArea = new TextArea("Server Chat Goes Here");
        chatArea.setPrefSize(300, 100);
        gamegui.add(chatArea, 0, 5);

        TextArea collegeDescription = new TextArea("Move descriptions go here");
        collegeDescription.setPrefSize(200, 100);
        gamegui.add(collegeDescription, 1, 5);




        primaryStage.setTitle("Project Mayhem");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

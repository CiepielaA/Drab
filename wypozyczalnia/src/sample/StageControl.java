package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class StageControl {
    private Parent parent;
    private Scene scene;
    private Stage stage;




    public void changeStage(ActionEvent event, String fxmlFileName){
        try {
            parent = FXMLLoader.load(getClass().getResource(fxmlFileName));
            scene = new Scene(parent);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void newStage(Button button, String fxmlFileName, String stageTitle){
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {

                try {
                    parent= FXMLLoader.load(getClass().getResource(fxmlFileName));
                    stage = new Stage();
                    stage.setTitle(stageTitle);
                    stage.setScene(new Scene(parent, 800, 600));
                    stage.show();
                    stage.setMinWidth(800);
                    stage.setMinHeight(600);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

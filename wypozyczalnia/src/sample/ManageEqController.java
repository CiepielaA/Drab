package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ManageEqController {
    @FXML
    private Button addEqButton;

    public void addEqButtonClicked(ActionEvent event){
        new StageControl().newStage(addEqButton, "addEqPane.fxml", "Dodaj nowy sprzęt");
    }
    public void updateEqInfoButton(){

    }
    public void deleteEqButton(){

    }
}

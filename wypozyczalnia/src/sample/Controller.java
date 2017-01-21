package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField loginTextField;
    @FXML
    private PasswordField passwordField;

    public final String LOGIN_ADMIN = "admin";
    public final String PASS_ADMIN = "admin";
    public final String LOGIN_USER = "user";
    public final String PASS_USER = "user";

    @FXML
    public void logInButtonClicked(ActionEvent event){
        if (passwordField.getText().equals(PASS_ADMIN) && loginTextField.getText().equals(LOGIN_ADMIN)) {
            new StageControl().changeStage(event, "adminPane.fxml");
        }
    }
    public void manageEqButtonClicked(ActionEvent event){
        new StageControl().changeStage(event, "manageEqPane.fxml");
        new ManageEqController();
    }
    public void manageOrderButtonClicked(ActionEvent event){
        new StageControl().changeStage(event, "manageOrderPane.fxml");
    }
    public void logOutButtonClicked(ActionEvent event){
        new StageControl().changeStage(event, "sample.fxml");
    }
}

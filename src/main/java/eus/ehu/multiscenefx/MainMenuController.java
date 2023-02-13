package eus.ehu.multiscenefx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

    private MultiSceneApplication mainApp;

    @FXML
    void logout(ActionEvent event) {
        System.out.println("Logout");
        mainApp.changeScene("Login");
    }

    public void setMain(MultiSceneApplication multiSceneApplication) {
        this.mainApp = multiSceneApplication;
    }


    @FXML
    void initialize() {

    }

}

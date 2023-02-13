package eus.ehu.multiscenefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MultiSceneApplication extends Application {


    private Stage stage;
    private Scene loginScene;
    private Scene mainMenuScene;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;

        FXMLLoader fxmlLoaderLogin = new FXMLLoader(MultiSceneApplication.class.getResource("login.fxml"));
        Parent loginUI = fxmlLoaderLogin.load();
        MultiSceneController loginController = fxmlLoaderLogin.getController();
        loginController.setMain(  this  );
        loginScene = new Scene( loginUI );

        // FIXME: this is working but it's not perfect
        FXMLLoader fxmlLoaderMain = new FXMLLoader(MultiSceneApplication.class.getResource("main-menu.fxml"));
        Parent mainUI = fxmlLoaderMain.load();
        MainMenuController mainMenuController = fxmlLoaderMain.getController();
        mainMenuController.setMain(  this  );
        mainMenuScene = new Scene(  mainUI );

        stage.setTitle("Login");
        stage.setScene( loginScene );
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeScene(String scene) {
        switch (scene) {
            case "Login":
                stage.setScene(loginScene);
                break;
            case "Main Menu":
                stage.setScene(mainMenuScene);
                break;
        }
    }
}

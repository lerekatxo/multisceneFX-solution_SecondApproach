package eus.ehu.multiscenefx;

import eus.ehu.multiscenefx.controllers.FXController;
import eus.ehu.multiscenefx.controllers.MainMenuController;
import eus.ehu.multiscenefx.controllers.MultiSceneController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



//rename scene parameter and use just a single scene !!
public class MultiSceneApplication extends Application {



    class Window{
        Parent wi;
        FXController controller;
        //FXController will be an interface! //hold a reference to the Controller

    }


    //load window
    private Window load(String fxmlFile){

        Window window = new Window;
        FXMLLoader fxmlLoader = new FXMLLoader(MultiSceneApplication.class.getResource("login.xlm");

        window.ui = fxmlLoader.load();
        window.controller=  fxmlLoader.getController();

        window.controller.setMain(this);    //This --> refers to the class
                        return window;

    }


    private Stage stage;

    //private Scene loginScene;
    //private Scene mainMenuScene;

    private Scene scene; //just using one scene
    private Parent loginUI;
    private Parent mainUI;

    @Override
    public void start(Stage stage) throws IOException {

        this.stage = stage;


        Window loginWindow = load("login.xlm");
        Window mainWindow = load("main.menu.xlm");

        //FXMLLoader fxmlLoaderLogin = new FXMLLoader(MultiSceneApplication.class.getResource("login.fxml"));
       // loginUI = fxmlLoaderLogin.load(); //before(Parent loginUI = fxmlLoaderLogin.load();) was a local variable, now is an atrribute
        //MultiSceneController loginController = fxmlLoaderLogin.getController();
        //loginController.setMain(  this  );
        //loginScene = new Scene( loginUI );

        // FIXME: this works but should be refactored
        // The code is duplicated, when we face this problem we should try to improve our design
        // Whenever, i need to try I newfeature
        // To do that, we will create a new branch
        //  all the new commits should go to main
        //FXMLLoader fxmlLoaderMain = new FXMLLoader(MultiSceneApplication.class.getResource("main-menu.fxml"));
        //mainUI = fxmlLoaderMain.load();
        //MainMenuController mainMenuController = fxmlLoaderMain.getController();
        //mainMenuController.setMain(  this  );
        //mainMenuScene = new Scene( mainUI );


        scene = new Scene(loginUI);
        stage.setTitle("Login");
        //stage.setScene(loginScene);
        stage.setScene(scene); //just one
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void changeScene(String sceneName) {  //the argument we get  is of type String
        switch (sceneName) {
            case "Login":
                stage.setTitle("Login");
                scene.setRoot(loginWindow.ui);
                //stage.setScene(loginScene);
                stage.setScene(scene);

                break;
            case "Main Menu":
                stage.setTitle("Main Menu");
                scene.setRoot(mainWindow.ui) ;
                //stage.setScene(mainMenuScene);
                stage.setScene(scene);
                break;
        }
    }
}

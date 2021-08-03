package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Main extends Application {
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        URL welcomeUrl = getClass().getResource("Main.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(welcomeUrl));
        primaryStage.setTitle("Game Menu");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        Config.config = new Config(750 , 700);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void goToNewScene(MouseEvent mouseEvent) throws Exception {
        new Show().start(stage);
    }
}
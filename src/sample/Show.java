package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Objects;

public class Show extends Application {

    public AnchorPane layout;

    @Override
    public void start(Stage stage) throws Exception {
        URL gameMenuUrl = getClass().getResource("Show.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(gameMenuUrl));
        stage.setTitle("Game Views");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void initialize(){
        layout.setPrefSize(Config.config.getWidth() , Config.config.getHeight());
    }

}

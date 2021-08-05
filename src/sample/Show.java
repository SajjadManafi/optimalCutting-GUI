package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
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
    public void initialize() throws CloneNotSupportedException {
        layout.setPrefSize(Config.config.getWidth() , Config.config.getHeight());
        //TODO: first check if cant place one from objects

        // test bin algorithm
        ArrayList<Shape> sh = new ArrayList<>();
        Node bb = new sample.Node();
        sh.add(new Rectangular(171,69));
        sh.add(new Circular(0,0 , 80));
        sh.add(new Rectangular(102,34));
        sh.add(new Circular(0,0 , 56));

        bb.shapes = Cut.cut(sh);

        bb.sort();
        bb.fit();

        for (int i = 0; i < bb.shapes.size(); i++) {
            if (bb.shapes.get(i).getFit() != null) {
                bb.shapes.get(i).setShapeX(bb.shapes.get(i).getFit().getX());
                bb.shapes.get(i).setShapeY(bb.shapes.get(i).getFit().getY());
                layout.getChildren().add((javafx.scene.Node) bb.shapes.get(i));
            }
        }

    }

}

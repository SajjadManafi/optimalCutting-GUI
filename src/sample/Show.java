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

        // test bin algorithm
        /*
        Shape rect = new Rectangular(100,100);
        Node bb = new sample.Node();
        Shape rect2 = new Rectangular(250,100);
        Shape rect3 = new Rectangular(450,200);
        Shape rect4 = new Circular(0,0,240);

        bb.addShape(rect2);
        bb.addShape(rect);
        bb.addShape(rect3);
        bb.addShape(rect4);

        bb.sort();
        bb.fit();
//        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(0));
//        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(1));
        System.out.println(bb.shapes.get(0).getFit().getX() + " " + bb.shapes.get(0).getFit().getY());
        System.out.println(bb.shapes.get(1).getFit().getX() + "-" + bb.shapes.get(1).getFit().getY());
        System.out.println(bb.shapes.get(2).getFit().getX() + "---" + bb.shapes.get(2).getFit().getY());
        System.out.println(bb.shapes.get(3).getFit().getX() + "---" + bb.shapes.get(3).getFit().getY());
        System.out.println(bb.shapes.get(0).getShapeWidth());
        bb.shapes.get(0).setShapeX(bb.shapes.get(0).getFit().getX());
        bb.shapes.get(0).setShapeY(bb.shapes.get(0).getFit().getY());
        bb.shapes.get(1).setShapeX(bb.shapes.get(1).getFit().getX());
        bb.shapes.get(1).setShapeY(bb.shapes.get(1).getFit().getY());
        bb.shapes.get(2).setShapeX(bb.shapes.get(2).getFit().getX());
        bb.shapes.get(2).setShapeY(bb.shapes.get(2).getFit().getY());
        bb.shapes.get(3).setShapeX(bb.shapes.get(3).getFit().getX());
        bb.shapes.get(3).setShapeY(bb.shapes.get(3).getFit().getY());
        layout.getChildren().add((javafx.scene.Node) bb.shapes.get(0));
        layout.getChildren().add((javafx.scene.Node) bb.shapes.get(1));
        layout.getChildren().add((javafx.scene.Node) bb.shapes.get(2));
        layout.getChildren().add((javafx.scene.Node) bb.shapes.get(3));
*/

    }

}

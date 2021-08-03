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
        Shape rect = new Rectangular(100,100);
        Node bb = new sample.Node();
        Shape rect2 = new Rectangular(250,100);
        Shape rect3 = new Rectangular(450,200);
        Shape rect4 = new Circular(0,0,240);

        Node.addShape(rect2);
        Node.addShape(rect);
        Node.addShape(rect3);
        Node.addShape(rect4);

        bb.sort();
        bb.fit();
//        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(0));
//        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(1));
        System.out.println(Node.shapes.get(0).getFit().getX() + " " + Node.shapes.get(0).getFit().getY());
        System.out.println(Node.shapes.get(1).getFit().getX() + "-" + Node.shapes.get(1).getFit().getY());
        System.out.println(Node.shapes.get(2).getFit().getX() + "---" + Node.shapes.get(2).getFit().getY());
        System.out.println(Node.shapes.get(3).getFit().getX() + "---" + Node.shapes.get(3).getFit().getY());
        System.out.println(Node.shapes.get(0).getShapeWidth());
        Node.shapes.get(0).setShapeX(Node.shapes.get(0).getFit().getX());
        Node.shapes.get(0).setShapeY(Node.shapes.get(0).getFit().getY());
        Node.shapes.get(1).setShapeX(Node.shapes.get(1).getFit().getX());
        Node.shapes.get(1).setShapeY(Node.shapes.get(1).getFit().getY());
        Node.shapes.get(2).setShapeX(Node.shapes.get(2).getFit().getX());
        Node.shapes.get(2).setShapeY(Node.shapes.get(2).getFit().getY());
        Node.shapes.get(3).setShapeX(Node.shapes.get(3).getFit().getX());
        Node.shapes.get(3).setShapeY(Node.shapes.get(3).getFit().getY());
        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(0));
        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(1));
        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(2));
        layout.getChildren().add((javafx.scene.Node) Node.shapes.get(3));
    }

}

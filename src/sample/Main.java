/***
 * This class is for the user interface. And the application menu.
 * Dimensions of materials and shapes are taken in this class
 * ***/

package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;

public class Main extends Application {
    private static Stage stage;

    public static ArrayList<Shape> initShapes = new ArrayList<>();

    Alert positiveAlert = new Alert(Alert.AlertType.ERROR, "Please enter only a positive integer", ButtonType.OK);
    Alert duplicateAlert = new Alert(Alert.AlertType.ERROR, "The entered shape is duplicate!", ButtonType.OK);
    Alert matAlert = new Alert(Alert.AlertType.ERROR, "First set Material Size", ButtonType.OK);
    Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
            "your screen not support width bigger than 1200 and height bigger than 650.\n" +
                    "Do you want to continue?\n" +
                    "The program may not work properly.",
            ButtonType.YES, ButtonType.NO);

    @FXML
    private ListView<String> myListView;

    @FXML
    private TextField materialW;

    @FXML
    private TextField materialH;

    @FXML
    private TextField rectW;

    @FXML
    private TextField rectH;

    @FXML
    private TextField circleRadios;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        URL welcomeUrl = getClass().getResource("Main.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(welcomeUrl));
        primaryStage.setTitle("Menu");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public void goToNewScene(MouseEvent mouseEvent) throws Exception {
        new Show().start(stage);
    }

    @FXML
    void addNewCircle(MouseEvent event) {
        if (Config.config != null) {
            String s = "⬤ Circle : " + "Radios: " + circleRadios.getText();

            if (circleRadios.getText().matches("[0-9]*")) {
                int radios = Integer.parseInt(circleRadios.getText());
                Shape cir = new Circular(0, 0, radios);
                if (!initShapes.contains(cir)) {
                    initShapes.add(cir);
                    myListView.getItems().add(s);
                } else {
                    duplicateAlert.showAndWait();
                }
            } else
                positiveAlert.showAndWait();
            circleRadios.setText("");
        } else {
            matAlert.showAndWait();
        }


    }

    @FXML
    void addNewRectangle(MouseEvent event) {
        if (Config.config != null) {
            String s = "⋄ Rectangle : " + " W:" + rectW.getText() + " H: " + rectH.getText();
            if (rectW.getText().matches("[0-9]*") && rectH.getText().matches("[0-9]*")) {
                int width = Integer.parseInt(rectW.getText());
                int height = Integer.parseInt(rectH.getText());
                Shape rect = new Rectangular(width, height);
                if (!initShapes.contains(rect)) {
                    initShapes.add(rect);
                    myListView.getItems().add(s);
                } else {
                    duplicateAlert.showAndWait();
                }
            } else
                positiveAlert.showAndWait();
            rectW.setText("");
            rectH.setText("");
        } else {
            matAlert.showAndWait();
        }
    }

    @FXML
    void removeShape(MouseEvent event) {
        int selectedId = myListView.getSelectionModel().getSelectedIndex();
        System.out.println(selectedId);
        if (selectedId != -1) {
            myListView.getItems().remove(selectedId);
            initShapes.remove(selectedId);
        }
    }

    @FXML
    void setMat(MouseEvent event) {
        boolean flag = false;
        if (materialW.getText().matches("[0-9]*") && materialH.getText().matches("[0-9]*")) {
            int width = Integer.parseInt(materialW.getText());
            int height = Integer.parseInt(materialH.getText());
            if (width > 1200 || height > 650) {
                alert.showAndWait();
                flag = true;
            }
            if (!flag) {
                Config.config = new Config(width, height);
            }
            if (alert.getResult() == ButtonType.YES) {
                Config.config = new Config(width, height);

            }

        }
    }
}
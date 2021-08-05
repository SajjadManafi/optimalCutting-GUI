package sample;
/***
 * Computational functions are executed in this class.
 * Also, a screenshot is taken at the end of the answer
 */

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Show extends Application {

    public AnchorPane layout;

    @Override
    public void start(Stage stage) throws Exception {
        URL gameMenuUrl = getClass().getResource("Show.fxml");
        Parent root = FXMLLoader.load(Objects.requireNonNull(gameMenuUrl));
        stage.setTitle("Views");
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    public void initialize() throws CloneNotSupportedException, IOException {
        layout.setPrefSize(Config.config.getWidth(), Config.config.getHeight());


        Node sh = new sample.Node();
        sh.shapes = Cut.cut(Main.initShapes);
        sh.sort();
        sh.fit();

        for (int i = 0; i < sh.shapes.size(); i++) {
            if (sh.shapes.get(i).getFit() != null) {
                sh.shapes.get(i).setShapeX(sh.shapes.get(i).getFit().getX());
                sh.shapes.get(i).setShapeY(sh.shapes.get(i).getFit().getY());
                layout.getChildren().add((javafx.scene.Node) sh.shapes.get(i));
            }
        }

        takeSnapShot(layout);

    }

    public void takeSnapShot(AnchorPane pane) throws IOException {
        Image i = pane.snapshot(null, null);
        ImageIO.write(SwingFXUtils.fromFXImage(i, null), "png", new File("snapshot.png"));
    }

}

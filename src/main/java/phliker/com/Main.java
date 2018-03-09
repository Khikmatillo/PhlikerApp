package phliker.com;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 * Created by nsarvar on 2/16/18.
 *
 * Main class to run the App
 *
 * @author Khikmatullo Tulkinbekov &lt;mr.khikmatillo@gmail.com&gt;
 *
 */
public class Main extends Application {

    public static Stage mainStage;

    /**
     * Main method to run the application
     * @param args the args
     */
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainStage = primaryStage;

        AnchorPane root = FXMLLoader.load(getClass().getClassLoader().getResource("PhotoView.fxml"));
        primaryStage.setTitle("Phliker");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);

        primaryStage.show();
    }
}

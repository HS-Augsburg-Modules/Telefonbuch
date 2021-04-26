package telefonbuch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    //CONSTRUCTORS

    //VARIABLES

    //METHODS
    @Override
    public void start(Stage primaryStage) throws Exception {
//    	Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        PhoneBookContainer firstStage = new PhoneBookContainer();
        primaryStage.setTitle("Phone Book");
        primaryStage.setScene(new Scene(firstStage.getBorderPane(), 455, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



}

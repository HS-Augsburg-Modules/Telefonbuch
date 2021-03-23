package telefonbuch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Telefonbuch");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        initialize();
        launch(args);
    }


    // Globale Static Variable
    private static TelefonBook tB = new TelefonBook();

    //Zum Auslesen
    private static void initialize() {
        try (FileInputStream fis = new FileInputStream(TelefonBook.path);
             ObjectInputStream ois = new ObjectInputStream(fis);) {
            tB = (TelefonBook) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread writingHook = new Thread(() -> writeTb());
        Runtime.getRuntime().addShutdownHook(writingHook);
    }

    //Write
    private static void writeTb() {
        try {
            File tB = new File(TelefonBook.path);
            if (!tB.exists()) {
                tB.setReadable(true);
                tB.setWritable(true);
                tB.createNewFile();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package telefonbuch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    //CONSTRUCTORS

    //VARIABLES

    // Global Static Variable
    private static SearchArea searchArea = new SearchArea();
    private static TelefonBook tB = new TelefonBook();
    private final static EntryArea entryArea = new EntryArea(FXCollections.observableArrayList(tB.getTelefonBook()));
    private final static UserInputArea inputArea = new UserInputArea();

    //METHODS
    @Override
    public void start(Stage primaryStage) throws Exception {
//    	Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        BorderPane root = new BorderPane();
        root.setTop(searchArea.getPane());
        root.setCenter(entryArea.getAnchorPane());
        root.setBottom(inputArea.getGridPane());
        entryArea.setItems(tB.getTelefonBook());
        primaryStage.setTitle("Phone Book");
        primaryStage.setScene(new Scene(root, 335, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        initialize();
        launch(args);
    }
    
    public static SearchArea getSearchArea() {
        return searchArea;
    }

    public static TelefonBook getTB() {
		return tB;
	}

    public static EntryArea getEntryArea() {
		return entryArea;
	}


    public static UserInputArea getInputArea() {
		return inputArea;
	}
    
    // For reading entries
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

    // Writing entries
    private static void writeTb() {
        try {
            File telefonBookFile = new File(TelefonBook.path);
            if (!telefonBookFile.exists()) {
            	telefonBookFile.setReadable(true);
            	telefonBookFile.setWritable(true);
            	telefonBookFile.createNewFile();    	
            }
            getSearchArea().setSearchText("");     
            getSearchArea().searchFunction();
            tB.setTelefonBook(entryArea.getItems());
            try (FileOutputStream fos = new FileOutputStream(TelefonBook.path, false); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
				oos.writeObject(tB);
			} catch (Exception e) {
				e.printStackTrace();
			}

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

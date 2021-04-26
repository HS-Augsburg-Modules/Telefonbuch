package telefonbuch;

import javafx.collections.FXCollections;
import javafx.scene.layout.BorderPane;

import java.io.File;

public class PhoneBookContainer {

    //VARIABLES
    private File path = new File("data.json");
    private TelefonBook tB = new TelefonBook(this);
    private BorderPane root = new BorderPane();
    private SearchArea searchArea = new SearchArea(this);
    private EntryArea entryArea = new EntryArea(FXCollections.observableArrayList(tB.getTelefonBook()), this);
    private UserInputArea inputArea = new UserInputArea(this);


    //METHODS
    public PhoneBookContainer() {
//    	Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        initialize(path);
        root.setTop(searchArea.getPane());
        root.setCenter(entryArea.getAnchorPane());
        root.setBottom(inputArea.getGridPane());
        entryArea.setItems(tB.getTelefonBook());
    }


    /**
     * Reading in serialized Objects and initializing the phone book
     */
    private void initialize(File path) {
        tB.setTelefonBook(GsonIO.readGSON(path).getTelefonBook());
        Thread writingHook = new Thread(() -> writeTb());
        Runtime.getRuntime().addShutdownHook(writingHook);
    }

    public void loadTb() {
        try {
            tB.setTelefonBook(GsonIO.readGSON(path).getTelefonBook());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Save all Entry-Objects to the serialized phone book file.
     */
    public void writeTb() {
        try {
            File telefonBookFile = path;
            if (!telefonBookFile.exists()) {
                telefonBookFile.setReadable(true);
                telefonBookFile.setWritable(true);
                telefonBookFile.createNewFile();
            }
            searchArea.setSearchText("");
            searchArea.searchFunction();
            tB.setTelefonBook(entryArea.getItems());
            GsonIO.writeGSON(tB.getTB(), path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public File getPath() {
        return path;
    }

    public TelefonBook getTB() {
        return tB;
    }

    public SearchArea getSearchArea() {
        return searchArea;
    }

    public EntryArea getEntryArea() {
        return entryArea;
    }

    public UserInputArea getInputArea() {
        return inputArea;
    }

    public BorderPane getBorderPane() {
        return root;
    }
}


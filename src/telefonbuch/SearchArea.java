package telefonbuch;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SearchArea {
    //CONSTRUCTORS
    //VARIABLES
    //METHODS
    private final AnchorPane anchorPane = new AnchorPane();
    private final TextField searchTextField = new TextField();
    private final Button searchButton = new Button("Search");
    private final Button loadButton = new Button("Load");
    private final Button saveButton = new Button("Save");
    private PhoneBookContainer controller;

    public String getSearchText() {
        return searchTextField.getText();
    }

    public void setSearchText(String text) {
        searchTextField.setText(text);
    }

    public SearchArea(PhoneBookContainer controller) {
        this.controller = controller;

        AnchorPane.setLeftAnchor(searchTextField, 10.0);
        AnchorPane.setTopAnchor(searchTextField, 10.0);
        AnchorPane.setRightAnchor(searchTextField, 190.0);
        AnchorPane.setBottomAnchor(searchTextField, 10.0);

        AnchorPane.setTopAnchor(searchButton, 10.0);
        AnchorPane.setRightAnchor(searchButton, 130.0);
        AnchorPane.setBottomAnchor(searchButton, 10.0);
        
        AnchorPane.setTopAnchor(saveButton, 10.0);
        AnchorPane.setRightAnchor(saveButton, 70.0);
        AnchorPane.setBottomAnchor(saveButton, 10.0);

        AnchorPane.setTopAnchor(loadButton, 10.0);
        AnchorPane.setRightAnchor(loadButton, 10.0);
        AnchorPane.setBottomAnchor(loadButton, 10.0);


		searchButton.setOnAction((ActionEvent event) -> searchFunction());
		saveButton.setOnAction((ActionEvent event) -> saveFunction());
		loadButton.setOnAction((ActionEvent event) -> loadFunction());
        anchorPane.getChildren().addAll(searchTextField, searchButton, saveButton, loadButton);
    }

    /**
     * Function for searching through the entries of the phone book (filtered)
     */
    public void searchFunction() {
        controller.getEntryArea().setItems(controller.getTB().getFilteredTelefonBook());
    }
    
    /**
     * Function for searching through the entries of the phone book (filtered)
     */
    public void loadFunction() {
        controller.loadTb();
    }
    
    /**
     * Function for searching through the entries of the phone book (filtered)
     */
    public void saveFunction() {
        controller.writeTb();
    }

    public Node getPane() {
        return anchorPane;
    }
}
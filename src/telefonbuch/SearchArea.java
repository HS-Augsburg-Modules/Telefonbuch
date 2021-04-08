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
    
    public String getSearchText() {
    	return searchTextField.getText();
    }
    
    public void setSearchText(String text) {
    	searchTextField.setText(text);
    }

    public SearchArea() {
        AnchorPane.setLeftAnchor(searchTextField, 10.0);
        AnchorPane.setTopAnchor(searchTextField, 10.0);
        AnchorPane.setRightAnchor(searchTextField, 90.0);
        AnchorPane.setBottomAnchor(searchTextField, 10.0);

        AnchorPane.setTopAnchor(searchButton, 10.0);
        AnchorPane.setRightAnchor(searchButton, 10.0);
        AnchorPane.setBottomAnchor(searchButton, 10.0);


		searchButton.setOnAction((ActionEvent event) -> searchFunction());
        anchorPane.getChildren().addAll(searchTextField, searchButton);
    }

    /**
     * Function for searching through the entries of the phone book (filtered)
     */
    public void searchFunction() {
    	Main.getEntryArea().setItems(Main.getTB().getFilteredTelefonBook());
    }

    public Node getPane() {
        return anchorPane;
    }
}
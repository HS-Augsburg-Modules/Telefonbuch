package telefonbuch;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserInputArea {
    private final GridPane gridPane = new GridPane();

    public UserInputArea() {
    	gridPane.setMaxWidth(335);
    	gridPane.setMaxHeight(15);
    	TextField first = new TextField();    	
    	TextField last = new TextField();
    	TextField number = new TextField();
    	first.setPromptText("Vorname");
    	last.setPromptText("Nachname");
    	number.setPromptText("Nummer");
    	Button save = new Button("Save");
    	gridPane.getChildren().addAll(first, last, number, save);
    	GridPane.setColumnIndex(last, 1);
    	GridPane.setColumnIndex(number, 2);
    	GridPane.setColumnIndex(save, 3);
    	gridPane.setPadding(new Insets(0,10,0,10));
    }
    
    public GridPane getGridPane() {
		return gridPane;
	}

}
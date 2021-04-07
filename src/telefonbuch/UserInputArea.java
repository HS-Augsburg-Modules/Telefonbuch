package telefonbuch;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserInputArea {
	private final GridPane gridPane = new GridPane();

	TextField first = new TextField();
	TextField last = new TextField();
	TextField number = new TextField();
	Button save = new Button("+");
	private TelefonEntry entry = new TelefonEntry("", "", "");

	public TelefonEntry getEntry() {
		return entry;
	}

	public void setEntry(TelefonEntry entry) {
		this.entry = entry;
		updateBecauseBindSucks();
	}

	public void updateBecauseBindSucks() {
		first.setText(entry.getFirstName());
		last.setText(entry.getLastName());
		number.setText(entry.getNumber());
	}

	public UserInputArea() {
		gridPane.setMaxWidth(335);
		gridPane.setMaxHeight(15);
		first.setPromptText("First Name");
		last.setPromptText("Last Name");
		number.setPromptText("Number");
		
		save.setOnAction((ActionEvent event) -> updateOrSave());
		gridPane.getChildren().addAll(first, last, number, save);
		GridPane.setColumnIndex(last, 1);
		GridPane.setColumnIndex(number, 2);
		GridPane.setColumnIndex(save, 3);
		first.setMaxWidth(96);
		first.setPrefWidth(96);
		last.setMaxWidth(96);
		last.setPrefWidth(96);
		number.setMaxWidth(96);
		number.setPrefWidth(96);
		save.setMaxWidth(25);
		save.setPrefWidth(25);
		gridPane.setPadding(new Insets(0, 10, 0, 10));
	}

	private void updateOrSave() {
		entry.setFirstName(first.getText());
		entry.setLastName(last.getText());
		entry.setNumber(number.getText());
		if (Main.getEntryArea().getCurrentSelectedEntry() != -1) {
			// Update
			Main.getEntryArea().updateItems(Main.getEntryArea().getCurrentSelectedEntry(), getEntry());
		} else {
			Main.getEntryArea().addItem(getEntry());
			Main.getTB().getTelefonBook().add(getEntry());
			// Save
		}
		setEntry(new TelefonEntry("", "", ""));
		Main.getEntryArea().resetCurrentSelectedEntry();
		save.setText("+");

	}

	public GridPane getGridPane() {
		return gridPane;
	}
	
	public void ChangeButtonText() {
		save.setText("U");
	}

}
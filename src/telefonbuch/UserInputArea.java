package telefonbuch;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UserInputArea {
	//CONSTRUCTORS

	private PhoneBookContainer controller;

	//VARIABLES

	public UserInputArea(PhoneBookContainer controller) {
		this.controller = controller;
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
	TextField first = new TextField();
	TextField last = new TextField();
	TextField number = new TextField();
	Button save = new Button("+");
	private TelefonEntry entry = new TelefonEntry("", "", "");
	private final GridPane gridPane = new GridPane();

	//METHODS

	public TelefonEntry getEntry() {
		return entry;
	}

	public void setEntry(TelefonEntry entry) {
		this.entry = entry;
		updateBecauseBindSucks();
	}

	/**
	 * Using the update method instead of String binding.
	 */
	public void updateBecauseBindSucks() {
		first.setText(entry.getFirstName());
		last.setText(entry.getLastName());
		number.setText(entry.getNumber());
	}

	/**
	 * Differentiates between editing a selected entry or creating a new one
	 */
	private void updateOrSave() {
		entry.setFirstName(first.getText());
		entry.setLastName(last.getText());
		entry.setNumber(number.getText());
		if (controller.getEntryArea().getCurrentSelectedEntry() != -1) {
			// Update
			controller.getEntryArea().updateItems(controller.getEntryArea().getCurrentSelectedEntry(), getEntry());
		} else {
			controller.getEntryArea().addItem(getEntry());
			controller.getTB().getTelefonBook().add(getEntry());
			// Save
		}
		setEntry(new TelefonEntry("", "", ""));
		controller.getEntryArea().resetCurrentSelectedEntry();
		save.setText("+");

	}

	public UserInputArea getInputArea() {
		return this;
	}

	public GridPane getGridPane() {
		return gridPane;
	}

	public void ChangeButtonText() {
		save.setText("U");
	}

}
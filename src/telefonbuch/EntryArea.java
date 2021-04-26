package telefonbuch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.util.ArrayList;
import java.util.List;

public class EntryArea {

	//CONSTRUCTORS

	//VARIABLES
	private PhoneBookContainer controller;

	/**
	 * Constructor that builds a GUI for the given phone book
	 * Creating a proper window with an appropriate size
	 * Possibility to edit a cell and its content
	 * Possibility to add a entry into to phone book by filling in the new entries appropriate cells.
	 * Every cell gets updated after the content is added (using the row index)
	 *
	 * @param telefonEntries
	 */
	public EntryArea(ObservableList<TelefonEntry> telefonEntries, PhoneBookContainer controller) {
		this.controller = controller;
		tableView = new TableView<>();
		AnchorPane.setLeftAnchor(tableView, 10.0);
		AnchorPane.setRightAnchor(tableView, 10.0);
		AnchorPane.setTopAnchor(tableView, 0.0);
		AnchorPane.setBottomAnchor(tableView, 0.0);
		anchorPane.getChildren().addAll(tableView);

		Callback<TableColumn<TelefonEntry, String>, TableCell<TelefonEntry, String>> cellFactory = p -> new EditingCell();

		TableColumn<TelefonEntry, String> lastNameCol = new TableColumn<>("Last Name");
		lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
		lastNameCol.setCellFactory(cellFactory);
		lastNameCol.setOnEditStart(t -> setUpdate(getCurrentRowIndex(t)));
		lastNameCol.setMaxWidth(96);
		lastNameCol.setPrefWidth(96);

		TableColumn<TelefonEntry, String> firstNameCol = new TableColumn<>("First Name");
		firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
		firstNameCol.setCellFactory(cellFactory);
		firstNameCol.setOnEditStart(t -> setUpdate(getCurrentRowIndex(t)));
		firstNameCol.setMaxWidth(96);
		firstNameCol.setPrefWidth(96);

		TableColumn<TelefonEntry, String> numberCol = new TableColumn<>("Number");
		numberCol.setCellValueFactory(new PropertyValueFactory<>("number"));
		numberCol.setCellFactory(cellFactory);
		numberCol.setOnEditStart(t -> setUpdate(getCurrentRowIndex(t)));
		numberCol.setMaxWidth(96);
		numberCol.setPrefWidth(96);

		TableColumn<TelefonEntry, Void> deleteCol = new TableColumn<>(" ");
		deleteCol.setMaxWidth(25);
		deleteCol.setPrefWidth(25);
		Callback<TableColumn<TelefonEntry, Void>, TableCell<TelefonEntry, Void>> buttonFactory = new Callback<TableColumn<TelefonEntry, Void>, TableCell<TelefonEntry, Void>>() {
			@Override
			public TableCell<TelefonEntry, Void> call(final TableColumn<TelefonEntry, Void> param) {
				final TableCell<TelefonEntry, Void> cell = new TableCell<TelefonEntry, Void>() {
					private final Button btn = new Button("Action");

					{
						btn.setOnAction((ActionEvent event) -> controller.getTB().removeEntry(getTableView().getItems().get(getIndex())));
						btn.setText("-");
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
						}
					}
				};
				return cell;
			}
		};
		deleteCol.setCellFactory(buttonFactory);

		tableView.getColumns().add(firstNameCol);
		tableView.getColumns().add(lastNameCol);
		tableView.getColumns().add(numberCol);
		tableView.getColumns().add(deleteCol);
		tableView.setItems(telefonBook);
		tableView.setEditable(true);
	}
	private final AnchorPane anchorPane = new AnchorPane();
	private final TableView<TelefonEntry> tableView;
	private final ObservableList<TelefonEntry> telefonBook = FXCollections.observableArrayList();
	private int currentSelectedEntry = -1;

	//METHODS

	public int getCurrentSelectedEntry() {
		return currentSelectedEntry;
	}

	public void resetCurrentSelectedEntry() {
		currentSelectedEntry = -1;
	}


	/**
	 * Add one Entry to the main phone book
	 * @param item
	 */
	public void addItem(TelefonEntry item) {
		telefonBook.add(item);
	}

	/**
	 * Add list of entries to main phone book.
	 * @param items
	 */
	public void addItems(List<TelefonEntry> items) {
		telefonBook.addAll(items);
	}
	
	public void updateItems(int index, TelefonEntry items) {
		telefonBook.set(index, items);
	}

	public void setItems(List<TelefonEntry> items) {
		telefonBook.clear();
		telefonBook.addAll(items);
	}

	public ArrayList<TelefonEntry> getItems() {
		return new ArrayList<TelefonEntry>(telefonBook);
	}

	public AnchorPane getAnchorPane() {
		return anchorPane;
	}

	public ObservableList<TelefonEntry> getSelectedEntries() {
		return tableView.getSelectionModel().getSelectedItems();
	}

	private static Integer getCurrentRowIndex(TableColumn.CellEditEvent<TelefonEntry, String> t) {
		return t.getTablePosition().getRow();
	}

	public void setUpdate(Integer entry) {
		currentSelectedEntry = entry;
		controller.getInputArea().setEntry(tableView.getItems().get(currentSelectedEntry));
		controller.getInputArea().ChangeButtonText();
	}

	//SUBCLASSES

	/**
	 * Class for editing cells of the entries of the phone book.
	 */
	private static class EditingCell extends TableCell<TelefonEntry, String> {

		private TextField textField;

		@Override
		public void updateItem(String item, boolean empty) {
			super.updateItem(item, empty);

			if (empty) {
				setText(null);
				setGraphic(null);
			} else {
				if (isEditing()) {
					if (textField != null) {
						textField.setText(getString());
					}
					setText(null);
					setGraphic(textField);
				} else {
					setText(getString());
					setGraphic(null);
				}
			}
		}

		private String getString() {
			return getItem() == null ? "" : getItem();
		}
	}

}
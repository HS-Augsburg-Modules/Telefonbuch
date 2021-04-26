package telefonbuch;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelefonBook {

	//CONSTRUCTORS

	private PhoneBookContainer controller;


	//VARIABLES
	private List<TelefonEntry> telefonBook = new ArrayList<TelefonEntry>();

	public TelefonBook(PhoneBookContainer controller) {
		this.controller = controller;
	}
	//METHODS

	public TelefonBook getTB() {
		return this;
	}

	public List<TelefonEntry> getTelefonBook() {
		return telefonBook;
	}

	public void setTelefonBook(List<TelefonEntry> telefonBook) {
		this.telefonBook = telefonBook;
	}

	/**
	 * Method to return filtered phone book when searching for a specific entry. (Case Sensitive)
	 * @return
	 */
	public List<TelefonEntry> getFilteredTelefonBook() {
		if (!controller.getSearchArea().getSearchText().trim().isEmpty()) {
			return getTelefonBook().stream().filter(entry -> entry.getFirstName().contains(controller.getSearchArea().getSearchText()) || entry.getLastName().contains(controller.getSearchArea().getSearchText()) || entry.getNumber().contains(controller.getSearchArea().getSearchText())).collect(Collectors.toList());
		}
		return getTelefonBook();
	}

	/**
	 * Delete given Entry from the phone book
	 * @param entry
	 */
	public void removeEntry(TelefonEntry entry) {
		telefonBook.remove(entry);
		controller.getEntryArea().setItems(getFilteredTelefonBook());
	}

}
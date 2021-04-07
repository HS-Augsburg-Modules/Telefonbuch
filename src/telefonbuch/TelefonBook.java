package telefonbuch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelefonBook implements Serializable {

	private static final long serialVersionUID = 1L;
	public static String path = "tb.ser";

	private List<TelefonEntry> telefonBook = new ArrayList<TelefonEntry>();

	public List<TelefonEntry> getTelefonBook() {
		return telefonBook;
	}

	public void setTelefonBook(List<TelefonEntry> telefonBook) {
		this.telefonBook = telefonBook;
	}

	public List<TelefonEntry> getFilteredTelefonBook() {		
		if (!Main.getSearchArea().getSearchText().trim().isEmpty()) {
			return getTelefonBook().stream().filter(entry -> entry.getFirstName().contains(Main.getSearchArea().getSearchText()) || entry.getLastName().contains(Main.getSearchArea().getSearchText()) || entry.getNumber().contains(Main.getSearchArea().getSearchText())).collect(Collectors.toList());			
		}
		return getTelefonBook();
	}

	public void removeEntry(TelefonEntry entry) {
		telefonBook.remove(entry);
		Main.getEntryArea().setItems(getFilteredTelefonBook());
	}

}
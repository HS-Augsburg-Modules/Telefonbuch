package telefonbuch;

import java.io.Serializable;

public class TelefonEntry {

    //CONSTRUCTORS

    public TelefonEntry(String firstName, String lastName, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    //VARIABLES

    private static final long serialVersionUID = 1L;
    private String firstName = "";
    private String lastName = "";
    private String number = "";
    
    //METHODS

    @Override
	public String toString() {
		return "TelefonEntry [firstName=" + firstName + ", lastName=" + lastName + ",  number=" + number + "]";
	}

	public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

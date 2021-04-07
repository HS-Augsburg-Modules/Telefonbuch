package telefonbuch;

import java.io.Serializable;

public class TelefonEntry implements Serializable {

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
    private String street = "";
    private int streetNumber = 0;
    private String number = "";
    private String co = "";
    private int zipcode = 0;
    private String city = "";
    
    //METHODS

    @Override
	public String toString() {
		return "TelefonEntry [firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", streetNumber=" + streetNumber + ", number=" + number + ", co=" + co + ", zipcode=" + zipcode + ", city=" + city + "]";
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

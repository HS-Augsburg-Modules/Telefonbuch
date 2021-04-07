package telefonbuch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TelefonBook implements Serializable {

    private static final long serialVersionUID = 1L;
    public static String path = "tb.ser";
    
    List<TelefonEntry> telefonBook = new ArrayList<TelefonEntry>();

}
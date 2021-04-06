package telefonbuch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class TelefonBook extends TreeMap<String, TelefonEntry> {

    private static final long serialVersionUID = 1L;
    public static String path = "tb.ser";
    
    List<TelefonEntry> telefonBook = new ArrayList<TelefonEntry>();

}